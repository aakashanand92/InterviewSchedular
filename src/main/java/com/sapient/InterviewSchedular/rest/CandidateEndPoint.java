package com.sapient.InterviewSchedular.rest;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.InterviewSchedular.model.Candidate;
import com.sapient.InterviewSchedular.model.TimeSlot;
import com.sapient.InterviewSchedular.service.CandidateService;

@RestController
@RequestMapping(value = "/candidate")
public class CandidateEndPoint {

	CandidateService service;

	@PostMapping(path = "/")
	public Integer createCandidate(Candidate candidate) {
		this.service.createCandidate(candidate);
		return candidate.getId();
	}

	@PutMapping("/{id}/timeSlots/add")
	public String addTimeSlots(@PathVariable("id") Integer id, @RequestBody List<TimeSlot> slot) {
		this.service.addTimeSlotsForCandidate(slot, id);
		return null;
	}

	@DeleteMapping("{id}/delete")
	public void deleteInterviewerById(@PathVariable("id") Integer id) {
		this.service.deleteCandidateById(id);
	}

}
