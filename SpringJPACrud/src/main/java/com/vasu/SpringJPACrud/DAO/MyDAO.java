/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringJPACrud.DAO;

import com.vasu.SpringJPACrud.Model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author rv
 */
@Repository
public interface MyDAO extends CrudRepository<User, Long> {
    
}
