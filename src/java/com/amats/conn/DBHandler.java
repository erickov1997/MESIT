/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.conn;


import com.amats.app.ProccesBean;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Usuario
 */
public class DBHandler {
    
    public Connection conn;

    public DBHandler() {
    }

    public void getConnection() throws ClassNotFoundException {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            conn = DriverManager.getConnection("jdbc:sqlserver://localhost:1433;databaseName=db2",
                    "amats", "amats");
            System.out.println("Connection succesfully BD");
            if (conn == null) {
                System.out.println("No connection obtained... Please check");
            }
        } catch (SQLException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    public List viewProcces(String sqlStatement) throws ClassNotFoundException, InterruptedException {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getString("nombre"));
                    l.add(rs.getString("n_parte"));
                    l.add(rs.getString("nom_parte"));

                    l.add(rs.getString("hora_ini_prep"));
                    l.add(rs.getString("min_ini_prep"));
                    l.add(rs.getString("seg_ini_prep"));

                    l.add(rs.getString("hora_fin_prep"));
                    l.add(rs.getString("min_fin_prep"));
                    l.add(rs.getString("seg_fin_prep"));

                    l.add(rs.getString("hora_ini_proc"));
                    l.add(rs.getString("min_ini_proc"));
                    l.add(rs.getString("seg_ini_proc"));

                    l.add(rs.getString("hora_fin_proc"));
                    l.add(rs.getString("min_fin_proc"));
                    l.add(rs.getString("seg_fin_proc"));

                    l.add(rs.getString("piezas"));
                    l.add(rs.getString("fecha"));
                    l.add(rs.getString("dia"));
                    l.add(rs.getString("mes"));
                    l.add(rs.getString("año"));
                    
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    
    
    public void executeUpdate(String sqlStatement) {

        if (conn != null) {
            try {
                Statement statement = conn.createStatement();
                statement.executeUpdate(sqlStatement);
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }
    
    public List Consulta(String sqlStatement, String atributo) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getString(atributo));

                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    
    public List viewHistProcces(String sqlStatement) throws ClassNotFoundException, InterruptedException {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    ProccesBean li = new ProccesBean();
                    li.setNom(rs.getString("nombre"));
                    li.setNparte(rs.getString("n_parte"));
                    li.setNomparte(rs.getString("nom_parte"));

                    li.setHora_ini_prep(rs.getString("hora_ini_prep"));
                    li.setMin_ini_prep(rs.getString("min_ini_prep"));
                    li.setSeg_ini_prep(rs.getString("seg_ini_prep"));

                    li.setHora_fin_prep(rs.getString("hora_fin_prep"));
                    li.setMin_fin_prep(rs.getString("min_fin_prep"));
                    li.setSeg_fin_prep(rs.getString("seg_fin_prep"));

                    li.setHora_ini_proc(rs.getString("hora_ini_proc"));
                    li.setMin_ini_proc(rs.getString("min_ini_proc"));
                    li.setSeg_ini_proc(rs.getString("seg_ini_proc"));

                    li.setHora_fin_proc(rs.getString("hora_fin_proc"));
                    li.setMin_fin_proc(rs.getString("min_fin_proc"));
                    li.setSeg_fin_proc(rs.getString("seg_fin_proc"));

                    li.setPiezas(rs.getString("piezas"));
                    li.setFecha(rs.getString("fecha"));
                    li.setDia(rs.getString("dia"));
                    li.setMes(rs.getString("mes"));
                    li.setAño(rs.getString("año"));
                    l.add(li);
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    
    
    
    
    
    //Consulta segmentos
    public List executeQuery(String sqlStatement, String color1, String color2, String color3, 
            String blink, String flash) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getInt(color1));
                    l.add(rs.getInt(color2));
                    l.add(rs.getInt(color3));
                    l.add(rs.getInt(blink));
                    l.add(rs.getInt(flash));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }

    public List executeQuery(String sqlStatement, String offbuff, String blink, String flash) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getInt(offbuff));
                    l.add(rs.getInt(blink));
                    l.add(rs.getInt(flash));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    
    
    public List SelectOnOFF(String sqlStatement, String atributo) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getString(atributo));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    
    public List SelectOnOFF2(String sqlStatement, String atributo) {
        List l = null;
        if (conn != null) {
            try {
                PreparedStatement ps = conn.prepareStatement(sqlStatement);
                ResultSet rs = ps.executeQuery();
                l = new ArrayList();
                while (rs.next()) {
                    l.add(rs.getString(atributo));
                }
            } catch (SQLException ex) {
                Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return l;
    }
    public static void main(String[] args) {
        try {
            new DBHandler().getConnection();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
