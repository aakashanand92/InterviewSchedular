package com.sapient.InterviewSchedular.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.sapient.InterviewSchedular.model.TimeSlot;

public interface TimeSlotRepo extends JpaRepository<TimeSlot, Integer> {

	@Query(value = "SELECT * FROM TIME_SLOT WHERE ID_OF_OWNER = :id AND TIME_SLOT_FOR = 'I'", nativeQuery = true)
	public List<TimeSlot> findTimeSlotByIntId(@Param("id") int id);

	@Query(value = "SELECT * FROM TIME_SLOT WHERE ID_OF_OWNER = :id AND TIME_SLOT_FOR = 'C'", nativeQuery = true)
	public List<TimeSlot> findTimeSlotByCandId(@Param("id") int id);

	@Query(value = "SELECT * FROM TIME_SLOT WHERE TIME_SLOT_FOR = 'C' AND SCHEDULED='N'", nativeQuery = true)
	public List<TimeSlot> getAllTimeSlotsForCandidates();

	@Query(value = "SELECT * FROM TIME_SLOT WHERE TIME_SLOT_FOR = 'I' AND SCHEDULED='N'", nativeQuery = true)
	public List<TimeSlot> getAllTimeSlotsForInterviewers();

	@Query(value = "DELETE TIME_SLOT WHERE ID_OF_OWNER = :id AND TIME_SLOT_FOR = 'I' ", nativeQuery = true)
	public void deleteTimeSlotForInterviewer(@Param("id") int id);

	@Query(value = "DELETE TIME_SLOT WHERE ID_OF_OWNER = :id AND TIME_SLOT_FOR = 'C' ", nativeQuery = true)
	public void deleteTimeSlotForCandidate(@Param("id") int id);

	@Modifying
	@Query("UPDATE TimeSlot t set t.scheduled = 'Y' where t.id in :ids")
	void setScheduledForIds(@Param("ids") List<Integer> ids);

	// public void deleteByIdOfOwnerAndByTimeSlotFor(int id, String timeSlotFor);
}
