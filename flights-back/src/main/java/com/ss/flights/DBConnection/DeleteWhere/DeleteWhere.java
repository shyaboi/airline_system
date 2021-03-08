package com.ss.flights.DBConnection.DeleteWhere;

import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.ss.flights.DBConnection.Conn;

public class DeleteWhere {
    
    public String delete(String data) {
        // bring in connection from DB new
        Conn conn = new Conn();
        // split statment into data and where
        String[] sData = data.split(",");
        String table = sData[0];
        String where = sData[1];

        // parse the given data to sql statment
        String sql = "DELETE FROM " + table + " WHERE " + where;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            // ps.setString(1,"ok");
            ps.executeUpdate();
            System.out.println("Data Deleted successfully");

        } catch (SQLException e) {
            e.printStackTrace();
            // TODO better exception handling
        } finally {
            conn.disconnect();
        }
        return "Data added to" + table + "Successfully";
    }
}