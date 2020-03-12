package com.hmtmcse.bismillah.service;

import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class EmCustomQuery {

    @PersistenceContext
    private EntityManager entityManager;


    public List<?> getAllCourse(){
       return entityManager.createQuery("SELECT course FROM Course course").getResultList();
    }


}
