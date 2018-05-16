package com.sapient.InterviewSchedular.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.InterviewSchedular.model.Interviewer;

public interface InterviewerRepo extends JpaRepository<Interviewer, Integer> {

	@Query(value = "insert into tableName where id = :id ", nativeQuery = true)
	public void create(@Param("id") int id);

}
