package com.sapient.InterviewSchedular.service;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.sapient.InterviewSchedular.model.TimeSlot;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SchedularTest {

	@Test
	public void testSchedule() {
		System.setProperty("sapient.schedular.priority_order", "P1,P2");
		Schedular sc = new Schedular();
		List<TimeSlot> candidatesTimeSlot = new ArrayList<TimeSlot>();
		List<TimeSlot> interviewersTimeSlot = new ArrayList<TimeSlot>();
		TimeSlot timeSlot1 = new TimeSlot();
		timeSlot1.setId(1);
		timeSlot1.setStart(5);
		timeSlot1.setEnd(6);
		timeSlot1.setIdOfOwner(1);
		timeSlot1.setDate("date1");
		timeSlot1.setTimeSlotFor("I");

		TimeSlot timeSlot2 = new TimeSlot();
		timeSlot2.setId(2);
		timeSlot2.setStart(6);
		timeSlot2.setEnd(7);
		timeSlot2.setIdOfOwner(2);
		timeSlot2.setDate("date2");
		timeSlot2.setTimeSlotFor("I");

		TimeSlot timeSlot3 = new TimeSlot();
		timeSlot3.setId(3);
		timeSlot3.setStart(6);
		timeSlot3.setEnd(7);
		timeSlot3.setIdOfOwner(1);
		timeSlot3.setDate("date1");
		timeSlot3.setTimeSlotFor("I");

		TimeSlot timeSlot4 = new TimeSlot();
		timeSlot4.setId(4);
		timeSlot4.setStart(6);
		timeSlot4.setEnd(7);
		timeSlot4.setIdOfOwner(2);
		timeSlot4.setDate("date3");
		timeSlot4.setTimeSlotFor("I");

		TimeSlot timeSlot5 = new TimeSlot();
		timeSlot5.setId(5);
		timeSlot5.setStart(6);
		timeSlot5.setEnd(7);
		timeSlot5.setIdOfOwner(3);
		timeSlot5.setDate("date1");
		timeSlot5.setTimeSlotFor("I");

		interviewersTimeSlot.add(timeSlot1);
		interviewersTimeSlot.add(timeSlot2);
		interviewersTimeSlot.add(timeSlot3);
		interviewersTimeSlot.add(timeSlot4);
		interviewersTimeSlot.add(timeSlot5);

		TimeSlot timeSlot6 = new TimeSlot();
		timeSlot6.setId(6);
		timeSlot6.setStart(6);
		timeSlot6.setEnd(7);
		timeSlot6.setIdOfOwner(1);
		timeSlot6.setDate("date1");
		timeSlot6.setTimeSlotFor("C");

		TimeSlot timeSlot7 = new TimeSlot();
		timeSlot7.setId(7);
		timeSlot7.setStart(7);
		timeSlot7.setEnd(8);
		timeSlot7.setIdOfOwner(1);
		timeSlot7.setDate("date2");
		timeSlot7.setTimeSlotFor("C");

		TimeSlot timeSlot8 = new TimeSlot();
		timeSlot8.setId(8);
		timeSlot8.setStart(5);
		timeSlot8.setEnd(6);
		timeSlot8.setIdOfOwner(3);
		timeSlot8.setDate("date1");
		timeSlot8.setTimeSlotFor("C");

		TimeSlot timeSlot9 = new TimeSlot();
		timeSlot9.setId(9);
		timeSlot9.setStart(6);
		timeSlot9.setEnd(7);
		timeSlot9.setIdOfOwner(1);
		timeSlot9.setDate("date2");
		timeSlot9.setTimeSlotFor("C");

		candidatesTimeSlot.add(timeSlot6);
		candidatesTimeSlot.add(timeSlot7);
		candidatesTimeSlot.add(timeSlot8);
		candidatesTimeSlot.add(timeSlot9);

		System.out.println(sc.schedule(candidatesTimeSlot, interviewersTimeSlot));
	}
}
