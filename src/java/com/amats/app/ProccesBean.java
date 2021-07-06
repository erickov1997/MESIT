/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.app;

import com.amats.querys.GetProccesValidation;
import java.io.Serializable;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */

@Named("appGetProcces")
@SessionScoped

public class ProccesBean implements Serializable {
    
    private String nom;
    private String nparte;
    private String nomparte;

    private String hora_ini_prep;
    private String min_ini_prep;
    private String seg_ini_prep;

    private String hora_fin_prep;
    private String min_fin_prep;
    private String seg_fin_prep;

    private String hora_ini_proc;
    private String min_ini_proc;
    private String seg_ini_proc;

    private String hora_fin_proc;
    private String min_fin_proc;
    private String seg_fin_proc;

    private String piezas;
    private String fecha;
    private String dia;
    private String mes;
    private String año;
    
    
    private List<ProccesBean> listprocces;
    private List<ProccesBean> listhistprocces;

    public ProccesBean() {
        
    }
    
    

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getNparte() {
        return nparte;
    }

    public void setNparte(String nparte) {
        this.nparte = nparte;
    }

    public String getNomparte() {
        return nomparte;
    }

    public void setNomparte(String nomparte) {
        this.nomparte = nomparte;
    }

    public String getHora_ini_prep() {
        return hora_ini_prep;
    }

    public void setHora_ini_prep(String hora_ini_prep) {
        this.hora_ini_prep = hora_ini_prep;
    }

    public String getMin_ini_prep() {
        return min_ini_prep;
    }

    public void setMin_ini_prep(String min_ini_prep) {
        this.min_ini_prep = min_ini_prep;
    }

    public String getSeg_ini_prep() {
        return seg_ini_prep;
    }

    public void setSeg_ini_prep(String seg_ini_prep) {
        this.seg_ini_prep = seg_ini_prep;
    }

    public String getHora_fin_prep() {
        return hora_fin_prep;
    }

    public void setHora_fin_prep(String hora_fin_prep) {
        this.hora_fin_prep = hora_fin_prep;
    }

    public String getMin_fin_prep() {
        return min_fin_prep;
    }

    public void setMin_fin_prep(String min_fin_prep) {
        this.min_fin_prep = min_fin_prep;
    }

    public String getSeg_fin_prep() {
        return seg_fin_prep;
    }

    public void setSeg_fin_prep(String seg_fin_prep) {
        this.seg_fin_prep = seg_fin_prep;
    }

    public String getHora_ini_proc() {
        return hora_ini_proc;
    }

    public void setHora_ini_proc(String hora_ini_proc) {
        this.hora_ini_proc = hora_ini_proc;
    }

    public String getMin_ini_proc() {
        return min_ini_proc;
    }

    public void setMin_ini_proc(String min_ini_proc) {
        this.min_ini_proc = min_ini_proc;
    }

    public String getSeg_ini_proc() {
        return seg_ini_proc;
    }

    public void setSeg_ini_proc(String seg_ini_proc) {
        this.seg_ini_proc = seg_ini_proc;
    }

    public String getHora_fin_proc() {
        return hora_fin_proc;
    }

    public void setHora_fin_proc(String hora_fin_proc) {
        this.hora_fin_proc = hora_fin_proc;
    }

    public String getMin_fin_proc() {
        return min_fin_proc;
    }

    public void setMin_fin_proc(String min_fin_proc) {
        this.min_fin_proc = min_fin_proc;
    }

    public String getSeg_fin_proc() {
        return seg_fin_proc;
    }

    public void setSeg_fin_proc(String seg_fin_proc) {
        this.seg_fin_proc = seg_fin_proc;
    }

    public String getPiezas() {
        return piezas;
    }

    public void setPiezas(String piezas) {
        this.piezas = piezas;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getDia() {
        return dia;
    }

    public void setDia(String dia) {
        this.dia = dia;
    }

    public String getMes() {
        return mes;
    }

    public void setMes(String mes) {
        this.mes = mes;
    }

    public String getAño() {
        return año;
    }

    public void setAño(String año) {
        this.año = año;
    }

    public List<ProccesBean> getListprocces() {
        return listprocces;
    }

    public void setListprocces(List<ProccesBean> listprocces) {
        this.listprocces = listprocces;
    }

    public List<ProccesBean> getListhistprocces() {
        return listhistprocces;
    }

    public void setListhistprocces(List<ProccesBean> listhistprocces) {
        this.listhistprocces = listhistprocces;
    }
    
   
    
    
    public void consultProcces(AjaxBehaviorEvent event) throws ClassNotFoundException {
        try {
            listprocces = new GetProccesValidation().getListProcces();
        } catch (InterruptedException ex) {
            Logger.getLogger(ProccesBean.class.getName()).log(Level.SEVERE, null, ex);
        }

        nom = String.valueOf(listprocces.get(0));
        nparte = String.valueOf(listprocces.get(1));
        nomparte = String.valueOf(listprocces.get(2));

        hora_ini_prep = String.valueOf(listprocces.get(3));
        min_ini_prep = String.valueOf(listprocces.get(4));
        seg_ini_prep = String.valueOf(listprocces.get(5));

        hora_fin_prep = String.valueOf(listprocces.get(6));
        min_fin_prep = String.valueOf(listprocces.get(7));
        seg_fin_prep = String.valueOf(listprocces.get(8));

        hora_ini_proc = String.valueOf(listprocces.get(9));
        min_ini_proc = String.valueOf(listprocces.get(10));
        seg_ini_proc = String.valueOf(listprocces.get(11));

        hora_fin_proc = String.valueOf(listprocces.get(12));
        min_fin_proc = String.valueOf(listprocces.get(13));
        seg_fin_proc = String.valueOf(listprocces.get(14));

        piezas = String.valueOf(listprocces.get(15));
        fecha = String.valueOf(listprocces.get(16));
        dia = String.valueOf(listprocces.get(17));

        mes = String.valueOf(listprocces.get(18));
        año = String.valueOf(listprocces.get(19));

    }
    
   public List<ProccesBean> histProcces(AjaxBehaviorEvent event) {
        try {
            try {
                listhistprocces = new GetProccesValidation().ListProccesHist();
            } catch (InterruptedException ex) {
                Logger.getLogger(ProccesBean.class.getName()).log(Level.SEVERE, null, ex);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProccesBean.class.getName()).log(Level.SEVERE, null, ex);
        }
        System.out.println(listhistprocces);
        return listhistprocces;
    }
    
}



