package com.canvas.lms.canvaslms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canvas.lms.canvaslms.entity.CanvasCourse;

@Repository
public interface CanvasCourseRepo extends JpaRepository<CanvasCourse, Long> {

}
