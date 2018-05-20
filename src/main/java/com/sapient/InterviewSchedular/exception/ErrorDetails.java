package com.sapient.InterviewSchedular.exception;

public class ErrorDetails {
	private String message;
	private String details;

	public ErrorDetails(String message, String details) {
		super();
		this.message = message;
		this.details = details;
	}
}