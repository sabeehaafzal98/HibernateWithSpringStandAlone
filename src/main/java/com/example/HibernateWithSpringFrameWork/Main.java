package com.example.HibernateWithSpringFrameWork;

import org.h2.tools.Server;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) throws Exception {



        Server webServer = Server.createWebServer("-web", "-webAllowOthers", "-webPort", "8081").start();

        // Use ConfigurableApplicationContext so we can control when it closes
        ConfigurableApplicationContext context = new ClassPathXmlApplicationContext("spring-config.xml");

        // Your logic here (e.g., saving a Branch)
        BranchService service = context.getBean(BranchService.class);
        service.saveBranch(new Branch("CSE"));

        // Keep the context (and H2 DB) alive
        System.out.println("App is running. Open H2 Console and press Enter to exit...");
        System.in.read();

        // Now close the context (and DB)
        context.close();
        webServer.stop();
    }
}
