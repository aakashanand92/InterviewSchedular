package com.sapient.InterviewSchedular.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sapient.InterviewSchedular.model.Candidate;

public interface CandidateRepo extends JpaRepository<Candidate, Integer> {

}
