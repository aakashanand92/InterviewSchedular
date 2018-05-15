package com.sapient.InterviewSchedular.model;

public class Interviewer {

	String name;
	String priorty;
	Integer id;
	TimeSlot timeSlot;
	String superVisor;

	public Interviewer() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriorty() {
		return priorty;
	}

	public void setPriorty(String priorty) {
		this.priorty = priorty;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TimeSlot getTimeSlot() {
		return timeSlot;
	}

	public String getSuperVisor() {
		return superVisor;
	}

	public void setSuperVisor(String superVisor) {
		this.superVisor = superVisor;
	}

	public void setTimeSlot(TimeSlot timeSlot) {
		this.timeSlot = timeSlot;
	}

}
