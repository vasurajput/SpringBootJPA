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
@Table(name = "Address")
public class Address {

    @Id
    @Column(name = "AddressId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long addressId;

    @Column(name = "City")
    private String city;

    @Column(name = "Name")
    private String state;

    @Column(name = "Country")
    private String country;

    @Column(name = "PinCode")
    private String pinCode;

    @OneToOne(targetEntity = Employee.class)
    private Employee employee;

    public Address() {
    }

    public Address(String city, String state, String country, String pinCode, Employee employee) {
        this.city = city;
        this.state = state;
        this.country = country;
        this.pinCode = pinCode;
        this.employee = employee;
    }

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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

    public String getPinCode() {
        return pinCode;
    }

    public void setPinCode(String pinCode) {
        this.pinCode = pinCode;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

}
