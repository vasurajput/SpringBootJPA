/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Vasu.SpringBootPaginationDemo.Service;

import com.Vasu.SpringBootPaginationDemo.DAO.PersonRepositry;
import com.Vasu.SpringBootPaginationDemo.Model.Person;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vasu Rajput
 */
@Service
public class PersonService {

    @Autowired
    private PersonRepositry repositry;

    public List<Person> findByLastName(String lastName, Pageable pageable) {
        return repositry.findByLastName(lastName, pageable);
    }
}
