/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.Vasu.SpringBootPaginationDemo.DAO;

import com.Vasu.SpringBootPaginationDemo.Model.Person;
import java.util.List;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vasu Rajput
 */
@Repository
public interface PersonRepositry extends CrudRepository<Person, Long> {

    List<Person> findByLastName(String lastName, Pageable pageable);
}
