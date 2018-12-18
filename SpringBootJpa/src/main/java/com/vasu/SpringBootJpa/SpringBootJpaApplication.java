package com.vasu.SpringBootJpa;

import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SpringBootJpaApplication {
    
    private static final Logger logger = Logger.getLogger("SpringBootJpaApplication.class");
    
    public static void main(String[] args) {
        logger.info("Main Running");
        SpringApplication.run(SpringBootJpaApplication.class, args);
    }
    
    public Docket productEndApi() {
        return new Docket(DocumentationType.SWAGGER_2).select().
                apis(RequestHandlerSelectors.basePackage("com.vasu.SpringBootJpa"))
                .build();
    }
    
}
