/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringJPACrud.Service;

import com.vasu.SpringJPACrud.DAO.MyDAO;
import com.vasu.SpringJPACrud.Model.User;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vasu Rajput
 */
@Service
public class MyService {
    
    private static final Logger logger = LoggerFactory.getLogger("MyService.class");
    @Autowired
    private MyDAO dao;
    
    public void getAllUsers() {
        Iterable<User> findAll = dao.findAll();
        List<User> list = new ArrayList<User>();
        for (User user : findAll) {
            logger.info("user= " + user.toString());
            
        }
    }
    
    public User saveData(User user) {
        try {
            User saveUser = dao.save(user);
            return saveUser;
        } catch (Exception e) {
            logger.error("Error", e);
            return null;
        }
    }
    
    public void deleteById(Long id) {
        dao.deleteById(id);
        logger.info("succesfully deleted");
    }
    
    public void update(Long id) {
        try {
            Optional<User> findById = dao.findById(id);
            if (findById.isPresent()) {
                User user = findById.get();
                user.setEmailId("vasuLoveKonika@VasuKoku.com");
                dao.save(user);
                logger.info("successfully Update data");
            }
            
        } catch (Exception e) {
            logger.error("ERROR", e);
        }
        
    }
}
