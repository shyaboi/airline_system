package com.ss.flights.DBConnection.AddRow;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ss.flights.DBConnection.Conn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

// universal add data to any all string table method 
@Component
public class AddRow {
    @Autowired
    Conn conn;
    //add table data methos taking in table, string[] with DB cols and what values to add
    public String addTableData(String table, ArrayList<String> cols,  String value) {
     
   
        //make a new string builder
        StringBuilder colBuilder = new StringBuilder();
        //for loop through given cols to make new string from array
        for (String s : cols) {
            if (colBuilder.length() > 0){colBuilder.append(s).append(",");};
        }
        //convert finished string builder to string
        String builtCols = colBuilder.toString();

        //parse the given data to sql statment
        String sql = "INSERT INTO " + table + " (" + builtCols + ")" + "Values (" + value + ")";
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            // ps.setString(1,"ok");
            ps.executeUpdate();
            System.out.println("Data added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            //TODO better exception handling
        } finally {
            conn.disconnect();
        }
        return "Data added to" + table + "Successfully";
    }
}
