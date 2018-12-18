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
import javax.persistence.Table;

/**
 *
 * @author Vasu Rajput
 */
@Entity
@Table(name = "Answer1")
public class Answer1 {

    @Id
    @Column(name = "AnsId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ansId;

    @Column(name = "Answer")
    private String answer;

    @Column(name = "PostedBy")
    private String postedBy;

    public Answer1() {
    }

    public Answer1(long ansId, String answer, String postedBy) {
        this.ansId = ansId;
        this.answer = answer;
        this.postedBy = postedBy;
    }

    @Override
    public String toString() {
        return "Answer1{" + "ansId=" + ansId + ", answer=" + answer + ", postedBy=" + postedBy + '}';
    }

    public long getAnsId() {
        return ansId;
    }

    public void setAnsId(long ansId) {
        this.ansId = ansId;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    public String getPostedBy() {
        return postedBy;
    }

    public void setPostedBy(String postedBy) {
        this.postedBy = postedBy;
    }

}
