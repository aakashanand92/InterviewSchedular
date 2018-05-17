package com.sapient.InterviewSchedular.service;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.sapient.InterviewSchedular.model.Candidate;
import com.sapient.InterviewSchedular.model.Interviewer;
import com.sapient.InterviewSchedular.model.TimeSlot;

public class Schedular {

	void try1(List<Interviewer> interviewerList, List<Candidate> candidateList) {
		// 1. select all the active interviewers
		// 2. for all the interviewers returned in step 1. find the slots available in
		// slot table.
		// 3. do the same for candidates too
		// 4. You will get the list of interviewers and candidates.

		// Iterate over the interviewerList for each interviewer's time slot find a
		// matching time slot
		// in candidate List's candidate's timeslot. As soon as u find one. Delete the
		// candidate from the candidate list.
		// Before that create a map containing <timeSlotID,timeSlotID> -->
		// <interviewerTimeSlotID,CandidateTimeSlotID>
		// Once you have the map you can update the particular tables and send out the
		// notifications.

	}

	void schedule(List<TimeSlot> candidatesTimeSlot, List<TimeSlot> interviewersTimeSlot) {

		Set<Integer> candidatesScheduled = new HashSet<Integer>();
		Map<Integer, Integer> scheduledInterviewTimeSlotMap = new HashMap<Integer, Integer>();
		for (TimeSlot candTimeSlot : candidatesTimeSlot) {
			if (candidatesScheduled.contains(candTimeSlot.getIdOfOwner())) {
				continue;
			}
			for (TimeSlot intTimeSlot : interviewersTimeSlot) {
				if (isSameTimeSlot(candTimeSlot, intTimeSlot)) {
					scheduledInterviewTimeSlotMap.put(candTimeSlot.getId(), intTimeSlot.getId());
					candidatesScheduled.add(candTimeSlot.getIdOfOwner());
					break;
				}
			}

		}

	}

	private boolean isSameTimeSlot(TimeSlot candTimeSlot, TimeSlot intTimeSlot) {
		if (candTimeSlot.getDate().equals(intTimeSlot.getDate())
				&& candTimeSlot.getStart().equals(intTimeSlot.getStart())
				&& candTimeSlot.getEnd().equals(intTimeSlot.getEnd())) {
			return true;
		}
		return false;
	}

}
