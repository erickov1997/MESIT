/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.querys;

import com.amats.conn.DBHandler;
import java.util.List;

/**
 *
 * @author Usuario
 */
public class ProccesValidations {
    
    public List StatusLed(String atributo) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List listatribute = handler.Consulta("SELECT " + atributo + " FROM sendDataPlc", atributo);
       // System.out.println("usuarios: " + listatribute);
        return listatribute;
    }
    
    
    public void on_offLed(String atributo, String state, String cond) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeUpdate("UPDATE sendDataPlc SET  " + atributo + "='" + state + "' WHERE " + atributo + "='" + cond + "'");
        
    }
    
     
}
