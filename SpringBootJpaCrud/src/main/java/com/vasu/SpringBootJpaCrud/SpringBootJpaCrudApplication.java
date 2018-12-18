package com.vasu.SpringBootJpaCrud;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootJpaCrudApplication {
    
    private static final Logger logger = Logger.getLogger("SpringBootJpaCrudApplication.class");
    
    public static void main(String[] args) {
        logger.info("inside main function");
        SpringApplication.run(SpringBootJpaCrudApplication.class, args);
    }
}
