package com.sapient.InterviewSchedular.rule;

/**
 * All rule classes should implement this.
 * 
 * @author aakanand1
 *
 */
public interface IRule {

	public boolean executeRule(IRuleInput... inputs);
}
