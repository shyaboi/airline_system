package com.ss.flights.flights.AdminRoutes.AddRoutes;

import java.util.ArrayList;

import com.ss.flights.DBConnection.AddRow.AddRow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

@RequestMapping("/admin")
@ResponseBody
@Component
@ComponentScan("com.ss.flights")
public class AddRoutes {

    @Autowired
    AddRow add;

    @Autowired
    Columns col;

    @PostMapping("/{table}")
    // add airport via post data via string of what airport iata_id and city to add
    // as a string format such as; 'DDD', 'TripleDtown'
    public String addAirport(@PathVariable("table") String pathTable, @RequestBody String data,
            ArrayList<String> cols) {

        String table = pathTable;

        switch (table) {
        case "airport":
            // // add airport via post data via string of what airport iata_id and city to
            // // as a string format such as; 'ZZZ','SLeepytown'
            String[] AirportCols = { "iata_id", "city" };
            try {
                col.colMaker(AirportCols, cols);

            } catch (Exception e) {
                // TODO: handle exception
            }
            break;
        case "flight":
            /*
             * add airport via post data via string of what airport iata_id and city to
             * "id", "route_id", "airplane_id", "departure_time", reserved_seats",
             * "seat_price" as a string format such as; 4,2,1,20210211102222,33,200
             */
            String[] flightCols = { "id", "route_id", "airplane_id", "departure_time", "reserved_seats", "seat_price" };
            try {
                col.colMaker(flightCols, cols);

            } catch (Exception e) {
                // TODO: handle exception
            }
            break;
        case "booking":
            // // add Booking via post data via string of id, is_active, confirmation code
            // // as a string format such as; 6,1,'334567'
            String[] bookingCols = { "id", "is_active", "confirmation_code" };
            try {
                col.colMaker(bookingCols, cols);

            } catch (Exception e) {
                // TODO: handle exception
            }
            break;

        case "passanger":
            // // add passanger via post data via string of
            // id,booking_id,given_name,family_name,dob,gender,address
            // // as a string format such as; 9,2,'name','fam',19990222,'F','123 faker st'
            String[] passengerCols = { "id", "booking_id", "given_name", "family_name", "dob", "gender", "address" };
            try {
                col.colMaker(passengerCols, cols);

            } catch (Exception e) {
                // TODO: handle exception
            }
            break;

        case "employee":
            // // add Employee via post data via string of
            // bookin id, agent id
             // // as a string format such as; 8,6
            String[] employeeCols = { "employee_id", "first_name", "last_name" };
            try {
                col.colMaker(employeeCols, cols);

            } catch (Exception e) {
                // TODO: handle exception
            } 
            break;
        
        
            case "route":
            // // add route via post data via string of
            // route id, and 2 iata_ids from airports
             // // as a string format such as; 9, 'SLO', 'LAX'
            String[] routeCols = { "id", "origin_id", "destination_id" };
            try {
                col.colMaker(routeCols, cols);

            } catch (Exception e) {
                // TODO: handle exception
            } 
            break;
        default:
            break;
        }

        // add given data
        try {
            add.addTableData(table, cols, data);
        } catch (Exception e) {
            // TODO: handle exception
        }
        // split data for presentation
        return "OK," + data + " Was added to" + table + cols;
    }
    // End addAirport post route
    //
}
