/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpaCrud.DAO;

import com.vasu.SpringBootJpaCrud.Model.Employee1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vasu Rajput
 */
@Repository
public interface ManyToOneDao extends CrudRepository<Employee1, Long> {
    
}
