package com.studentManagement.model;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.stereotype.Component;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.lang.annotation.Repeatable;

@Component
@Entity
public class Students {
    @Id
    private int id;
    private String email;
    private String frst_name;
    private String last_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFrst_name(){
        return frst_name;
    }

    public void  setFrst_name(String frst_name){
        this.frst_name = frst_name;
    }
    public  String getLast_name(){
        return last_name;
    }

    public void setLast_name(String last_name){
        this.last_name = last_name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
