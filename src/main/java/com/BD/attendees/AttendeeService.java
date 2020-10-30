package com.BD.attendees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.ResultSet;
import java.sql.Statement;

@Service
public class AttendeeService {

    @Autowired
    AttendeeRepository attendeeRepository;

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

    public void updateAttendee(int id, Attendee attendee) {
        Attendee attendeeInDB = attendeeRepository.findById(id).get();
        attendeeInDB.setFirstName(attendee.firstName);
        attendeeInDB.setLastName(attendee.lastName);
        attendeeRepository.save(attendeeInDB);
    }

    public void deleteAttendee(int id) {
        attendeeRepository.deleteById(id);
    }

}
