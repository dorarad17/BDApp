package com.BD.attendees;

import com.BD.exceptions.AttendeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
public class AttendeeService {

    @Autowired
    AttendeeRepository attendeeRepository;

    public List<Attendee> getAllAttendees(){
        List<Attendee> attendees = new ArrayList<>();
        attendeeRepository.findAll().forEach(attendees::add);
        return attendees;
    }

    public Attendee getAttendee(int id)  {
        Optional<Attendee> attendeeInDB = attendeeRepository.findById(id);
        if (attendeeInDB.isEmpty()) {
            throw new AttendeeNotFoundException("Cannot find Attendee with id: " + id);
        }
        else {
            return attendeeInDB.get();
        }
    }

    public void addAttendee(Attendee attendee) {
        attendeeRepository.save(attendee);
    }

    public void updateAttendee(int id, Attendee attendee) {

        Optional <Attendee> findAttendee = attendeeRepository.findById(id);
        if (findAttendee.isEmpty()) {
            throw new AttendeeNotFoundException("Cannot find Attendee with id: " + id);
        }
        else {
        Attendee attendeeInDB = findAttendee.get();
        attendeeInDB.setFirstName(attendee.firstName);
        attendeeInDB.setLastName(attendee.lastName);
        attendeeInDB.setAttending(attendee.attending);
        attendeeInDB.setEmail(attendee.email);
        attendeeRepository.save(attendeeInDB);
        }
    }

    public void deleteAttendee(int id) {
        Optional<Attendee> attendeeInDB = attendeeRepository.findById(id);
        if (attendeeInDB.isEmpty()) {
            throw new AttendeeNotFoundException("Cannot find Attendee with id: " + id);
        }
        else {
            attendeeRepository.deleteById(id);
        }
    }

    public static List<Attendee> getAttendingList (List <Attendee> attendees) {
        return attendees.stream()
                .filter(Attendee::getAttending).collect(Collectors.toList());
    }

    public static String getFullName (Attendee attendee) {
        return attendee.firstName + " " + attendee.lastName;
    }

}
