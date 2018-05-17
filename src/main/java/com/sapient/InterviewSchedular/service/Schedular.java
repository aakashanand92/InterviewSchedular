package com.sapient.InterviewSchedular.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sapient.InterviewSchedular.model.Candidate;
import com.sapient.InterviewSchedular.model.Interview;
import com.sapient.InterviewSchedular.model.Interviewer;
import com.sapient.InterviewSchedular.model.TimeSlot;

@Service
public class Schedular {

	@Autowired
	TimeSlotService timeSlotService;
	@Autowired
	Environment env;

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

	List<Interview> schedule(List<TimeSlot> candidatesTimeSlot, List<TimeSlot> interviewersTimeSlot) {
		List<Interview> scheduledInterviews = new ArrayList<Interview>();
		Set<Integer> candidatesScheduled = new HashSet<Integer>();
		// Map<Integer, Integer> scheduledInterviewTimeSlotMap = new HashMap<Integer,
		// Integer>();
		for (TimeSlot candTimeSlot : candidatesTimeSlot) {
			if (candidatesScheduled.contains(candTimeSlot.getIdOfOwner())) {
				continue;
			}
			for (TimeSlot intTimeSlot : interviewersTimeSlot) {
				if (isSameTimeSlot(candTimeSlot, intTimeSlot) && priorityCompatible(candTimeSlot, intTimeSlot)) {
					Interview interview = new Interview();
					interview.setCandidateId(candTimeSlot.getIdOfOwner());
					interview.setInterviewerId(intTimeSlot.getIdOfOwner());
					interview.setStartTime(candTimeSlot.getStart());
					interview.setDate(candTimeSlot.getDate());
					interview.setEndTime(candTimeSlot.getEnd());
					// scheduledInterviewTimeSlotMap.put(candTimeSlot.getId(), intTimeSlot.getId());
					scheduledInterviews.add(interview);
					candidatesScheduled.add(candTimeSlot.getIdOfOwner());
					break;
				}
			}

		}
		return scheduledInterviews;

	}

	private boolean isSameTimeSlot(TimeSlot candTimeSlot, TimeSlot intTimeSlot) {
		if (candTimeSlot.getDate().equals(intTimeSlot.getDate())
				&& candTimeSlot.getStart().equals(intTimeSlot.getStart())
				&& candTimeSlot.getEnd().equals(intTimeSlot.getEnd())) {
			return true;
		}
		return false;
	}

	public List<Interview> schedule() {
		return this.schedule(timeSlotService.getAllTimeSlotsForCandidates(),
				timeSlotService.getAllTimeSlotsForInterviewers());
	}

	public static void main(String... args) {
		Schedular sc = new Schedular();
		List<Interview> listOfInterviews = sc.schedule(sc.timeSlotService.getAllTimeSlotsForCandidates(),
				sc.timeSlotService.getAllTimeSlotsForInterviewers());
		System.out.println(listOfInterviews);
	}

	private boolean priorityCompatible(TimeSlot candTimeSlot, TimeSlot intTimeSlot) {
		String strPriorityOrder = env.getProperty("sapient.schedular.priority_order");

		String[] str = strPriorityOrder.split(",");
		Integer intPriorityIndex = 0;
		Integer candPriorityIndex = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(candTimeSlot.getPriority())) {
				candPriorityIndex = i;
			}
			if (str[i].equals(intTimeSlot.getPriority())) {
				intPriorityIndex = i;
			}
		}
		if (candPriorityIndex >= intPriorityIndex) {
			return true;
		}

		return false;
	}

}
