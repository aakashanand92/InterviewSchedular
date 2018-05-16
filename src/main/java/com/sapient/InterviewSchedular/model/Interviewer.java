package com.sapient.InterviewSchedular.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Interviewer {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE)
	Integer id;

	String name;
	String priorty;

	@OneToMany(mappedBy = "interviewer", cascade = CascadeType.PERSIST)
	List<TimeSlot> timeSlotList;

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

	public List<TimeSlot> getTimeSlotList() {
		return timeSlotList;
	}

	public String getSuperVisor() {
		return superVisor;
	}

	public void setSuperVisor(String superVisor) {
		this.superVisor = superVisor;
	}

	public void setTimeSlotList(List<TimeSlot> timeSlotList) {
		this.timeSlotList = timeSlotList;
	}

	public void addTimeSlotToList(TimeSlot timeSlot) {
		this.timeSlotList.add(timeSlot);
	}

}
