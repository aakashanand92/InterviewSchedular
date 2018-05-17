package com.sapient.InterviewSchedular.service;

import java.util.List;
import java.util.Optional;

import javax.inject.Inject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sapient.InterviewSchedular.dao.InterviewerRepo;
import com.sapient.InterviewSchedular.model.Interviewer;
import com.sapient.InterviewSchedular.model.TimeSlot;

@Service
public class InterviewerService {
	@Inject
	InterviewerRepo dao;
	@Autowired
	TimeSlotService timeSlotService;
	@Autowired
	Schedular schedular;

	public void createInterviewer(Interviewer interviewer) {
		dao.save(interviewer);
	}

	public void deleteInterviewerById(Integer id) {
		dao.deleteById(id);
		timeSlotService.deleteTimeSlotForInterviewer(id);
	}

	public Interviewer getInterviewerById(Integer id) {
		Optional<Interviewer> op = dao.findById(id);
		if (op.isPresent()) {
			return op.get();
		}
		return null;
	}

	public List<TimeSlot> getTimeSlotOfInterviewer(Integer interveiwerId) {
		return timeSlotService.findTimeSlotByIntId(interveiwerId);
	}

	public void addTimeSlotsForInterviewer(List<TimeSlot> timeSlotList, Integer id) {
		String priority = getInterviewerById(id).getPriority();
		for (TimeSlot ts : timeSlotList) {
			ts.setPriority(priority);
			timeSlotService.createTimeSlotForInterviewer(ts, id);
		}
	}

	public String scheduleInterviews() {
		return this.schedular.schedule().toString();
	}

}
