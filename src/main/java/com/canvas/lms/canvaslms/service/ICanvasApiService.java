package com.canvas.lms.canvaslms.service;

import java.util.List;

import com.canvas.lms.canvaslms.entity.CanvasAccount;
import com.canvas.lms.canvaslms.entity.CanvasCourse;
import com.canvas.lms.canvaslms.entity.Roster;
import com.canvas.lms.canvaslms.exception.CanvasApiException;

public interface ICanvasApiService {
	
	List<Roster> getRosters() throws CanvasApiException;
	List<CanvasAccount> getCanvasAccounts() throws CanvasApiException;
	List<CanvasCourse> getCanvasCourses() throws CanvasApiException;

}
