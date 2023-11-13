package com.canvas.lms.canvaslms.service;

import com.canvas.lms.canvaslms.exception.CanvasApiException;

public interface ICanvasSyncService {
	
	void syncWithCanvas() throws CanvasApiException;
	void syncCanvas() throws CanvasApiException;

}
