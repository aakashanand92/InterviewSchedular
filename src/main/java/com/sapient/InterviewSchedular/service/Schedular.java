package com.sapient.InterviewSchedular.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.sapient.InterviewSchedular.model.TimeSlot;

public class Schedular {

	void schedule(List<TimeSlot> candidatesTimeSlot, List<TimeSlot> interviewersTimeSlot) {
		Map<Integer, Integer> candIdIntvIdMap = new HashMap<Integer, Integer>();
		for (TimeSlot candTimeSlot : candidatesTimeSlot) {
			for (TimeSlot intTimeSlot : interviewersTimeSlot) {
				if (isSameTimeSlot(candTimeSlot, intTimeSlot)) {
					candIdIntvIdMap.put(candTimeSlot.getIdOfOwner(), intTimeSlot.getIdOfOwner());

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
