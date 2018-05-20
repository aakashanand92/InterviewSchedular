package com.sapient.InterviewSchedular.service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;

import com.sapient.InterviewSchedular.model.Interview;
import com.sapient.InterviewSchedular.model.TimeSlot;
import com.sapient.InterviewSchedular.rule.RuleEngine;

@Service
public class Schedular {

	@Autowired
	TimeSlotService timeSlotService;
	@Autowired
	Environment env;
	@Autowired
	RuleEngine ruleEngine;

	List<Interview> schedule(List<TimeSlot> candidatesTimeSlot, List<TimeSlot> interviewersTimeSlot) {
		List<Interview> scheduledInterviews = new ArrayList<Interview>();
		Set<Integer> candidatesScheduled = new HashSet<Integer>();
		List<Integer> timeSlotsUsed = new ArrayList<Integer>();
		for (TimeSlot candTimeSlot : candidatesTimeSlot) {
			if (candidatesScheduled.contains(candTimeSlot.getIdOfOwner())) {
				continue;
			}
			for (TimeSlot intTimeSlot : interviewersTimeSlot) {
				if (ruleEngine.checkRules(candTimeSlot, intTimeSlot)) {
					Interview interview = new Interview();
					interview.setCandidateId(candTimeSlot.getIdOfOwner());
					interview.setInterviewerId(intTimeSlot.getIdOfOwner());
					interview.setStartTime(candTimeSlot.getStart());
					interview.setDate(candTimeSlot.getDate());
					interview.setEndTime(candTimeSlot.getEnd());
					scheduledInterviews.add(interview);
					candidatesScheduled.add(candTimeSlot.getIdOfOwner());
					timeSlotsUsed.add(intTimeSlot.getId());
					timeSlotsUsed.add(candTimeSlot.getId());
					// set all the other candidates timeslots to be removed from the table
					this.timeSlotService.findTimeSlotByCandId(candTimeSlot.getIdOfOwner()).stream().forEach((x) -> {
						timeSlotsUsed.add(x.getId());
					});
					break;
				}
			}

		}
		this.timeSlotService.setScheduled(timeSlotsUsed);
		return scheduledInterviews;

	}

	public List<Interview> schedule() {
		return this.schedule(timeSlotService.getAllTimeSlotsForCandidates(),
				timeSlotService.getAllTimeSlotsForInterviewers());
	}

}
