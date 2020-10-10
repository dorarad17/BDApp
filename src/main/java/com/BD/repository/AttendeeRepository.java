package com.BD.repository;

import com.BD.attendees.Attendee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

@Component
public interface AttendeeRepository extends JpaRepository <Attendee, String> {
    Attendee getAttendee(String id);
}
