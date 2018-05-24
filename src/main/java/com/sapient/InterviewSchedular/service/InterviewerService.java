package com.sapient.InterviewSchedular.service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.sapient.InterviewSchedular.dao.InterviewerRepo;
import com.sapient.InterviewSchedular.model.Interview;
import com.sapient.InterviewSchedular.model.Interviewer;
import com.sapient.InterviewSchedular.model.TimeSlot;

@Service
public class InterviewerService {
	@Autowired
	InterviewerRepo dao;
	@Autowired
	TimeSlotService timeSlotService;
	@Autowired
	Schedular schedular;
	@Autowired
	Environment env;

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

	@Transactional
	public boolean updateInterviewer(Integer id, Interviewer interviewer) {
		Optional<Interviewer> op = this.dao.findById(id);
		if (op.isPresent()) {
			Interviewer fromDB = op.get();
			fromDB.setSupervisor(interviewer.getSupervisor());
			fromDB.setName(interviewer.getName());
			fromDB.setPriority(interviewer.getPriority());
			this.dao.save(fromDB);
			return true;
		} else {
			return false;
		}
	}

	public List<Interview> scheduleInterviews() {
		return this.schedular.schedule();
	}

	public List<Interviewer> getAllInterviewers() {
		return this.dao.findAll();
	}

	public List<String> getAvailablePriority() {
		return Arrays.asList(this.env.getProperty("sapient.schedular.priority_order").split(","));
	}

}
