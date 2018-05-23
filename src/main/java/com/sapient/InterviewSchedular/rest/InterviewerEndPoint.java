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

import com.sapient.InterviewSchedular.model.Interviewer;
import com.sapient.InterviewSchedular.model.TimeSlot;
import com.sapient.InterviewSchedular.service.InterviewerService;

@RestController
// @CrossOrigin
@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, path = { "/interviewer" })

public class InterviewerEndPoint {
	@Autowired
	InterviewerService service;

	@CrossOrigin
	@PostMapping("/")
	public Integer createInterviewer(@RequestBody Interviewer interviewer) {
		this.service.createInterviewer(interviewer);
		return interviewer.getId();

	}

	@CrossOrigin
	@PutMapping("/{id}/timeSlots/add")
	public List<Integer> addTimeSlots(@PathVariable("id") Integer id, @RequestBody List<TimeSlot> slots) {
		this.service.addTimeSlotsForInterviewer(slots, id);
		return slots.stream().map(slot -> slot.getId()).collect(Collectors.toList());

	}

	@CrossOrigin
	@GetMapping("/{id}/timeSlots")
	public List<TimeSlot> findTimeSlotsForInterviewer(@PathVariable("id") Integer id) {
		return this.service.getTimeSlotOfInterviewer(id);
	}

	@CrossOrigin
	@DeleteMapping("{id}/delete")
	public void deleteInterviewerById(@PathVariable("id") Integer id) {
		this.service.deleteInterviewerById(id);
	}

	@CrossOrigin
	@GetMapping("/schedule")
	public String schedule() {
		return this.service.scheduleInterviews();
	}

	@CrossOrigin
	@PutMapping("{id}/update")
	public boolean updateInterviewerById(@PathVariable("id") Integer id, @RequestBody Interviewer interviewer) {
		return this.service.updateInterviewer(id, interviewer);
	}

	@CrossOrigin
	@GetMapping("/")
	public List<Interviewer> getAllInterviewers() {
		return this.service.getAllInterviewers();
	}

}
