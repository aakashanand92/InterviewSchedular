package com.sapient.InterviewSchedular.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.InterviewSchedular.model.Interviewer;

public interface InterviewerRepo extends JpaRepository<Interviewer, Integer> {

}
