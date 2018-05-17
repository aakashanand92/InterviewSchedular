package com.sapient.InterviewSchedular.model;

public class Interview {

	Integer candidateId;
	Integer interviewerId;
	Integer startTime;
	Integer endTime;
	String date;

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
