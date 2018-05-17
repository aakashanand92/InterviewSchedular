package com.sapient.InterviewSchedular.service;

import java.util.List;
import java.util.Optional;

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

	public Integer createTimeSlotForCandidate(TimeSlot timeSlot, Integer candidateId) {
		timeSlot.setTimeSlotFor(CANDIDATE_CODE);
		timeSlot.setIdOfOwner(candidateId);
		dao.save(timeSlot);
		return timeSlot.getId();
	}

	public void deleteTimeSlotForInterviewer(Integer interviewerId) {
		dao.deleteTimeSlotForInterviewer(interviewerId);
	}

	public void deleteTimeSlotForCandidate(Integer candidateId) {
		dao.deleteTimeSlotForCandidate(candidateId);
	}

	public TimeSlot findTimeSlotById(Integer id) {
		Optional<TimeSlot> op = dao.findById(id);
		return op.isPresent() ? op.get() : null;

	}

	public List<TimeSlot> findTimeSlotByIntId(Integer interveiwerId) {
		return this.dao.findTimeSlotByIntId(interveiwerId);
	}

	public List<TimeSlot> findTimeSlotByCandId(Integer candidateId) {
		return this.dao.findTimeSlotByCandId(candidateId);
	}

}
