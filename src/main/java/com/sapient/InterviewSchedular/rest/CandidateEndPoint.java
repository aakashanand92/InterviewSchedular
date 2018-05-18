package com.sapient.InterviewSchedular.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
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
@RequestMapping(value = "/candidate", consumes = { MediaType.APPLICATION_JSON_VALUE })

public class CandidateEndPoint {
	@Autowired
	CandidateService service;

	@PostMapping("/")
	public Integer createCandidate(@RequestBody Candidate candidate) {
		this.service.createCandidate(candidate);
		return candidate.getId();
	}

	@PutMapping("/{id}/timeSlots/add")
	public String addTimeSlots(@PathVariable("id") Integer id, @RequestBody List<TimeSlot> slot) {
		this.service.addTimeSlotsForCandidate(slot, id);
		return null;
	}

	@DeleteMapping("{id}/delete")
	public void deleteCandidateById(@PathVariable("id") Integer id) {
		this.service.deleteCandidateById(id);
	}

}
