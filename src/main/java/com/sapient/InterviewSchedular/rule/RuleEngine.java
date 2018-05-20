package com.sapient.InterviewSchedular.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

import com.sapient.InterviewSchedular.model.TimeSlot;

@Component
public class RuleEngine {
	@Autowired
	Environment env;

	public static final String DEFAULT_RULE_PACKAGE = "com.sapient.InterviewSchedular.rule";
	private List<IRule> rulesToBeChecked = null;

	/*
	 * How to make spring call this after constructor ?
	 */
	public void init() {
		String[] listOfRuleClasses = env.getProperty("sapient.schedular.rules_to_check").split(",");

		for (String className : listOfRuleClasses) {
			try {

				Class<IRule> ruleClass = (Class<IRule>) Class.forName(DEFAULT_RULE_PACKAGE + "." + className);
				rulesToBeChecked.add(ruleClass.newInstance());
			} catch (ClassNotFoundException ce) {
				System.err.println("Rule class with name " + className
						+ " not found in default package so rule engine will not run this rule");
			} catch (InstantiationException | IllegalAccessException e) {
				System.err.println("Rule class with name " + className + "Cannot be instantiated, Error is "
						+ e.getLocalizedMessage());
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
