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
public class SegmentosValidations {

    public List Consulta(String atributo) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List listatribute = handler.Consulta("SELECT " + atributo + " FROM segmentos", atributo);
        System.out.println("usuarios: " + listatribute);
        return listatribute;
    }
    
    public List Consulta2(String atributo) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List listatribute = handler.SelectOnOFF2("SELECT " + atributo + " FROM segmentos", atributo);
        System.out.println("usuarios: " + listatribute);
        return listatribute;
    }
    
    public List Consulta3(String atributo) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List listatribute = handler.SelectOnOFF("SELECT " + atributo + " FROM segmentos", atributo);
        System.out.println("usuarios: " + listatribute);
        return listatribute;
    }
    
    public List HistSegmentos(String tabla,String atributo) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        List listHistSeg = handler.Consulta("SELECT " + atributo + " FROM " + tabla + "", atributo);
        System.out.println("usuarios: " +  listHistSeg);
        return  listHistSeg;
    }
    
    public void UpdateHistSeg(String tabla,String atributo, String state) throws ClassNotFoundException {
        //String cond="1";
        int cond=1;
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeUpdate("UPDATE " + tabla + " SET  " + atributo + "='" + state + "' WHERE id ='" + cond + "'");
        System.out.println("atributo: "+ atributo);
        
    }
    
    public void SET(String atributo, String state, String cond) throws ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        handler.executeUpdate("UPDATE segmentos SET  " + atributo + "='" + state + "' WHERE " + atributo + "='" + cond + "'");
        
    }
    

    public static void main(String[] args) {
        String var="btn";
        String tabla="onhistorico_segmentos";
        try {
           int btn=Integer.parseInt((String) new SegmentosValidations().HistSegmentos(tabla,var+"s1rojo").get(0))+1;
           new SegmentosValidations().UpdateHistSeg(tabla,var+"s1rojo", String.valueOf(btn));
           System.out.println("btns: "+btn);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(SegmentosValidations.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

}
