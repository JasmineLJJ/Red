package com.red.sourceclient;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by Liujunjie on 10/28/18.
 */
public class RedfinClientImpl {


    private List<String> readZipcodes(String url) {
        File file = new File("zipcodes");
//        StringBuilder cookie = new StringBuilder();
        List<String> zipcodes = new LinkedList<String>();
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String st;
            while ((st = br.readLine()) != null) {
                zipcodes.add(st);
            }
            br.close();
        } catch (Exception e) {
            System.out.println("Reading zipcode from com.red.sourceclient.zipcodes.txt failed");
            e.printStackTrace();
        }
        return zipcodes;
    }

    public void test() {

    }
}
