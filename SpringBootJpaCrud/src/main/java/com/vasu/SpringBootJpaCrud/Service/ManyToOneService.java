/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpaCrud.Service;

import com.vasu.SpringBootJpaCrud.DAO.ManyToOneDao;
import com.vasu.SpringBootJpaCrud.Model.Employee1;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vasu Rajput
 */
@Service
public class ManyToOneService {

    private static final Logger logger = Logger.getLogger("ManyToOneService.class");
    @Autowired
    private ManyToOneDao dao;

    public Employee1 save(Employee1 employee) {
        try {
            Employee1 save = dao.save(employee);
            return save;
        } catch (Exception e) {
            logger.error(e, e);
            return null;
        }
    }
}
