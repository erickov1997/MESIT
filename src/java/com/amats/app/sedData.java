/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.app;

import com.amats.querys.ProccesValidations;
import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named("appsendData")
@SessionScoped
public class sedData implements Serializable {
     String varialePlc;
    String on;
    String off;

    public String getOn() {
        return on;
    }

    public void setOn(String on) {
        this.on = on;
    }

    public String getOff() {
        return off;
    }

    public void setOff(String off) {
        this.off = off;
    }

   
    
    

    public sedData() {
        this.varialePlc = "";
    }

    public String getVarialePlc() {
        return varialePlc;
    }

    public void setVarialePlc(String varialePlc) {
        this.varialePlc = varialePlc;
    }

    public void onjob() {
        try {

            String uri = "http://192.168.3.3/v1/job.json?";
            //uri += "action=oneshot&name=JobDatosProduccion";
            uri += "action=oneshot&name=JobSendDataPlc";
            System.err.println(uri);

            URL url = new URL(uri);
            URLConnection conn = url.openConnection();
            conn.setDoOutput(true);
            conn.setUseCaches(false);

            String account = "RD81MES96:MITSUBISHI";
            Base64.Encoder encoder = Base64.getEncoder();
            String enc_account = encoder.encodeToString(account.getBytes()); //Encoding to Base64
            conn.setRequestProperty("Authorization", "Basic " + enc_account);

            InputStream inputStream = conn.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            String str;
            //System.out.println(uri);
            while ((str = reader.readLine()) != null) {
                //System.out.println(str);
            }
            reader.close();
        } catch (Exception e) {
            System.err.println("Error\n" + e);
        }
    }
    
    
     public void coloresSegmentos(String atributo) {
        try {
            String condi = (String) new ProccesValidations().StatusLed(atributo).get(0);
            try {
                if (condi.equals("0")) {
                    on="La variable"+atributo+"se encuentra encendido";
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "La variable "+ atributo +" se encuentra encendido", null);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                    new  ProccesValidations().on_offLed(atributo, "1", "0");
                    new sedData().onjob();
                } else if (condi.equals("1")) {
                    off="La variable"+atributo+"se encuentra apagado";
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "La variable "+atributo+ " se encuentra apagado", null);
                    FacesContext.getCurrentInstance().addMessage(null, fm);
                    new ProccesValidations().on_offLed(atributo, "0", "1");
                    new sedData().onjob();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(sedData.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(sedData.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void onLed(){
            
        }
    
}
