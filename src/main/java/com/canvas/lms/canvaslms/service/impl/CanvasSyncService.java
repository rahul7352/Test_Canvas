package com.canvas.lms.canvaslms.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;

import com.canvas.lms.canvaslms.entity.CanvasAccount;
import com.canvas.lms.canvaslms.entity.CanvasCourse;
import com.canvas.lms.canvaslms.entity.Roster;
import com.canvas.lms.canvaslms.exception.CanvasApiException;
import com.canvas.lms.canvaslms.repo.CanvasAccountRepo;
import com.canvas.lms.canvaslms.repo.CanvasCourseRepo;
import com.canvas.lms.canvaslms.repo.RosterRepository;
import com.canvas.lms.canvaslms.service.ICanvasApiService;
import com.canvas.lms.canvaslms.service.ICanvasSyncService;

public class CanvasSyncService implements ICanvasSyncService {
	
	@Autowired
    private CanvasCourseRepo courseRepository;

    @Autowired
    private ICanvasApiService canvasApiService;
    
    @Autowired
    private CanvasAccountRepo accountRepository;

    @Autowired
    private RosterRepository rosterRepository;

    @Scheduled(fixedRate = 3600000)
    public void syncWithCanvas() throws CanvasApiException {
        try {
            List<Roster> latestRosters = canvasApiService.getRosters();

            List<Roster> existingRosters = rosterRepository.findAll();
            List<Roster> newCourses = new ArrayList<>();
            for (Roster latestRoster : latestRosters) {
                if (!existingRosters.contains(latestRoster)) {
                    newCourses.add(latestRoster);
                }
            }
            rosterRepository.saveAll(newCourses);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	@Override
	public void syncCanvas() throws CanvasApiException {
		List<CanvasAccount> accounts = canvasApiService.getCanvasAccounts();
		List<CanvasCourse> courses = canvasApiService.getCanvasCourses();
        accountRepository.saveAll(accounts);
        courseRepository.saveAll(courses);
	}
}
