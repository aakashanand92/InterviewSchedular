package com.sapient.InterviewSchedular.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.InterviewSchedular.dao.CandidateRepo;
import com.sapient.InterviewSchedular.model.Candidate;
import com.sapient.InterviewSchedular.model.TimeSlot;

/**
 * The service class that handles are the candidate related business logic and
 * takes care of DAO calls
 * 
 * @author aakanand1
 *
 */
@Service
public class CandidateService {

	@Autowired
	CandidateRepo dao;
	@Autowired
	TimeSlotService timeSlotService;

	/**
	 * Method to create the candidate in the database
	 * 
	 * @param Candidate
	 *            to be created
	 * 
	 * @return ID of the candidate created
	 */
	public Integer createCandidate(Candidate candidate) {
		dao.save(candidate);
		return candidate.getId();
	}

	/**
	 * Deletes the candidate from the database and also deletes the timeSlots for
	 * the candidate
	 * 
	 * @param id
	 */
	public void deleteCandidateById(Integer id) {
		dao.deleteById(id);
		timeSlotService.deleteTimeSlotForCandidate(id);
	}

	/**
	 * Returns the candidate by ID
	 * 
	 * @param id
	 * @return Candidate with the ID
	 */
	public Candidate getCandidateById(Integer id) {
		Optional<Candidate> op = dao.findById(id);
		return op.isPresent() ? op.get() : null;
	}

	/**
	 * Gets all the Time Slots registered in the database against the candidate
	 * who's ID is passed
	 * 
	 * @param candidateId
	 * @return list of time slots
	 */

	public List<TimeSlot> getTimeSlotForCandidate(Integer candidateId) {
		return timeSlotService.findTimeSlotByCandId(candidateId);
	}

	/**
	 * Adds the list of time slots against the candidate ID.
	 * 
	 * @param timeSlotList
	 * @param id
	 */
	public void addTimeSlotsForCandidate(List<TimeSlot> timeSlotList, Integer id) {
		String priority = getCandidateById(id).getPriority();
		for (TimeSlot ts : timeSlotList) {
			ts.setPriority(priority);
			timeSlotService.createTimeSlotForCandidate(ts, id);
		}
	}

	@Transactional
	public boolean updateCandidate(Integer id, Candidate candidate) {
		Optional<Candidate> op = this.dao.findById(id);
		if (op.isPresent()) {
			Candidate fromDB = op.get();
			fromDB.setEmail(candidate.getEmail());
			fromDB.setName(candidate.getName());
			fromDB.setPhoneNo(candidate.getPhoneNo());
			fromDB.setPriority(candidate.getPriority());
			this.dao.save(fromDB);
			return true;
		} else {
			return false;
		}
	}

	public List<Candidate> getAllCandidates() {
		return this.dao.findAll();
	}

}
