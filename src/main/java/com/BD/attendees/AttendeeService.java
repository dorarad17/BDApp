package com.BD.attendees;

import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

@Service
public class AttendeeService {

    private List<Attendee> attendees = Arrays.asList(
                new Attendee("0001","Liam","Shove"),
                new Attendee("0002","Dora","Radosevic"),
                new Attendee("0003","Gary","Z"));

    public List<Attendee> getAllAttendees(){
        return attendees;
    }

    public Attendee getAttendee(String id){
        return attendees.stream().filter(a -> a.getId().equals(id)).findAny().get();
    }
}
