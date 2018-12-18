/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.HttpsDemo.Controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 *
 * @author vasu rajput
 */
@Controller
public class HomeController {

    private static final Logger logger = LoggerFactory.getLogger("HomeController.class");

    @GetMapping("/")
    public String test() {
        logger.info("Test Controller Call");
        return "index";
    }
}
