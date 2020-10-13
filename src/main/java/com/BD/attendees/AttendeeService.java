package com.BD.attendees;

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

    @PostConstruct
    public void init(){
        try{
            Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
            Statement statement = connection.createStatement();
            statement.execute("CREATE TABLE attendees(id int PRIMARY KEY AUTOINCREMENT, firstName text, lastName text);");
            statement.execute("INSERT INTO attendees ('Liam','Shove');");
            connection.commit();
        }
        catch (SQLException e){

        }
    }

//    private List<Attendee> attendees = new ArrayList<>(Arrays.asList(
////                new Attendee("0001","Liam","Shove"),
////                new Attendee("0002","Dora","Radosevic"),
////                new Attendee("0003","Gary","Z")));

    public List<Attendee> getAllAttendees(){
        try {
            List<Attendee> attendees = new ArrayList<Attendee>();
            Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
            PreparedStatement statement = connection.prepareStatement("select * from attendees;");
            //return attendees.stream().filter(a -> a.getId().equals(id)).findAny().get();
            statement.execute();
            ResultSet result = statement.getResultSet();
            while(!result.isAfterLast()){
                Attendee attendee = new Attendee(result.getInt("id"),result.getString("firstName"),result.getString("lastName"));
                attendees.add(attendee);
                result.next();
            }
            return attendees;
        }
        catch(SQLException e) {
            return null;
        }
    }

    public Attendee getAttendee(int id){
        try {
            Connection connection = DriverManager.getConnection("jdbc:sqlite::memory:");
            PreparedStatement statement = connection.prepareStatement("select * from attendees where id = ?;");
            //return attendees.stream().filter(a -> a.getId().equals(id)).findAny().get();
            statement.setInt(0,id);
            statement.execute();
            ResultSet result = statement.getResultSet();

            if(result.isAfterLast()){
                return null;
            }
            else {
                return new Attendee(result.getInt("id"),result.getString("firstName"),result.getString("lastName"));
            }
        }
        catch(SQLException e) {
            return null;
        }
    }

//
//    public void addAttendee(Attendee attendee) {
//        attendees.add(attendee);
//    }
//
//    public void updateAttendee(String id, Attendee attendee) {
//        for(Attendee a : attendees){
//            if (a.getId().equals(id)) {
//                attendees.set(attendees.indexOf(a),attendee);
//                return;
//            }
//        }
//    }
//
//    public void deleteAttendee(String id) {
//        attendees.removeIf(a -> a.getId().equals(id));
//    }
}
