package com.vasu.HttpsDemo;

import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

@SpringBootApplication
public class HttpsDemoApplication extends SpringBootServletInitializer{

    private static final Logger logger = LoggerFactory.getLogger("HttpsDemoApplication.class");

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(HttpsDemoApplication.class);
    }

    public static void main(String[] args) {
        logger.info("inside main function");
        final String uuId = UUID.randomUUID().toString();
        logger.info("UUID= "+ uuId);
        logger.info("UUIda1= "+ uuId.replace("-", ""));
        SpringApplication.run(HttpsDemoApplication.class, args);
    }


}
