package com.sapient.InterviewSchedular.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.InterviewSchedular.model.Interview;

public interface InterviewRepo extends JpaRepository<Interview, Integer> {

}
