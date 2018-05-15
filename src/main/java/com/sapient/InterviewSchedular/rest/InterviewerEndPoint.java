package com.sapient.InterviewSchedular.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sapient.InterviewSchedular.model.Interviewer;

@Component
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.TEXT_PLAIN)
@Path("/interviewer")
public class InterviewerEndPoint {

	@POST
	public String createInterviewer(Interviewer intervewer) {
		if (intervewer.getId() == null) {
			// create new interviewer
		} else {
			// either don't allow this or update flow should run
		}

		// TODO - Return the id of the new entity created
		return "Interviewer name is " + intervewer.getName() + " priority is " + intervewer.getPriorty();
	}

	@PUT
	@Path("{id}/addTimeSlot")
	public String addTimeSlot(@PathParam("id") String id, String slot) {

		return null;
	}

	@GET
	@Path("{id}")
	public String getListOfCandidates(@PathParam("id") String id) {
		return null;
	}

}
