package com.sapient.InterviewSchedular.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * This will contain the data that represents the interview that is scheduled by
 * the schedular. We will need to persist this.
 * 
 * @author aakanand1
 *
 */
@Entity
public class Interview {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;

	Integer candidateId;
	Integer interviewerId;
	Integer startTime;
	Integer endTime;
	String date;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(Integer candidateId) {
		this.candidateId = candidateId;
	}

	public Integer getInterviewerId() {
		return interviewerId;
	}

	public void setInterviewerId(Integer interviewerId) {
		this.interviewerId = interviewerId;
	}

	public Integer getStartTime() {
		return startTime;
	}

	public void setStartTime(Integer startTime) {
		this.startTime = startTime;
	}

	public Integer getEndTime() {
		return endTime;
	}

	public void setEndTime(Integer endTime) {
		this.endTime = endTime;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public String toString() {
		return ("Candidate ID is " + this.getCandidateId() + " interviwer's ID is " + this.getInterviewerId() + " from "
				+ this.getStartTime() + " to " + this.getEndTime() + " on " + this.getDate());
	}

}
