package com.ss.flights.DBConnection.GetAllRows;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ss.flights.DBConnection.Conn;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
@Component
public class GetAllRows {

    public ArrayList<ArrayList<String>> getAllRows(ArrayList<ArrayList<String>> list,String table, String... optional) {
        //bring in connection from DB new
        Conn conn = new Conn();
        //sql statment 
        String sql = "SELECT * FROM " + table;
        try {
            
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                ArrayList<String> listy= new ArrayList<>();
                for (String s : optional) {
                    String x = rs.getString(s);
                    listy.add(x);
                }
                list.add(listy);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("Exception occurred");
        } finally {
            conn.disconnect();
        }
        return list;
    }
}
