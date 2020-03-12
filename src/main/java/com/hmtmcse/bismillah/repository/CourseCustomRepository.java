package com.hmtmcse.bismillah.repository;

import com.hmtmcse.bismillah.domain.Course;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseCustomRepository extends JpaRepository<Course, Long> {
}
