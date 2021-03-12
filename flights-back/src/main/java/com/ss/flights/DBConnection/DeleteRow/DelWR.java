package com.ss.flights.DBConnection.DeleteRow;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ss.flights.DBConnection.Conn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DelWR {
       
    @Autowired
    Conn conn;
    
    public String delete(String table,String item, String id) {

        // parse the given data to sql statment
        String sql = "DELETE FROM " + table + " WHERE " + item +"='"+id+"'";
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ps.executeUpdate();
            System.out.println("Data Deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            e.getErrorCode();
            // TODO better exception handling
            
        } finally {
            conn.disconnect();
        }
        return "Data added to" + table + "Successfully";
    }
}