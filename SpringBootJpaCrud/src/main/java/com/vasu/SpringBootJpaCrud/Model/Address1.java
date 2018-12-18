/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpaCrud.Model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Vasu Rajput
 */
@Entity
@Table(name = "Address1")
public class Address1 {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID")
    private long id;

    @Column(name = "City")
    private String city;

    @Column(name = "State")
    private String state;

    @Column(name = "Country")
    private String country;

    @OneToOne
    private Employee1 employee;

    public Address1() {
    }

    public Address1(String city, String state, String country, Employee1 employee) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.employee = employee;
    }

    @Override
    public String toString() {
        return "Address1{" + "id=" + id + ", city=" + city + ", state=" + state + ", country=" + country + ", employee=" + employee + '}';
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Employee1 getEmployee() {
        return employee;
    }

    public void setEmployee(Employee1 employee) {
        this.employee = employee;
    }

}
