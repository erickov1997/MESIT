/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.querys;


import com.amats.app.ProccesBean;
import com.amats.conn.DBHandler;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class GetProccesValidation {
    public List getListProcces() throws ClassNotFoundException, InterruptedException{
        List<ProccesBean> listUser;
        DBHandler handler = new DBHandler();
        handler.getConnection();
        listUser = handler.viewProcces("SELECT TOP 1 * FROM RegProduccionActual order by id desc");     
        return listUser;
    }
    
     public List ListProccesHist() throws ClassNotFoundException, InterruptedException{
        List<ProccesBean> listUser;
        DBHandler handler = new DBHandler();
        handler.getConnection();
        listUser = handler.viewHistProcces("SELECT * FROM RegProduccion order by id desc");
        return listUser;
    }
    
    
   
    public static void main(String[] args) {

    }
    
}
