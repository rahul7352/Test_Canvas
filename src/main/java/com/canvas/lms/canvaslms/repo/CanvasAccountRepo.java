package com.canvas.lms.canvaslms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canvas.lms.canvaslms.entity.CanvasAccount;

@Repository
public interface CanvasAccountRepo extends JpaRepository<CanvasAccount, Long> {

}
