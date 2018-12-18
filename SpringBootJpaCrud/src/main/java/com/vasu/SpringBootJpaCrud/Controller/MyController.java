/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpaCrud.Controller;

import com.vasu.SpringBootJpaCrud.Model.Address;
import com.vasu.SpringBootJpaCrud.Model.Answer;
import com.vasu.SpringBootJpaCrud.Model.Employee;
import com.vasu.SpringBootJpaCrud.Model.Question;
import com.vasu.SpringBootJpaCrud.Service.MyService;
import java.util.ArrayList;
import java.util.List;
import org.apache.log4j.Logger;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vasu Rajput
 */
@RestController
public class MyController {

    private static final Logger logger = Logger.getLogger("MyController.class");
    JSONParser parser = new JSONParser();
    JSONObject responseObj = new JSONObject();

    @Autowired
    private MyService service;

    @GetMapping("/")
    public String test() {
        return "success";
    }

    //save OneToMany Relationship Details
    @PostMapping("/saveQuestion")
    public JSONObject saveQuestions(@RequestBody String payload) {
        if (payload == null) {
            responseObj.put("code", 0);
            responseObj.put("message", "insufficient Data");
            return responseObj;
        }
        logger.info("payload= " + payload);
        try {
            JSONObject questionObj = (JSONObject) parser.parse(payload);
            Answer answer1 = new Answer(questionObj.get("answer").toString().concat("1"), questionObj.get("postedby").toString());
            Answer answer2 = new Answer(questionObj.get("answer").toString().concat("2"), questionObj.get("postedby").toString());
            Answer answer3 = new Answer(questionObj.get("answer").toString().concat("3"), questionObj.get("postedby").toString());
            Answer answer4 = new Answer(questionObj.get("answer").toString().concat("4"), questionObj.get("postedby").toString());

            List<Answer> answeList = new ArrayList<Answer>();
            answeList.add(answer1);
            answeList.add(answer2);

            List<Answer> answeList2 = new ArrayList<Answer>();
            answeList2.add(answer3);
            answeList2.add(answer4);

            Question question = new Question(questionObj.get("question").toString(), answeList);
            Question question2 = new Question(questionObj.get("question").toString().concat("2"), answeList2);

            Question saveQuestions1 = service.saveQuestions(question);
            logger.info("saveStatus= " + saveQuestions1);

            Question saveQuestions2 = service.saveQuestions(question2);
            logger.info("saveStatus= " + saveQuestions2);
            responseObj.clear();
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
