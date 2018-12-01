package com.red.crawler;

import com.red.processor.UnitProcessor;
import org.springframework.context.ApplicationContext;
import org.apache.maven.shared.invoker.*;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.File;
import java.io.IOException;
import java.util.Arrays;

/**
 * Created by Liujunjie on 2018/11/4.
 */
public class RedCrawler {
    private UnitProcessor unitProcessor;
    public static void main(String[] args) throws IOException {
        RedCrawler redCrawler = new RedCrawler();
        redCrawler.initializeCrawler();
        redCrawler.crawling();

//        UnitService unitService = context.getBean(UnitService.class);
//        unitService.add();
    }

    private void initializeCrawler() {
        String projectPath = System.getProperty("user.dir");
        System.out.println(projectPath);
        InvocationRequest request = new DefaultInvocationRequest();
        request.setPomFile(new File( projectPath + "/pom.xml" ) );
        request.setGoals(Arrays.asList( "clean", "install" ) );

        Invoker invoker = new DefaultInvoker();
        invoker.setMavenHome(new File(System.getenv("M3_HOME")));
        try {
            invoker.execute(request);
        } catch (MavenInvocationException e) {
            e.printStackTrace();
        }

        ApplicationContext context =
                new ClassPathXmlApplicationContext("file:src/main/resources/META-INF/Spring-All-Module.xml");
        unitProcessor = context.getBean(UnitProcessor.class);
    }

    private void crawling() throws IOException {
        unitProcessor.crawlOpenUnitsFromZipcode();
    }
}
