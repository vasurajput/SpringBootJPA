/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpa.Repositry;

import com.vasu.SpringBootJpa.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Vasu Rajput
 */
public interface EmployeeRepositry extends JpaRepository<Employee, Long> {

}
