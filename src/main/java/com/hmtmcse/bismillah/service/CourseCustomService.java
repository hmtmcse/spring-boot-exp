package com.hmtmcse.bismillah.service;


import com.hmtmcse.bismillah.domain.Course;
import com.hmtmcse.bismillah.repository.CourseCustomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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

    public Page<Course> getWithPagination(Integer offset, Integer max, Sort.Direction direction, String column) {
        return courseCustomRepository.findAll(PageRequest.of(offset, max, Sort.by(direction, column)));
    }

}
