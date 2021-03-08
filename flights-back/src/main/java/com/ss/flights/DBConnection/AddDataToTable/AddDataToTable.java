package com.ss.flights.DBConnection.AddDataToTable;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ss.flights.DBConnection.Conn;

// universal add data to any all string table method 
public class AddDataToTable {
    //add table data methos taking in table, string[] with DB cols and what values to add
    public String addTableData(String table, String[] cols,  String value) {
        // bring in connection from DB new
        Conn conn = new Conn();
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
