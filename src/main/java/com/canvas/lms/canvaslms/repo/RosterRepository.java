package com.canvas.lms.canvaslms.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.canvas.lms.canvaslms.entity.Roster;

@Repository
public interface RosterRepository extends JpaRepository<Roster, Long> {

}
