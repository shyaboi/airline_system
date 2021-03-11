package com.ss.flights.flights.AdminRoutes.AddRoutes;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Columns {
    public ArrayList<String> colMaker(String[] cols, ArrayList<String> tempCol) {
        
        for (String s : cols) {
            tempCol.add(s);    
        } 
        return tempCol;
    }
}
