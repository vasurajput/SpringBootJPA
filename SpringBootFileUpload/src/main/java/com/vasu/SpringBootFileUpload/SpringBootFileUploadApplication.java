package com.vasu.SpringBootFileUpload;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;

/**
 *
 * @author Vasu Rajput
 */
@SpringBootApplication
public class SpringBootFileUploadApplication extends SpringBootServletInitializer {

    private static final Logger logger = LoggerFactory.getLogger("SpringBootFileUploadApplication.class");

    @Override
    protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
        return application.sources(SpringBootFileUploadApplication.class);
    }

    public static void main(String[] args) {
        System.out.println("Inside Main Method");
        SpringApplication.run(SpringBootFileUploadApplication.class, args);
    }
}
