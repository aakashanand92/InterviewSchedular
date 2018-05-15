package com.sapient.InterviewSchedular.model;

import java.util.List;

public class Candidate {
	String name;
	String id;
	String priority;
	List<TimeSlot> timeSlotList;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPriority() {

		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public List<TimeSlot> getTimeSlotList() {
		return timeSlotList;
	}

	public void setTimeSlotList(List<TimeSlot> timeSlotList) {
		this.timeSlotList = timeSlotList;
	}

	public void addTimeSlotToList(TimeSlot timeSlot) {
		this.timeSlotList.add(timeSlot);
	}

}
