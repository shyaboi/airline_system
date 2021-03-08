package com.ss.flights.flights;

import java.util.ArrayList;

//local class imports
import com.ss.flights.DBConnection.GetAllDataTable.*;
import com.ss.flights.DBConnection.UpdateRow.UpdateRow;
import com.ss.flights.DBConnection.AddDataToTable.*;
import com.ss.flights.DBConnection.DeleteWhere.DeleteWhere;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)
// creating spring rest controller
@RestController
// mapping to airports route
@RequestMapping("/admin")
// declare class AirportController
public class AdminRouteController {

    // UPDATE POST
    // ROUTE==========================================================================================================
    // modular universal update single table/col post map
    @PostMapping("/deleteRow")
    // delete any single table/row
    // as a string format such as; airport,iata_id='LLL'
    public String deleteRow(@RequestBody String data) {
        System.out.println(data);
        // getting new update method from updatecols class
        DeleteWhere del = new DeleteWhere();
        del.delete(data);
        return data + " Deleted!!!!!!!!!!!";
    }
    // END UPDATE POST
    // ROUTE==========================================================================================================

    // UPDATE POST
    // ROUTE==========================================================================================================
    // modular universal update single table/col post map
    @PostMapping("/updateRow")
    // update any single table/row
    // as a string format such as; airport,iata_id='LLL',city='Lingenberry'
    public String updateRow(@RequestBody String data) {
        // getting new update method from updatecols class
        UpdateRow up = new UpdateRow();
        up.updateRow(data);
        return data + " Updated to Col and Table";
    }
    // END UPDATE POST
    // ROUTE==========================================================================================================

    // addAirport post route
    // ----------------------------------------------------------------------------------------------------------------------
    // map to /admin/addAirport
    @PostMapping("/addAirport")
    // add airport via post data via string of what airport iata_id and city to add
    // as a string format such as; 'DDD', 'TripleDtown'
    public String addAirport(@RequestBody String data) {
        AddDataToTable add = new AddDataToTable();
        String table = "airport";
        String[] cols = { "iata_id", "city" };

        // add given data
        add.addTableData(table, cols, data);
        // split data for presentation
        String[] sData = data.split(",");

        return "iata_id: " + sData[0] + " , City: " + sData[1] + " Was added to the DB of Airports!";
    }
    // End addAirport post route
    // ----------------------------------------------------------------------------------------------------------------------

    // addFlights post route
    // ----------------------------------------------------------------------------------------------------------------------
    // map to /admin/addFlights
    @PostMapping("/addFlight")
    // add airport via post data via string of what airport iata_id and city to add
    // as a string format such as; 4,2,1,20210211102222,33,200
    public String addFlight(@RequestBody String data) {
        AddDataToTable add = new AddDataToTable();
        String table = "flight";
        String[] cols = { "id", "route_id", "airplane_id", "departure_time", "reserved_seats", "seat_price" };

        // add given data
        add.addTableData(table, cols, data);
        // split data for presentation
        // String[] sData = data.split(",");

        return "Flight data: " + data + " added Successful! ";
    }
    // End addFLights post route
    // ----------------------------------------------------------------------------------------------------------------------

    // addBooking post route
    // ----------------------------------------------------------------------------------------------------------------------
    // map to /admin/addBooking
    @PostMapping("/addPassenger")
    // add airport via post data via string of what airport iata_id and city to add
    // as a string format such as; 9,2,'name','fam',19990222,'F','123 faker st'
    public String addPassenger(@RequestBody String data) {
        AddDataToTable add = new AddDataToTable();
        String table = "passenger";
        String[] cols = { "id", "booking_id", "given_name", "family_name", "dob", "gender", "address" };

        // add given data
        add.addTableData(table, cols, data);
        // split data for presentation
        // String[] sData = data.split(",");

        return "Booking data: " + data + " added Successful! ";
    }
    // End addBooking post route
    // ----------------------------------------------------------------------------------------------------------------------

    // addBooking post route
    // ----------------------------------------------------------------------------------------------------------------------
    // map to /admin/addBooking
    @PostMapping("/addBooking")
    // add airport via post data via string of what airport iata_id and city to add
    // as a string format such as; 6,1,'334567'
    public String addBooking(@RequestBody String data) {
        AddDataToTable add = new AddDataToTable();
        String table = "booking";
        String[] cols = { "id", "is_active", "confirmation_code" };

        // add given data
        add.addTableData(table, cols, data);
        // split data for presentation
        // String[] sData = data.split(",");

        return "Booking data: " + data + " added Successful! ";
    }
    // End addBooking post route
    // ----------------------------------------------------------------------------------------------------------------------

    // addBooking_agent post route
    // ----------------------------------------------------------------------------------------------------------------------
    // map to /admin/addBooking
    @PostMapping("/addEmployee")
    // add airport via post data via string of what airport iata_id and city to add
    // as a string format such as; 8,6
    public String addEmployee(@RequestBody String data) {
        AddDataToTable add = new AddDataToTable();
        String table = "booking_agent";
        String[] cols = { "booking_id", "agent_id" };

        // add given data
        add.addTableData(table, cols, data);
        // split data for presentation
        // String[] sData = data.split(",");

        return "Booking data: " + data + " added Successful! ";
    }
    // End addBooking_agent post route
    // ----------------------------------------------------------------------------------------------------------------------

    // End ADD ROUTES
    // ----------------------------------------------------------------------------------------------------------------------
    // =======================================================================================================================

    // Start Get All ROUTES
    // ----------------------------------------------------------------------------------------------------------------------
    // =======================================================================================================================
    // allAirports Get route
    // ---------------------------------------------------------------------------------------------------------------
    @GetMapping(path = "/allAirports", produces = "application/json")
    // return a list of all airports
    public ArrayList<String> getAllAirports(ArrayList<String> airports) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "iata_id", "city" };
        // return the ArrayList of Strings
        return getAll.getTableData(airports, "airport", dataList);
    }
    // END allAirports Get route
    // ---------------------------------------------------------------------------------------------------------------

    // allFlights Get route
    // ---------------------------------------------------------------------------------------------------------------
    @GetMapping("/allFlights")
    // return a list of all airports
    public ArrayList<String> getAllFlights(ArrayList<String> flights) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "id", "route_id", "airplane_id", "departure_time", "reserved_seats", "seat_price" };
        // return the ArrayList of Strings
        return getAll.getTableData(flights, "flight", dataList);
    }
    // END allFlights Get route
    // ---------------------------------------------------------------------------------------------------------------

    // allBookings Get route
    // ---------------------------------------------------------------------------------------------------------------
    @GetMapping("/allBookings")
    // return a list of all airports
    public ArrayList<String> getAllBookings(ArrayList<String> bookings) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "id", "is_active", "confirmation_code" };
        // return the ArrayList of Strings
        return getAll.getTableData(bookings, "booking", dataList);
    }

    // END allBookings Get route
    // ---------------------------------------------------------------------------------------------------------------

    // allPassangers Get route
    // ---------------------------------------------------------------------------------------------------------------
    @GetMapping("/allPassengers")
    // return a list of all airports
    public ArrayList<String> getAllPassangers(ArrayList<String> passangers) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "id", "booking_id", "given_name", "family_name", "dob", "gender", "address" };
        // return the ArrayList of Strings
        return getAll.getTableData(passangers, "passenger", dataList);
    }
    // END allPassangers Get route
    // ---------------------------------------------------------------------------------------------------------------

    // allEmployees Get route
    // ---------------------------------------------------------------------------------------------------------------
    @GetMapping("/allEmployees")
    // return a list of all airports
    public ArrayList<String> getAllEmployees(ArrayList<String> employees) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "booking_id", "agent_id" };
        // return the ArrayList of Strings
        return getAll.getTableData(employees, "booking_agent", dataList);
    }
    // END allEmployees Get route
    // ---------------------------------------------------------------------------------------------------------------

    // allUsers Get
    // ---------------------------------------------------------------------------------------------------------------

    // map to /admin/allUsers
    @GetMapping("/allUsers")
    // return a list of all airports
    public ArrayList<String> getAllUsers(ArrayList<String> users) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "id", "role_id", "given_name", "family_name", "username", "email", "password", "phone" };
        // return the ArrayList of Strings
        return getAll.getTableData(users, "user", dataList);
    }
    // END allUsers Get
    // ---------------------------------------------------------------------------------------------------------------

    // allAirplanes Get
    // ---------------------------------------------------------------------------------------------------------------

    // map to /admin/allUsers
    @GetMapping("/allAirplanes")
    // return a list of all airports
    public ArrayList<String> getAllAirplanes(ArrayList<String> users) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "id", "type_id" };
        // return the ArrayList of Strings
        return getAll.getTableData(users, "airplane", dataList);
    }
    // END allUsers Get
    // ---------------------------------------------------------------------------------------------------------------

    // allAirplanesType Get
    // ---------------------------------------------------------------------------------------------------------------

    // map to /admin/allUsers
    @GetMapping("/allAirplaneTypes")
    // return a list of all airports
    public ArrayList<String> getAllAirplaneTypes(ArrayList<String> users) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "id", "max_capacity" };
        // return the ArrayList of Strings
        return getAll.getTableData(users, "airplane_type", dataList);
    }
    // END allUsers Get
    // ---------------------------------------------------------------------------------------------------------------

    // allAirplanesType Get
    // ---------------------------------------------------------------------------------------------------------------

    // map to /admin/allUsers
    @GetMapping("/allRoutes")
    // return a list of all airports
    public ArrayList<String> getAllRoutes(ArrayList<String> users) {
        // make new get all from sql
        GetAllDataTable getAll = new GetAllDataTable();
        // parse the values of iata_id and city to String[]
        String[] dataList = { "id", "origin_id", "destination_id" };
        // return the ArrayList of Strings
        return getAll.getTableData(users, "route", dataList);
    }
    // END allUsers Get
    // ---------------------------------------------------------------------------------------------------------------
}
