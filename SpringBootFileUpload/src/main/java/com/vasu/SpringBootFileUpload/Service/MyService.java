/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootFileUpload.Service;

import com.vasu.SpringBootFileUpload.Dao.MyDao;
import com.vasu.SpringBootFileUpload.Model.MyModel;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.support.DaoSupport;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vasu Rajput
 */
@Service
public class MyService {

    private static final Logger logger = LoggerFactory.getLogger("MyService.class");
    @Autowired
    private MyDao dao;

    public int saveImage(MyModel model) {
        try {
            dao.save(model);
            return 1;
        } catch (Exception e) {
            logger.error("ERROR", e);
            return 0;
        }
    }

    public MyModel getImages(Long id) {
        Optional<MyModel> findById = dao.findById(id);
        if (findById.isPresent()) {
            MyModel getImageDetails = findById.get();
            logger.info("id= " + getImageDetails.getId() + " name= " + getImageDetails.getName());
            return getImageDetails;
        } else {
            return null;
        }
    }
}
