package com.BD.attendees;

import com.BD.exceptions.AttendeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


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
        Optional <Attendee> attendeeInDB = attendeeRepository.findById(id);
        if (attendeeInDB.isEmpty()) {
            throw new AttendeeNotFoundException("Cannot find Attendee with id: " + id);
        }
        else {
            Attendee attendeeToUpdate = attendeeInDB.get();
            attendeeToUpdate.setFirstName(attendee.firstName);
            attendeeToUpdate.setLastName(attendee.lastName);
            attendeeRepository.save(attendeeToUpdate);
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

}
