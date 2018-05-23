package com.sapient.InterviewSchedular.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Represents the candidate details that needs to be registered in the system
 * 
 * @author aakanand1
 *
 */
@Entity
public class Candidate {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	String name;
	String priority;
	String email;
	String phoneNo;

	@Transient
	List<TimeSlot> timeSlotList;

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
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
