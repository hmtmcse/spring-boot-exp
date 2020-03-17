package com.hmtmcse.bismillah.domain;

import javax.persistence.*;
import java.util.List;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    public Long id;
    public String name;
    public String faculty;
    public String description;

    @OneToMany(mappedBy = "department")
    public List<Student> students;
}
