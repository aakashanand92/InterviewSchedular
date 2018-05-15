package com.sapient.InterviewSchedular.rest;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.sapient.InterviewSchedular.model.Interviewer;

@Component
@Path("/interviewer")
public class InterviewerEndPoint {

	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.TEXT_PLAIN)
	public String createInterviewer(Interviewer intervewer) {
		if (intervewer.getId() == null) {
			// create new interviewer
		} else {
			// either don't allow this or update flow should run
		}

		// TODO - Return the id of the new entity created
		return "Interviewer name is " + intervewer.getName() + " priority is " + intervewer.getPriorty();
	}

	/*
	 * Slot should come in this format
	 * 
	 * Monday (M) - 4-5 is 1, 5-6 is 2; Tuesday(T) - 4-5 is 1, 5-6 is 2;
	 * 
	 */
	@POST
	@Path("{id}/addTimeSlot")
	public String addTimeSlot(@PathParam("id") String id, String slot) {

		return null;
	}

}
