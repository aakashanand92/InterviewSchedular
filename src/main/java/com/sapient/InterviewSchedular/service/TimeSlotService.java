package com.sapient.InterviewSchedular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.InterviewSchedular.dao.TimeSlotRepo;
import com.sapient.InterviewSchedular.model.TimeSlot;

@Service
public class TimeSlotService {

	@Autowired
	private TimeSlotRepo dao;
	public static String CANDIDATE_CODE = "C";
	public static String INTERVIEWER_CODE = "I";
	public static String SCHEDULED_YES = "Y";
	public static String SCHEDULED_NO = "N";

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

	@Transactional
	public void deleteTimeSlotForInterviewer(Integer interviewerId) {
		dao.deleteTimeSlotForInterviewer(interviewerId);
	}

	@Transactional
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

	public List<TimeSlot> getAllTimeSlotsForCandidates() {
		return this.dao.getAllTimeSlotsForCandidates();
	}

	public List<TimeSlot> getAllTimeSlotsForInterviewers() {
		return this.dao.getAllTimeSlotsForInterviewers();
	}

	@Transactional
	public void setScheduled(List<Integer> slotIds) {
		this.dao.setScheduledForIds(slotIds);

	}

	@Transactional
	public void updateTimeSlot(TimeSlot timeSlot) {
		this.dao.save(timeSlot);
	}

	public void removeScheduled(Integer slotId) {
		// this.dao.save(this.dao.findById(slotId).get().setScheduled(SCHEDULED_NO));
	}
}
