package com.ss.flights.flights.AdminRoutes.DeleteRoutes;

import com.ss.flights.DBConnection.DeleteRow.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

@RequestMapping("/admin")
@ResponseBody

@Component
public class DeleteRoutes {

    @Autowired
    DelWR del;
    // modular universal update single table/col post map
    @DeleteMapping("/{table}/{item}/{id}")
    // delete any single table/row
    // as a string format such as; airport,iata_id='LLL'
    public String deleteRow(@PathVariable("table") String table,@PathVariable("item") String item,@PathVariable("id") String id, @RequestBody String secret) {
        
        // getting new update method from updatecols class
        try {
            del.delete(table, item, id);

        } catch (Exception e) {
            System.out.println(e);
            // TODO: handle exception 
        }
        return "ok";
    }
    
}
