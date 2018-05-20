package com.sapient.InterviewSchedular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.InterviewSchedular.dao.CandidateRepo;
import com.sapient.InterviewSchedular.model.Candidate;
import com.sapient.InterviewSchedular.model.TimeSlot;

@Service
public class CandidateService {

	@Autowired
	CandidateRepo dao;
	@Autowired
	TimeSlotService timeSlotService;

	public void createCandidate(Candidate candidate) {
		dao.save(candidate);
	}

	public void deleteCandidateById(Integer id) {
		dao.deleteById(id);
		timeSlotService.deleteTimeSlotForCandidate(id);
	}

	public Candidate getCandidateById(Integer id) {
		Optional<Candidate> op = dao.findById(id);
		return op.isPresent() ? op.get() : null;
	}

	public List<TimeSlot> getTimeSlotForCandidate(Integer candidateId) {
		return timeSlotService.findTimeSlotByCandId(candidateId);
	}

	public void addTimeSlotsForCandidate(List<TimeSlot> timeSlotList, Integer id) {
		String priority = getCandidateById(id).getPriority();
		for (TimeSlot ts : timeSlotList) {
			ts.setPriority(priority);
			timeSlotService.createTimeSlotForCandidate(ts, id);
		}
	}

}
