package com.sapient.InterviewSchedular.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.InterviewSchedular.model.TimeSlot;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Integer> {

	@Query(value = "SELECT * FROM TIME_SLOT WHERE ID_OF_OWNER = :id AND TIME_SLOT_FOR = 'I'", nativeQuery = true)
	public List<TimeSlot> findTimeSlotByIntId(@Param("id") int id);

	@Query(value = "DELETE TIME_SLOT WHERE ID_OF_OWNER = :id AND TIME_SLOT_FOR = 'I' ", nativeQuery = true)
	public void deleteTimeSlotOfInterviewer(@Param("id") int id);
}
