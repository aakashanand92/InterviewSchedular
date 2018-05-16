package com.sapient.InterviewSchedular.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sapient.InterviewSchedular.dao.TimeSlotRepo;
import com.sapient.InterviewSchedular.model.TimeSlot;

@Service
public class TimeSlotService {

	@Inject
	private TimeSlotRepo dao;
	private static String CANDIDATE_CODE = "C";
	private static String INTERVIEWER_CODE = "I";

	public Integer createTimeSlotForInterviewer(TimeSlot timeSlot, Integer interviewerID) {
		timeSlot.setTimeSlotFor(INTERVIEWER_CODE);
		timeSlot.setIdOfOwner(interviewerID);
		dao.save(timeSlot);
		return timeSlot.getId();
	}

	public void createTimeSlotForCandidate() {

	}

	public void deleteTimeSlotForInterviewer(Integer interviewerId) {
		dao.deleteTimeSlotOfInterviewer(interviewerId);
	}

	public void deleteTimeSlotForCandidate() {

	}

	public void findTimeSlotById() {

	}

	public List<TimeSlot> findTimeSlotByIntId(Integer interveiwerId) {
		return this.dao.findTimeSlotByIntId(interveiwerId);
	}

	public void findTimeSlotByCandId() {

	}

}
