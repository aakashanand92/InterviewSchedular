package com.sapient.InterviewSchedular.rest;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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
@CrossOrigin
public class CandidateEndPoint {
	@Autowired
	CandidateService service;

	@PostMapping("/")
	public Integer createCandidate(@RequestBody Candidate candidate) {
		this.service.createCandidate(candidate);
		return candidate.getId();
	}

	@PutMapping("/{id}/timeSlots/add")
	public List<Integer> addTimeSlots(@PathVariable("id") Integer id, @RequestBody List<TimeSlot> slots) {
		this.service.addTimeSlotsForCandidate(slots, id);
		return slots.stream().map(slot -> slot.getId()).collect(Collectors.toList());
	}

	@DeleteMapping("/{id}/delete")
	public boolean deleteCandidateById(@PathVariable("id") Integer id) {
		this.service.deleteCandidateById(id);
		return true;
	}

	@PutMapping("/{id}/update")
	public boolean updateCandidateById(@PathVariable("id") Integer id, @RequestBody Candidate candidate) {
		return this.service.updateCandidate(id, candidate);
	}

	@GetMapping("/")
	public List<Candidate> getAllCandidates() {
		return this.service.getAllCandidates();
	}

}
