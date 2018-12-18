/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.vasu.SpringBootJpaCrud.Model;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

/**
 *
 * @author Vasu Rajput
 */
@Entity
@Table(name = "Question1")
public class Question1 {

    @Id
    @Column(name = "QId")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long qid;

    @Column(name = "QName")
    private String qname;

    @ManyToMany(targetEntity = Answer1.class, cascade = CascadeType.ALL)
    @JoinTable(name = "Questions_Answers",
            joinColumns = {
                @JoinColumn(name = "Q_Id"),},
            inverseJoinColumns = {
                @JoinColumn(name = "ANS_ID")})
    private List<Answer1> answerList;

    public Question1() {
    }

    public Question1(String qname, List<Answer1> answerList) {
        this.qname = qname;
        this.answerList = answerList;
    }

    @Override
    public String toString() {
        return "Question1{" + "qid=" + qid + ", qname=" + qname + ", answerList=" + answerList + '}';
    }

    public long getQid() {
        return qid;
    }

    public void setQid(long qid) {
        this.qid = qid;
    }

    public String getQname() {
        return qname;
    }

    public void setQname(String qname) {
        this.qname = qname;
    }

    public List<Answer1> getAnswerList() {
        return answerList;
    }

    public void setAnswerList(List<Answer1> answerList) {
        this.answerList = answerList;
    }

}
