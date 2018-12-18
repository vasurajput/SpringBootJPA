/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootFileUpload.Dao;

import com.vasu.SpringBootFileUpload.Model.MyModel;
import org.springframework.data.repository.CrudRepository;

/**
 *
 * @author Vasu Rajput
 */
public interface MyDao extends CrudRepository<MyModel, Long> {
    
}
