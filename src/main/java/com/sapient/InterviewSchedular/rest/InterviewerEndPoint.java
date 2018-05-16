package com.sapient.InterviewSchedular.rest;

import java.util.List;

import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sapient.InterviewSchedular.model.Interviewer;
import com.sapient.InterviewSchedular.model.TimeSlot;
import com.sapient.InterviewSchedular.service.InterviewerService;

@RestController

@RequestMapping(consumes = { MediaType.APPLICATION_JSON_VALUE }, path = { "/interviewer" })
// @Path("/interviewer")
public class InterviewerEndPoint {
	@Autowired
	InterviewerService service;

	// @POST
	// @RequestMapping(value = "/test/" method )
	@PostMapping("/")
	public Integer createInterviewer(Interviewer interviewer) {
		this.service.createInterviewer(interviewer);
		return interviewer.getId();
		// return 1;
	}

	@PUT

	@Path("{id}/addTimeSlots")
	public String addTimeSlots(@PathParam("id") Integer id, List<TimeSlot> slot) {
		this.service.addTimeSlotsForInterviewer(slot, id);
		return null;
	}

	@GET

	@Path("{id}")
	public String getListOfCandidates(@PathParam("id") String id) {
		return null;
	}

	@DELETE

	@Path("{id}/delete")
	public void deleteInterviewerById(@PathParam("id") Integer id) {
		this.service.deleteInterviewerById(id);
	}

}
