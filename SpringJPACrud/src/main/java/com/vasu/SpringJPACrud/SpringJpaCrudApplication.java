package com.vasu.SpringJPACrud;

import org.hibernate.annotations.common.util.impl.LoggerFactory;
import org.slf4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringJpaCrudApplication {
    
    private static final Logger logger = org.slf4j.LoggerFactory.getLogger("SpringJpaCrudApplication.class");
    
    public static void main(String[] args) {
        logger.info("Inside Maine Method");
        SpringApplication.run(SpringJpaCrudApplication.class, args);
    }
}
