package com.sapient.InterviewSchedular.rule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.sapient.InterviewSchedular.model.TimeSlot;

@Component
public class PriorityRule implements IRule {
	@Autowired
	Environment env;

	@Override
	public boolean executeRule(TimeSlot candidateTimeSlot, TimeSlot interviewerTimeSlot) {
		String strPriorityOrder = env.getProperty("sapient.schedular.priority_order");
		if (strPriorityOrder == null) {
			strPriorityOrder = System.getProperty("sapient.schedular.priority_order");
		}
		String[] str = strPriorityOrder.split(",");
		Integer intPriorityIndex = 0;
		Integer candPriorityIndex = 0;
		for (int i = 0; i < str.length; i++) {
			if (str[i].equals(candidateTimeSlot.getPriority())) {
				candPriorityIndex = i;
			}
			if (str[i].equals(interviewerTimeSlot.getPriority())) {
				intPriorityIndex = i;
			}
		}
		if (candPriorityIndex >= intPriorityIndex) {
			return true;
		}

		return false;
	}
}
