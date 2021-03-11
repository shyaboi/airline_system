package com.ss.flights.DBConnection.UpdateRow;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ss.flights.DBConnection.Conn;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UpdateRow {
    @Autowired
    Conn conn;
    public String updateRow(String pathTable, String item, String id, String data) {
        // bring in connection from DB new
        // split statment into data and where
        String table = pathTable;
        String where = item + "='" + id + "'";
        String set = item + "='" + data + "'";

        // parse the given data to sql statment
        String sql = "UPDATE " + table + " SET " + set + " WHERE " + where;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            // ps.setString(1,"ok");
            ps.executeUpdate();
            System.out.println("Data added successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO better exception handling
        } finally {
            conn.disconnect();
        }
        return "Data added to" + table + "Successfully";
    }
}