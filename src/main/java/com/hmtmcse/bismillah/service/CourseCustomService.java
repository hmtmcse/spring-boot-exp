package com.hmtmcse.bismillah.service;


import com.hmtmcse.bismillah.domain.Course;
import com.hmtmcse.bismillah.repository.CourseCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CourseCustomService {

    @Autowired
    private CourseCustomRepository courseCustomRepository;

    public Iterable<Course> getPaginationData(Sort.Direction direction, String column){
        return courseCustomRepository.findAll(Sort.by(direction, column));
    }

    public Iterable<Course> getPaginationData(String column){
        return getPaginationData(Sort.Direction.DESC, column);
    }


}
