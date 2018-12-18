package com.Vasu.SpringBootPaginationDemo;

import com.Vasu.SpringBootPaginationDemo.DAO.PersonRepositry;
import com.Vasu.SpringBootPaginationDemo.Model.Person;
import com.Vasu.SpringBootPaginationDemo.Service.PersonService;
import java.util.Iterator;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

@SpringBootApplication
public class SpringBootPaginationDemoApplication implements CommandLineRunner {

    @Autowired
    private PersonService service;
    @Autowired
    private PersonRepositry repo;

    private static final Logger logger = LoggerFactory.getLogger("SpringBootPaginationDemoApplication.class");

    public static void main(String[] args) {
        SpringApplication.run(SpringBootPaginationDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        logger.info("Command Line Runner Call");
        Iterable<Person> findAll = repo.findAll();
        logger.info(findAll.toString());
        List<Person> findByLastName = service.findByLastName("koku", new PageRequest(1, 1));
        logger.info("listSize= "+findByLastName.size());
        findByLastName.forEach(System.out::println);
    }

}
