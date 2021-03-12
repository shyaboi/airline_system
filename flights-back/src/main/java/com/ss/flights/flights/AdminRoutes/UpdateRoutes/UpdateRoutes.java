package com.ss.flights.flights.AdminRoutes.UpdateRoutes;

import com.ss.flights.DBConnection.UpdateRow.UpdateRow;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@CrossOrigin(origins = "http://localhost:3000", maxAge = 3600)

@RequestMapping("/admin")

@Component
@ResponseBody

public class UpdateRoutes {
    @Autowired
    UpdateRow update;
    // modular universal update single table/col post map
    @PutMapping("/{table}/{item}/{id}")
    // update any single table/row
    // as a string format such as; airport,iata_id='LLL',city='Lingenberry'
    public String updateRow(@PathVariable("table") String table,@PathVariable("item") String item,@PathVariable("id") String id,@RequestBody String data) {
        // getting new update method from updatecols class

        try {
            update.updateRow(table, item, id, data);
            HttpStatus status = HttpStatus.OK;
            String statusString = status.toString();
            return statusString+" "+item+" "+id+" Updated!";

        } catch (Exception e) {
            // TODO: handle exception
        }
        return data + " Updated to Col and Table";
    }
}
