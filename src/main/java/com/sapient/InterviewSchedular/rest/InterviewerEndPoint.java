package com.sapient.InterviewSchedular.rest;

import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.InterviewSchedular.model.Interviewer;
import com.sapient.InterviewSchedular.model.TimeSlot;
import com.sapient.InterviewSchedular.service.InterviewerService;

@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
@Path("/interviewer")
public class InterviewerEndPoint {
	@Autowired
	InterviewerService service;

	@POST
	public Integer createInterviewer(Interviewer interviewer) {
		this.service.createInterviewer(interviewer);
		return interviewer.getId();
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
