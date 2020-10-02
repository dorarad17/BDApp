package com.BD.controller;

import com.BD.attendees.Attendee;
import com.BD.attendees.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;

    @RequestMapping("/attendees")
    public List<Attendee> allAttendees() {
        return attendeeService.getAllAttendees();
    }

    @RequestMapping("/attendees/{id}")
    public Attendee getAttendee(@PathVariable String id) {
        return attendeeService.getAttendee(id);
    }
}
