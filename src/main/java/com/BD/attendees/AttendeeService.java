package com.BD.attendees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class AttendeeService {

    @Autowired
    AttendeeRepository attendeeRepository;

    private List<Attendee> attendees = new ArrayList<>(Arrays.asList(
                new Attendee(0001,"Liam","Shove"),
                new Attendee(0002,"Dora","Radosevic"),
                new Attendee(0003,"Gary","Z")));


    public List<Attendee> getAllAttendees(){
        List<Attendee> attendees = new ArrayList<Attendee>();
        attendeeRepository.findAll().forEach(attendee -> attendees.add(attendee));
        return attendees;
    }

    public Attendee getAttendee(int id){
        return attendeeRepository.findById(id).get();
    }

    public void addAttendee(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

//    public void updateAttendee(String id, Attendee attendee) {
//        attendeeRepository.save(id,)
//    }

//    public void deleteAttendee(String id) {
//        attendees.removeIf(a -> a.getId().equals(id));
//    }
}
