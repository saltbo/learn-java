package com.example.demo.model;

import org.springframework.util.DigestUtils;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class User {

    @Id
    @GeneratedValue
    private Long id;

    @Column(nullable = false)
    private String uid;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    @Column(nullable = false)
    private String pwd;

    public User(String email, String pwd, String name) {
        this.name = name;
        this.email = email;
        this.pwd = pwd;
        this.setUid();
    }

    public User() {
    }

    public Long getId() {
        return this.id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    public String getUid() {
        return uid;
    }

    public void setUid() {
        this.uid = DigestUtils.md5DigestAsHex(String.format("%s-%s", name, email).getBytes());
    }

}
