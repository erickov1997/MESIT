/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.segmentos;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Base64;

/**
 *
 * @author Usuario
 */
public class jobSend {
    
    public void onjob() {
        try {

            String uri = "http://192.168.3.3/v1/job.json?";
            //uri += "action=oneshot&name=JobDatosProduccion";
            uri += "action=oneshot&name=JobSegmentos";
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
    
}
