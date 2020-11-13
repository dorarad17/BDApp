package com.BD.attendees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;


@Service
public class AttendeeService {

    @Autowired
    AttendeeRepository attendeeRepository;

    public List<Attendee> getAllAttendees(){
        List<Attendee> attendees = new ArrayList<Attendee>();
        attendeeRepository.findAll().forEach(attendees::add);
        return attendees;
    }

    public Attendee getAttendee(int id){
        return attendeeRepository.findById(id).get();
    }

    public void addAttendee(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    public void updateAttendee(int id, Attendee attendee) {
        Attendee attendeeInDB = attendeeRepository.findById(id).get();
        attendeeInDB.setFirstName(attendee.firstName);
        attendeeInDB.setLastName(attendee.lastName);
        attendeeInDB.setAttending(attendee.attending);
        attendeeRepository.save(attendeeInDB);
    }

    public void deleteAttendee(int id) {
        attendeeRepository.deleteById(id);
    }

    public List<Attendee> getAttendingList (List <Attendee> attendees) {
        return attendees.stream()
                .filter(Attendee::getAttending).collect(Collectors.toList());
    }

}
