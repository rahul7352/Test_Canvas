package com.canvas.lms.canvaslms.exception;

public class CanvasApiException extends Throwable {
	
	private String message;

	public CanvasApiException(String message) {
		super();
		this.message = message;
	}
}
