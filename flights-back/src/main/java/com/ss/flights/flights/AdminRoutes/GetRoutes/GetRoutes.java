package com.ss.flights.flights.AdminRoutes.GetRoutes;

import java.util.ArrayList;

import com.ss.flights.DBConnection.GetAllRows.GetAllRows;
import com.ss.flights.flights.AdminRoutes.AddRoutes.Columns;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

@RequestMapping("/admin")
@Component
@ResponseBody
public class GetRoutes {
    @Autowired
    GetAllRows get;

    @Autowired
    Columns col;

    @GetMapping(path = "/{table}", produces = "application/json")
    // return a list of all airports
    public ArrayList<ArrayList<String>> getAll(@PathVariable("table") String pathTable,
            ArrayList<ArrayList<String>> airports) {
        String table = pathTable;

        switch (table) {
        case "airport":
            // // add airport via post data via string of what airport iata_id and city to
            // // as a string format such as; 'ZZZ','SLeepytown'
            String[] airportCols = { "iata_id", "city" };

            try {
                
                ArrayList<ArrayList<String>> airportResult = get.getAllRows(airports, table, airportCols);
                System.out.println();
                return airportResult;
            } catch (Exception e) {
                //TODO: handle exception
            }
        case "flight":
            
            try {
                
                String[] flightCols = { "id", "route_id", "airplane_id", "departure_time", "reserved_seats", "seat_price" };
                ArrayList<ArrayList<String>> flightsResult = get.getAllRows(airports, table, flightCols);
                return flightsResult;
            } catch (Exception e) {
                //TODO: handle exception
            }

            break;
        case "passenger":
      
            try {
                
                String[] passengerCols = { "id", "booking_id", "given_name", "family_name", "dob", "gender", "address" };
                ArrayList<ArrayList<String>> passengerResult = get.getAllRows(airports, table, passengerCols);
                return passengerResult;
            } catch (Exception e) {
                //TODO: handle exception
            }

            break;
       
       
            case "booking":
         
            try {
                
                String[] bookingCols = { "id", "is_active", "confirmation_code" };
                ArrayList<ArrayList<String>> bookingResult = get.getAllRows(airports, table, bookingCols);
                return bookingResult;
            } catch (Exception e) {
                //TODO: handle exception
            }

            break;
            
            
            case "employee":
            try {
                
                String[] bookingCols = { "employee_id", "first_name", "last_name" };
                ArrayList<ArrayList<String>> bookingResult = get.getAllRows(airports, table, bookingCols);
                return bookingResult;
            } catch (Exception e) {
                //TODO: handle exception
            }

            break;
          
          
            case "user":
            try {
                
                String[] userCols = { "id", "role_id", "given_name", "family_name", "username", "email", "password", "phone" };
                ArrayList<ArrayList<String>> userResult = get.getAllRows(airports, table, userCols);
                return userResult;
            } catch (Exception e) {
                //TODO: handle exception
            }

            break;
          
          
            case "airplane":
            try {
                
                String[] airplaneCols = { "id", "type_id" };
                ArrayList<ArrayList<String>> airplaneResult = get.getAllRows(airports, table, airplaneCols);
                return airplaneResult;
            } catch (Exception e) {
                //TODO: handle exception
            }

            break;
           
           
            case "route":
            try {
                
                String[] routeList = { "id", "origin_id", "destination_id" };
                ArrayList<ArrayList<String>> routeResult = get.getAllRows(airports, table, routeList);
                return routeResult;
            } catch (Exception e) {
                //TODO: handle exception
            }

            break;
            default:                   
            // return the ArrayList of Strings1

        }
        String[] defaul = {"df","dsfsd"};
        ArrayList<ArrayList<String>> ok = get.getAllRows(airports, "flight", defaul);
        System.out.println(ok);
        return ok;
    }
}