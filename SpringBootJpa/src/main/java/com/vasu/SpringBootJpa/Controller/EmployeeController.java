/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpa.Controller;

import com.vasu.SpringBootJpa.Exception.ResourceNotFoundException;
import com.vasu.SpringBootJpa.Model.Employee;
import com.vasu.SpringBootJpa.Repositry.EmployeeRepositry;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.validation.Valid;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author Vasu Rajput
 */
@RestController
@RequestMapping("/api/v1")
public class EmployeeController {

    private static final Logger logger = Logger.getLogger("EmployeeController.class");

    @Autowired
    private EmployeeRepositry employeeRepositry;

    @GetMapping("/employess")
    public List<Employee> getAllEmployess() {
        List<Employee> findAll = employeeRepositry.findAll();
        return findAll;
    }

    //Get Employee By Id
    @GetMapping("/employees/{id}")
    public ResponseEntity<Employee> getEmployeeById(@PathVariable("id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepositry.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found For Id::" + employeeId));
        return ResponseEntity.ok().body(employee);
    }

    //save Employee Details
    @PostMapping("/employess")
    public Employee createEmployee(@Valid
            @RequestBody Employee employee
    ) {
        Employee saveEmployee = employeeRepositry.save(employee);
        return saveEmployee;
    }

    //Update Employee Details
    @PutMapping("/employees/{id}")
    public ResponseEntity<Employee> updateEmployee(@PathVariable("id") Long employeeId,
            @Valid @RequestBody Employee emp) throws ResourceNotFoundException {
        Employee employee = employeeRepositry.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found for this id:: " + employeeId));
        employee.setEmailId(emp.getEmailId());
        employee.setFirstName(emp.getFirstName());
        employee.setLastName(emp.getLastName());

        Employee updatedUser = employeeRepositry.save(employee);
        return ResponseEntity.ok(updatedUser);
    }

    @DeleteMapping("/employees/{id}")
    public Map<String, Boolean> deleteEmployee(@PathVariable("id") Long employeeId) throws ResourceNotFoundException {
        Employee employee = employeeRepositry.findById(employeeId).orElseThrow(() -> new ResourceNotFoundException("Employee Not Found for this id:: " + employeeId));
        employeeRepositry.delete(employee);
        Map<String, Boolean> response = new HashMap<>();
        response.put("deleted", Boolean.TRUE);
        return response;
    }
}
