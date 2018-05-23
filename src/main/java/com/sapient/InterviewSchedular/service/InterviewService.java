package com.sapient.InterviewSchedular.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.sapient.InterviewSchedular.dao.InterviewRepo;
import com.sapient.InterviewSchedular.model.Interview;

@Component
public class InterviewService {

	@Autowired
	InterviewRepo dao;

	public Integer saveInterview(Interview interview) {
		dao.save(interview);
		return interview.getId();
	}

	public boolean deleteInterview(Integer id) {
		dao.deleteById(id);
		return true;
	}

	public List<Integer> saveInterviews(List<Interview> interviews) {
		dao.saveAll(interviews);
		return interviews.stream().map(interview -> interview.getId()).collect(Collectors.toList());
	}
}
