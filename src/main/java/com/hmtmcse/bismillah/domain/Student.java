package com.hmtmcse.bismillah.domain;


import javax.persistence.*;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    public String name;
    public String identity;
    public String email;
    public String password;

    @ManyToOne()
    public Department department;

}
