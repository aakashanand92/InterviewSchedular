package com.sapient.InterviewSchedular.rule;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

/**
 * The rule engine that take care of all the rules that needs to be followed
 * during scheduling interviews. Make sure all new rule implements IRule
 * interface and the rule input should implement IRuleInput interface.
 * 
 * @author aakanand1
 *
 */
@Component
public class RuleEngine {
	@Autowired
	Environment env;
	@Value("sapient.schedular.rules_to_check")
	String rulesToCheck;
	@Autowired
	ApplicationContext ac;
	public static final String DEFAULT_RULE_PACKAGE = "com.sapient.InterviewSchedular.rule";
	private List<IRule> rulesToBeChecked = null;

	/*
	 * How to make spring call this after constructor ? @Post constructor is 1 way
	 */
	/**
	 * Initializes the rule engine and loads all the rules that needs to be checked.
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

	public boolean checkRules(IRuleInput... ruleInput) {
		if (rulesToBeChecked == null) {
			rulesToBeChecked = new ArrayList<IRule>();
			init();
		}
		boolean result = true;
		if (rulesToBeChecked.isEmpty()) {
			System.out.println("No rules set to be checked, the ruleEngine will always return true");
		}
		for (IRule rule : rulesToBeChecked) {
			result &= rule.executeRule(ruleInput);
		}
		return result;
	}

}
