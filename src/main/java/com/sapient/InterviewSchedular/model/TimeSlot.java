package com.sapient.InterviewSchedular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import com.sapient.InterviewSchedular.rule.IRuleInput;
import com.sapient.InterviewSchedular.service.TimeSlotService;

@Entity
public class TimeSlot implements IRuleInput {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	Integer start;
	Integer end;
	String date;

	String timeSlotFor;
	Integer idOfOwner;

	String priority;
	String scheduled = TimeSlotService.SCHEDULED_NO;

	public String getScheduled() {
		return scheduled;
	}

	public void setScheduled(String scheduled) {
		this.scheduled = scheduled;
	}

	public String getPriority() {
		return priority;
	}

	public void setPriority(String priority) {
		this.priority = priority;
	}

	public Integer getIdOfOwner() {
		return idOfOwner;
	}

	public void setIdOfOwner(Integer idOfOwner) {
		this.idOfOwner = idOfOwner;
	}

	public Integer getStart() {
		return start;
	}

	public void setStart(Integer start) {
		this.start = start;
	}

	public Integer getEnd() {
		return end;
	}

	public void setEnd(Integer end) {
		this.end = end;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTimeSlotFor() {
		return timeSlotFor;
	}

	public void setTimeSlotFor(String timeSlotFor) {
		this.timeSlotFor = timeSlotFor;
	}

}
