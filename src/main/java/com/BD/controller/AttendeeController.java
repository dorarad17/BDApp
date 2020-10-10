package com.BD.controller;

import com.BD.attendees.Attendee;
import com.BD.attendees.AttendeeService;
import com.BD.repository.AttendeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;
    @Autowired
    private AttendeeRepository attendeeRepository;

    @RequestMapping("/attendees")
    public List<Attendee> allAttendees() {
        return attendeeRepository.findAll();
    }

    @RequestMapping("/attendees/{id}")
    public Attendee getAttendee(@PathVariable String id) {
        return attendeeRepository.getAttendee(id);
    }

    @PostMapping(value = "/attendees")
    public Attendee addAttendee(@RequestBody Attendee attendee){
        attendeeRepository.save(attendee);
        return attendeeRepository.getAttendee(attendee.getId());
    }

//    @RequestMapping(method = RequestMethod.PUT, value = "/attendees/{id}")
//    public void updateAttendee(@RequestBody Attendee attendee,@PathVariable String id){
//        attendeeService.updateAttendee(id,attendee);
//    }
//
//    @RequestMapping(method = RequestMethod.DELETE, value = "/attendees/{id}")
//    public void deleteAttendee(@PathVariable String id){
//        attendeeService.deleteAttendee(id);
//    }
}
