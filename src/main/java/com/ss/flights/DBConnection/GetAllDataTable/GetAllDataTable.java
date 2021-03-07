package com.ss.flights.DBConnection.GetAllDataTable;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ss.flights.DBConnection.Conn;

public class GetAllDataTable {
    public ArrayList<String> getTableData(ArrayList<String> list,String table, String... optional) {
        //bring in connection from DB new
        Conn conn = new Conn();
        //
        String sql = "SELECT * FROM " + table;
        try {
            PreparedStatement ps = conn.connect().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {
                for (String s : optional) {
                    String x = rs.getString(s);
                    list.add(x);
                }

                /*
                *LEGACY PRINTS TO CHECK DATA FROM DIFFERENT TABLES
                 *  String city = rs.getString("city");
                 *  list.add(city); 
                 *  System.out.println(city);
                 *
                 */
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            conn.disconnect();
        }
        return list;
    }
}
