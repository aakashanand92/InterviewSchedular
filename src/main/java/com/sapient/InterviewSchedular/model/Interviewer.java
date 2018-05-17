package com.sapient.InterviewSchedular.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

@Entity
public class Interviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	String name;

	String priority;

	@Transient
	List<TimeSlot> timeSlotList;

	String supervisor;

	public Interviewer() {

	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<TimeSlot> getTimeSlotList() {
		return timeSlotList;
	}

	public String getSupervisor() {
		return supervisor;
	}

	public void setSupervisor(String superVisor) {
		this.supervisor = superVisor;
	}

	public void setTimeSlotList(List<TimeSlot> timeSlotList) {
		this.timeSlotList = timeSlotList;
	}

	public void addTimeSlotToList(TimeSlot timeSlot) {
		this.timeSlotList.add(timeSlot);
	}

}
