package com.ss.flights.flights.AdminRoutes.GetRoutes;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

@Component
public class Build {
    public ArrayList<String> colMaker(String[] cols, ArrayList<String> tempCol) {
        
        for (String s : cols) {
            tempCol.add(s);    
        } 
        return tempCol;
    }
}
