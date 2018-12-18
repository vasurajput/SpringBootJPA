/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringJPACrud.Controller;

import com.vasu.SpringJPACrud.Model.User;
import com.vasu.SpringJPACrud.Service.MyService;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rv
 */
@RestController
public class MyController {

    private static final Logger logger = LoggerFactory.getLogger("MyController.class");
    @Autowired
    private MyService service;
    JSONParser parser = new JSONParser();

    @GetMapping("/")
    public String test() {
        service.getAllUsers();
        return "success";
    }

    @PostMapping("/save")
    public String saveUser(@RequestBody String payload) {
        if (payload == null) {
            return "insufficient data";
        }
        logger.info("payload= " + payload);
        try {
            JSONObject jobj = (JSONObject) parser.parse(payload);
            logger.info("jobj= " + jobj);
            User user = new User();
            user.setEmailId(jobj.get("email").toString());
            user.setPassword(jobj.get("password").toString());
            user.setRole(Integer.parseInt(jobj.get("role").toString()));

            User saveData = service.saveData(user);
            return "succesfully inserted into database";

        } catch (Exception e) {
            logger.error("Error", e);
        }
        return "Server Error";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        if (id == null) {
            return "insufficient data";
        }
        try {
            logger.info("id= " + id);
            service.deleteById(Long.parseLong(id));
            return "success";
        } catch (Exception e) {
            logger.error("ERROR", e);
            return "Internal Error";
        }
    }

    @PutMapping("/update/{id}")
    public String updateUser(@PathVariable("id") String id) {
        if (id == null) {
            return "insufficient data";
        }
        try {
            service.update(Long.parseLong(id));
            return "succesfully updated user data";
        } catch (Exception e) {
            // logger.error("ERROR", e);
            e.printStackTrace();
            return "Internal Error";
        }

    }
}
