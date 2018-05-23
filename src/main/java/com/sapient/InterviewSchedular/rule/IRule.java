package com.sapient.InterviewSchedular.rule;

/**
 * All rule classes should implement this.
 * 
 * @author aakanand1
 *
 */
public interface IRule {
	/**
	 * Will execute the rule and try to figure out if the given inputs passed the
	 * rule defined or not
	 * 
	 * @param inputs
	 * @return true if the rule passed
	 */

	public boolean executeRule(IRuleInput... inputs);
}
