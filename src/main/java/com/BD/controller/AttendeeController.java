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

    @CrossOrigin // do I want all origins allowed?!
    @RequestMapping("/attendees")
    public List<Attendee> allAttendees() {
       return attendeeService.getAllAttendees();
    }

    @CrossOrigin // do I want all origins allowed?!
    @RequestMapping("/attendees/{id}")
    public Attendee getAttendee(@PathVariable("id") int id) {
            return attendeeService.getAttendee(id);
    }

    @CrossOrigin // do I want all origins allowed?!
    @PostMapping(value = "/attendees")
    public String addAttendee(@RequestBody Attendee attendee){
        attendeeService.addAttendee(attendee);
        return attendee.getFirstName();
    }

    @CrossOrigin // do I want all origins allowed?!
    @RequestMapping(method = RequestMethod.PUT, value = "/attendees/{id}")
    public String updateAttendee(@RequestBody Attendee attendee,@PathVariable int id){
        attendeeService.updateAttendee(id,attendee);
        return "updated";
    }

    @CrossOrigin // do I want all origins allowed?!
    @RequestMapping(method = RequestMethod.DELETE, value = "/attendees/{id}")
    public String deleteAttendee(@PathVariable int id){
        attendeeService.deleteAttendee(id);
        return "deleted";
    }
}
