package com.sapient.InterviewSchedular.service;

import java.util.List;

import javax.inject.Inject;

import org.springframework.stereotype.Service;

import com.sapient.InterviewSchedular.dao.InterviewerRepo;
import com.sapient.InterviewSchedular.model.Interviewer;
import com.sapient.InterviewSchedular.model.TimeSlot;

@Service
public class InterviewerService {
	@Inject
	InterviewerRepo dao;

	public void createInterviewer(Interviewer interviewer) {
		dao.save(interviewer);
	}

	public void deleteInterviewerById(Integer id) {
		dao.deleteById(id);
	}

	public void getInterviewerById(Integer id) {

	}

	public void getTimeSlotOfInterviewer(Integer id) {

	}

	public void addTimeSlotsForInterviewer(List<TimeSlot> timeSlot, Integer id) {

	}

}
