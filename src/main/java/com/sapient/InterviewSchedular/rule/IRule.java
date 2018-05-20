package com.sapient.InterviewSchedular.rule;

import com.sapient.InterviewSchedular.model.TimeSlot;

public interface IRule {

	public boolean executeRule(TimeSlot candidateTimeSlot, TimeSlot interviewerTimeSlot);
}
