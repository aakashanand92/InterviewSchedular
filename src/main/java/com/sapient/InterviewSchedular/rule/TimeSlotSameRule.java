package com.sapient.InterviewSchedular.rule;

import org.springframework.stereotype.Component;

import com.sapient.InterviewSchedular.model.TimeSlot;

@Component
public class TimeSlotSameRule implements IRule {

	@Override
	public boolean executeRule(IRuleInput... inputs) {
		TimeSlot candidateTimeSlot = (TimeSlot) inputs[0];
		TimeSlot interviewerTimeSlot = (TimeSlot) inputs[1];
		if (candidateTimeSlot.getDate().equals(interviewerTimeSlot.getDate())
				&& candidateTimeSlot.getStart().equals(interviewerTimeSlot.getStart())
				&& candidateTimeSlot.getEnd().equals(interviewerTimeSlot.getEnd())) {
			return true;
		}
		return false;
	}
}
