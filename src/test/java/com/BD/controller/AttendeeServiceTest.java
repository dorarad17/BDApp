package com.BD.controller;

import com.BD.attendees.Attendee;
import com.BD.attendees.AttendeeService;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class AttendeeServiceTest {

    private static Attendee ATTENDEE1 = new Attendee(1,"Dora","Radosevic",true);
    private static Attendee ATTENDEE2 = new Attendee(2,"Liam","Shove",false);
    private static List<Attendee> ATTENDEES = Arrays.asList(ATTENDEE1,ATTENDEE2);

    @Test
    void getAttendingList_returns_only_attending_attendees() {
        List<Attendee> attendingList = AttendeeService.getAttendingList(ATTENDEES);
        assertEquals(attendingList, Collections.singletonList(ATTENDEE1));
    }
}
