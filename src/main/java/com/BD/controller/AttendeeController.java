package com.BD.controller;

import com.BD.attendees.Attendee;
import com.BD.attendees.AttendeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

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
    public Attendee getAttendee(@PathVariable("id") int id) {
            return attendeeService.getAttendee(id);
    }

    @PostMapping(value = "/attendees")
    public String addAttendee(@RequestBody Attendee attendee){
        attendeeService.addAttendee(attendee);
        return attendee.getFirstName();
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
