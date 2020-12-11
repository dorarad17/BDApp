package com.BD.attendees;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Attendee {

    @Id
    @GeneratedValue
    public int id;
    public String firstName;
    public String lastName;
    public Boolean attending;
    public String email;

    public Attendee(){

    }

    public Attendee(int id, String firstName, String lastName, Boolean attending, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.attending = attending;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Boolean getAttending() { return attending; }

    public void setAttending(Boolean attending) { this.attending = attending; }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getEmail() {
        return email;
    }
}
