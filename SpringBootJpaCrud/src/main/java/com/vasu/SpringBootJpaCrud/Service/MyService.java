/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpaCrud.Service;

import com.vasu.SpringBootJpaCrud.DAO.MyDao;
import com.vasu.SpringBootJpaCrud.Model.Question;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vasu Rajput
 */
@Service
public class MyService {

    private static final Logger logger = Logger.getLogger("MyService.class");
    @Autowired
    private MyDao dao;

    public Question saveQuestions(Question question) {
        Question save = dao.save(question);
        return save;
    }
}
