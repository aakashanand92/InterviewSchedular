package com.sapient.InterviewSchedular.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.sapient.InterviewSchedular.model.TimeSlot;

@Component
public class RuleEngine {
	@Autowired
	Environment env;
	@Autowired
	ApplicationContext ac;
	public static final String DEFAULT_RULE_PACKAGE = "com.sapient.InterviewSchedular.rule";
	private List<IRule> rulesToBeChecked = null;

	/*
	 * How to make spring call this after constructor ?
	 */
	public void init() {
		String[] listOfRuleClasses = env.getProperty("sapient.schedular.rules_to_check").split(",");

		for (String className : listOfRuleClasses) {
			try {
				rulesToBeChecked.add((IRule) ac.getBean(className));
			} catch (Exception e) {
				System.err.println("Can't instatiate class " + className);
				e.printStackTrace();
			}
		}
	}

	public boolean checkRules(TimeSlot candidateTimeSlot, TimeSlot interviewerTimeSlot) {
		if (rulesToBeChecked == null) {
			rulesToBeChecked = new ArrayList<IRule>();
			init();
		}
		boolean result = true;
		if (rulesToBeChecked.isEmpty()) {
			System.out.println("No rules set to be checked, the ruleEngine will always return true");
		}
		for (IRule rule : rulesToBeChecked) {
			result &= rule.executeRule(candidateTimeSlot, interviewerTimeSlot);
		}
		return result;
	}

}
