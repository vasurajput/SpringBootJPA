package com.vasu.ExcelFileDemo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ExcelFileDemoApplication {

    private static final Logger logger = LoggerFactory.getLogger("ExcelFileDemoApplication.class");

    public static void main(String[] args) {
        logger.info("#### Inside Main ######");
        SpringApplication.run(ExcelFileDemoApplication.class, args);
    }
}
