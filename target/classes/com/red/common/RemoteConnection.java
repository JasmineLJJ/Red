package com.red.common;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.zip.GZIPInputStream;

import org.apache.commons.httpclient.*;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;

/**
 * Created by Liujunjie on 10/28/18.
 */
public class RemoteConnection {
    private final static String ACCEPT  = "accept";
    private final static String COOKIE = "cookie";
    private final static String USER_AGENT = "user-agent";
    private final static String USER_AGENT_VALUE = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_10_5) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36";
    private final static String ACCEPT_VALUE = "text/html,application/xhtml+xml,application/xml";
    private final static String HOSTNAME = "https://www.redfin.com";
    private final static String ZIPCODE_ENDPOINT = "zipcode/";
    private final static String GET =  "GET";
    private final static String SLASH = "/";
    private final static String UTF_8 = "UTF-8";
    private final static String AMP_ENCODED = "&amp;";
    private final static String AMP = "&";
    private final static String ACCEPT_ENCODING = "accept-encoding";
    private final static String ACCEPT_ENCODING_VALUE = "gzip, deflate, br";
    private final static String ACCEPT_GZIP_VALUE = "text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,image/apng,*/*;q=0.8";
    private final static String PATH = "path";
    private final static String METHOD = "method";
    private final static String AUTHORITY = "authority";
    private final static String AUTHORITY_VALUE = "www.redfin.com";
    private final static String SCHEME = "scheme";
    private final static String HTTPS = "https";
    private final static String NEW_LINE = "\n";

    private String cookie;

    private HttpMethod initializeDefaultHttpMethod(String url, Map<String, String> headers) {
        HttpMethod method = new GetMethod(url);
        method.getParams().setParameter(HttpMethodParams.RETRY_HANDLER, new DefaultHttpMethodRetryHandler(3, false));
        if (headers != null) {
            for (Map.Entry<String, String> entry : headers.entrySet()) {
                method.addRequestHeader(entry.getKey(), entry.getValue());
            }
        }
        addRequesHeader(ACCEPT, ACCEPT_VALUE, headers, method);
        addRequesHeader(USER_AGENT, USER_AGENT_VALUE, headers, method);
        if (cookie == null || cookie.length() == 0) {
            readCookie();
        }
        addRequesHeader(COOKIE, cookie, headers, method);
        return method;
    }

    public String fetchUnitRedfinDetailedPage(String url) {
        return defaultHttpClientCall(url);
    }

    public String fetchCSVFilePathFromZipcode(String zipcode) {
        String url = HOSTNAME + SLASH + ZIPCODE_ENDPOINT + zipcode;
        return extractCSVPath(defaultHttpClientCall(url));
    }

    private String defaultHttpClientCall(String url) {
        HttpMethod method = initializeDefaultHttpMethod(url, null);
        HttpClient client = new HttpClient();
        int statusCode = 0;
        try {
            statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("ERROR: failed to get page " + url);
            }
            return getResponseBody(method);

        } catch (IOException e) {
            System.err.println("ERROR: IOException");
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        if (statusCode != HttpStatus.SC_OK) {
            System.err.println("ERROR: Method failed: " + method.getStatusLine());
        }
        return null;
    }

    public String fetchCSVFileFromURL(String path) throws IOException {
        Map<String, String> headers = new HashMap<String, String>();
        headers.put(ACCEPT_ENCODING, ACCEPT_ENCODING_VALUE);
        headers.put(ACCEPT, ACCEPT_GZIP_VALUE);
        headers.put(PATH, path);
        headers.put(METHOD, GET);
        headers.put(AUTHORITY, AUTHORITY_VALUE);
        headers.put(SCHEME, HTTPS);
        HttpMethod method = initializeDefaultHttpMethod(HOSTNAME + path, headers);

        try {
            HttpClient client = new HttpClient();
            int statusCode = client.executeMethod(method);
            if (statusCode != HttpStatus.SC_OK) {
                System.err.println("ERROR: Method failed: " + method.getStatusLine());
            }
            String responseBody = getResponseBody(method);
            return responseBody;
        } catch (HttpException e) {
            System.err.println("ERROR: Fatal protocol violation: " + e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            System.err.println("ERROR: Fatal transport error: " + e.getMessage());
            e.printStackTrace();
        } finally {
            method.releaseConnection();
        }
        return null;
    }

    public String getResponseBody(HttpMethod method) throws IOException{
        Header contentEncoding = method.getResponseHeader("Content-Encoding");
        if(contentEncoding !=  null ){
            String acceptEncodingValue = contentEncoding.getValue();
            if(acceptEncodingValue.contains("gzip")){
                StringBuffer payload = new StringBuffer();
                GZIPInputStream zippedInputStream =  new GZIPInputStream(method.getResponseBodyAsStream());
                InputStreamReader inputStreamReader = new InputStreamReader(zippedInputStream);
                BufferedReader r = new BufferedReader(inputStreamReader);
                String line = null;
                while( (line =r.readLine()) != null){
                    payload.append(line);
                    payload.append('\n');
                }
                zippedInputStream.close();
                inputStreamReader.close();
                r.close();
                return payload.toString();
            }
        } else {
            Header contentType = method.getResponseHeader("Content-Type");
            if (contentType != null) {
                if ("text/html; charset=utf-8".equals(contentType.getValue())) {
                    StringBuffer payload = new StringBuffer();
                    InputStreamReader inputStreamReader = new InputStreamReader(method.getResponseBodyAsStream());
                    BufferedReader reader = new BufferedReader(inputStreamReader);
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        payload.append(line);
                    }
                    inputStreamReader.close();
                    reader.close();
                    return payload.toString();
                }
            }
        }
        return method.getResponseBodyAsString();
    }

    private void addRequesHeader(String key, String value, Map<String, String> headers, HttpMethod method) {
        if (headers == null || !headers.containsKey(key))   {
            method.addRequestHeader(key, value);
        }
    }

    private String extractCSVPath (String payload) {
        String container = "<a id=\"download-and-save\"";
        String href = "href=\"";
        int indexOfContainer = payload.indexOf(container);
        int indexOfHref = payload.indexOf(href, indexOfContainer);
        int indexOfQuote = payload.indexOf("\"", indexOfHref + href.length());
        return payload.substring(indexOfHref + href.length(), indexOfQuote);
    }

    private void readCookie() {
        try {
            String path = this.getClass().getClassLoader().getResource("").getPath();
            path = path.substring(0, path.indexOf("target")) + "src/main/java/com/red/common/cookie.txt";
            FileReader file = new FileReader(new File(path));
            StringBuilder cookie = new StringBuilder();
            BufferedReader br = new BufferedReader(file);
            String st;
            while ((st = br.readLine()) != null) {
                cookie.append(st);
            }
            this.cookie = cookie.toString();
            br.close();
        } catch (Exception e) {
            System.err.println("Reading cookie from cookie.txt failed");
            e.printStackTrace();
        }
    }
}
