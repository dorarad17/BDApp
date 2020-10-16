package com.BD.controller;

import com.BD.attendees.Attendee;
import com.BD.attendees.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class AttendeeController {

    @Autowired
    private AttendeeService attendeeService;
   // @Autowired
   // private AttendeeRepository attendeeRepository;

    @RequestMapping("/attendees")
    public void allAttendees() {
//        return attendeeRepository.findAll();

    }

    @RequestMapping("/attendees/{id}")
    public void getAttendee(@PathVariable String id) {
//        return attendeeRepository.getAttendee(id);
    }

    @PostMapping(value = "/attendees")
    public void addAttendee(@RequestBody Attendee attendee){
//        attendeeRepository.save(attendee);
//        return attendeeRepository.getAttendee(attendee.getId());
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
