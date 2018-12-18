/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpaCrud.Controller;

import com.vasu.SpringBootJpaCrud.Model.Address1;
import com.vasu.SpringBootJpaCrud.Model.Employee1;
import com.vasu.SpringBootJpaCrud.Service.ManyToOneService;
import com.vasu.SpringBootJpaCrud.Service.MyService;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vasu Rajput
 */
@RestController
public class ManyToOneController {

    private static final Logger logger = Logger.getLogger("ManyToOneController.class");
    JSONParser parser = new JSONParser();
    JSONObject responseObj = new JSONObject();

    @Autowired
    private ManyToOneService service;

    @GetMapping("/manytoone")
    public JSONObject manyToOne() {

        try {

            Address1 add1 = new Address1();
            add1.setCity("Delhi");
            add1.setCountry("India");
            add1.setState("Delhi");

            Employee1 emp1 = new Employee1();
            emp1.setEmail("vasu@gmail.com");
            emp1.setName("Vasu Rajput");
            emp1.setAddress(add1);

            Employee1 emp2 = new Employee1();
            emp2.setEmail("konika@gmail.com");
            emp2.setName("Konika Rajput");
            emp2.setAddress(add1);

            Employee1 save = service.save(emp1);
            logger.info("saveStatus= " + save);

            Employee1 save2 = service.save(emp2);
            logger.info("saveStatus= " + save2);
            responseObj.put("code", 1);
            responseObj.put("message", "succesfully Insert Data");
            return responseObj;
        } catch (Exception e) {
            logger.error(e, e);
            responseObj.clear();
            responseObj.put("code", 500);
            responseObj.put("message", "Server Error");
            return responseObj;
        }
    }
}
