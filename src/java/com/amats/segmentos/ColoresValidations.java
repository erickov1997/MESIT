/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.segmentos;

import com.amats.conn.DBHandler;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class ColoresValidations {
    
     public List GetSegmentosOffOn(String tabla,String color1,String color2,String color3,String flash,String blink) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List list = handler.executeQuery("SELECT " + color1 + "," + color2 + "," + color3 + "," + flash + "," + blink + " FROM " + tabla + "", color1, color2, color3, flash, blink);
        System.out.println("usuarios: " +  list);
        return  list;
    }
     
    public List GetBuffOffOn(String tabla,String buff,String flash,String blink) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List list = handler.executeQuery("SELECT " + buff + "," + flash + "," + blink + " FROM " + tabla + "", buff, flash, blink);
        System.out.println("usuarios: " +  list);
        return  list;
    } 
     
     
}
