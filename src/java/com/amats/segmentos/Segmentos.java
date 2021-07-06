/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.segmentos;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.SessionScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;

/**
 *
 * @author Usuario
 */
@Named("appSegmentos")
@SessionScoped
public class Segmentos implements Serializable {

    private int set;
    private int rest1;
    private int rest2;

    private int s1verde;
    private int s1rojo;
    private int s1azul;

    private int s2verde;
    private int s2rojo;
    private int s2azul;

    private int s3verde;
    private int s3rojo;
    private int s3azul;

    private int s4verde;
    private int s4rojo;
    private int s4azul;

    private int s5verde;
    private int s5rojo;
    private int s5azul;

    private int offbuffer;
    private int hz1buff;
    private int hz5buff;

    private int nclick = 0;

    public Segmentos() throws ClassNotFoundException {
//        new SegmentosValidations().SET("buzzer", "0", "1");
//        new SegmentosValidations().SET("buf1hz", "0", "1");
//        new SegmentosValidations().SET("buf5hz", "0", "1");
//        new jobSend().onjob();
    }

    public int getNclick() {
        return nclick;
    }

    public void setNclick(int nclick) {
        this.nclick = nclick;
    }

    public int getSet() {
        return set;
    }

    public void setSet(int set) {
        this.set = set;
    }

    public int getRest1() {
        return rest1;
    }

    public void setRest1(int rest1) {
        this.rest1 = rest1;
    }

    public int getRest2() {
        return rest2;
    }

    public void setRest2(int rest2) {
        this.rest2 = rest2;
    }

    public int getS1verde() {
        return s1verde;
    }

    public void setS1verde(int s1verde) {
        this.s1verde = s1verde;
    }

    public int getS1rojo() {
        return s1rojo;
    }

    public void setS1rojo(int s1rojo) {
        this.s1rojo = s1rojo;
    }

    public int getS1azul() {
        return s1azul;
    }

    public void setS1azul(int s1azul) {
        this.s1azul = s1azul;
    }

    public int getS2verde() {
        return s2verde;
    }

    public void setS2verde(int s2verde) {
        this.s2verde = s2verde;
    }

    public int getS2rojo() {
        return s2rojo;
    }

    public void setS2rojo(int s2rojo) {
        this.s2rojo = s2rojo;
    }

    public int getS2azul() {
        return s2azul;
    }

    public void setS2azul(int s2azul) {
        this.s2azul = s2azul;
    }

    public int getS3verde() {
        return s3verde;
    }

    public void setS3verde(int s3verde) {
        this.s3verde = s3verde;
    }

    public int getS3rojo() {
        return s3rojo;
    }

    public void setS3rojo(int s3rojo) {
        this.s3rojo = s3rojo;
    }

    public int getS3azul() {
        return s3azul;
    }

    public void setS3azul(int s3azul) {
        this.s3azul = s3azul;
    }

    public int getS4verde() {
        return s4verde;
    }

    public void setS4verde(int s4verde) {
        this.s4verde = s4verde;
    }

    public int getS4rojo() {
        return s4rojo;
    }

    public void setS4rojo(int s4rojo) {
        this.s4rojo = s4rojo;
    }

    public int getS4azul() {
        return s4azul;
    }

    public void setS4azul(int s4azul) {
        this.s4azul = s4azul;
    }

    public int getS5verde() {
        return s5verde;
    }

    public void setS5verde(int s5verde) {
        this.s5verde = s5verde;
    }

    public int getS5rojo() {
        return s5rojo;
    }

    public void setS5rojo(int s5rojo) {
        this.s5rojo = s5rojo;
    }

    public int getS5azul() {
        return s5azul;
    }

    public void setS5azul(int s5azul) {
        this.s5azul = s5azul;
    }

    public void onSet(String atributo) {

        if (atributo.equals("set_on")) {
            try {
                new SegmentosValidations().SET(atributo, "1", "0");
                new SegmentosValidations().SET("reset1", "0", "1");
                new SegmentosValidations().SET("reset2", "0", "1");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (atributo.equals("reset1")) {
            try {
                new SegmentosValidations().SET("set_on", "0", "1");
                new SegmentosValidations().SET(atributo, "1", "0");

//                new SegmentosValidations().SET("buf1hz", "1", "0");
//                new SegmentosValidations().SET("buf5hz", "1", "0");
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (atributo.equals("reset2")) {
            try {
                new SegmentosValidations().SET("set_on", "0", "1");
                new SegmentosValidations().SET(atributo, "1", "0");

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    public void coloresSegmentos(String atributo) {

        try {
            String condi = (String) new SegmentosValidations().Consulta(atributo).get(0);
            try {
                if (condi.equals("0")) {
                    new SegmentosValidations().SET("set_on", "1", "0");
                    new SegmentosValidations().SET("reset1", "0", "1");
                    new SegmentosValidations().SET("reset2", "0", "1");

                    nclick = Integer.parseInt((String) new SegmentosValidations().HistSegmentos("onhistorico_segmentos", "btn" + atributo).get(0)) + 1;
                    new SegmentosValidations().UpdateHistSeg("onhistorico_segmentos", "btn" + atributo, String.valueOf(nclick));

//                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "", null);
//                    FacesContext.getCurrentInstance().addMessage(null, fm);
                    new SegmentosValidations().SET(atributo, "1", "0");
                    new jobSend().onjob();
                } else if (condi.equals("1")) {

                    nclick = Integer.parseInt((String) new SegmentosValidations().HistSegmentos("offhistorico_segmentos", "offbtn" + atributo).get(0)) + 1;
                    new SegmentosValidations().UpdateHistSeg("offhistorico_segmentos", "offbtn" + atributo, String.valueOf(nclick));

                    new SegmentosValidations().SET("set_on", "1", "0");
                    new SegmentosValidations().SET("reset1", "0", "1");
                    new SegmentosValidations().SET("set_on", "1", "0");
//                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", null);
//                    FacesContext.getCurrentInstance().addMessage(null, fm);
                    new SegmentosValidations().SET(atributo, "0", "1");
                    new jobSend().onjob();
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public void buffer(String atributo) {
        try {
            String condi = (String) new SegmentosValidations().Consulta(atributo).get(0);
            if (condi.equals("1")) {
//                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "Buffer apagado", null);
//                FacesContext.getCurrentInstance().addMessage(null, fm);

                nclick = Integer.parseInt((String) new SegmentosValidations().HistSegmentos("offhistorico_segmentos", "offbtn" + atributo).get(0)) + 1;
                new SegmentosValidations().UpdateHistSeg("offhistorico_segmentos", "offbtn" + atributo, String.valueOf(nclick));

                new SegmentosValidations().SET(atributo, "0", "1");
                
                new SegmentosValidations().SET("buf1hz", "0", "1");
                new SegmentosValidations().SET("buf5hz", "0", "1");
                new jobSend().onjob();
            } else if (condi.equals("0")) {
                nclick = Integer.parseInt((String) new SegmentosValidations().HistSegmentos("offhistorico_segmentos", "offbtn" + atributo).get(0)) + 1;
                new SegmentosValidations().UpdateHistSeg("offhistorico_segmentos", "offbtn" + atributo, String.valueOf(nclick));
                new SegmentosValidations().SET(atributo, "1", "0");
                
//                 new SegmentosValidations().SET("buf1hz", "0", "1");
//                 new SegmentosValidations().SET("buf5hz", "0", "1");
                
                new jobSend().onjob();
            }

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void bufferhz(String atributo) {
        if (atributo.equals("buf1hz")) {
            try {
                String condi = (String) new SegmentosValidations().Consulta(atributo).get(0);
                if (condi.equals("0")) {
                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, atributo + "  Encendido", null);
                    FacesContext.getCurrentInstance().addMessage(null, fm);

                    nclick = Integer.parseInt((String) new SegmentosValidations().HistSegmentos("onhistorico_segmentos", "btn" + atributo).get(0)) + 1;
                    new SegmentosValidations().UpdateHistSeg("onhistorico_segmentos", "btn" + atributo, String.valueOf(nclick));

                   //new SegmentosValidations().SET("buzzer", "1", "0");
                    new SegmentosValidations().SET(atributo, "1", "0");
                    new SegmentosValidations().SET("buf5hz", "0", "1");
                    new jobSend().onjob();
                } else if (condi.equals("1")) {
//                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, atributo + " fue apagado", null);
//                    FacesContext.getCurrentInstance().addMessage(null, fm);

                    nclick = Integer.parseInt((String) new SegmentosValidations().HistSegmentos("offhistorico_segmentos", "offbtn" + atributo).get(0)) + 1;
                    new SegmentosValidations().UpdateHistSeg("offhistorico_segmentos", "offbtn" + atributo, String.valueOf(nclick));

                    new SegmentosValidations().SET(atributo, "0", "1");
                    new jobSend().onjob();
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        } else if (atributo.equals("buf5hz")) {
            try {
                String condi = (String) new SegmentosValidations().Consulta(atributo).get(0);
                if (condi.equals("0")) {
//                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, atributo + "  Encendido", null);
//                    FacesContext.getCurrentInstance().addMessage(null, fm);

                    nclick = Integer.parseInt((String) new SegmentosValidations().HistSegmentos("onhistorico_segmentos", "btn" + atributo).get(0)) + 1;
                    new SegmentosValidations().UpdateHistSeg("onhistorico_segmentos", "btn" + atributo, String.valueOf(nclick));

//                    new SegmentosValidations().SET("buzzer", "1", "0");
                    new SegmentosValidations().SET(atributo, "1", "0");
                    new SegmentosValidations().SET("buf1hz", "0", "1");
                    new jobSend().onjob();
                } else if (condi.equals("1")) {
//                    FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, atributo + " fue apagado", null);
//                    FacesContext.getCurrentInstance().addMessage(null, fm);

                    nclick = Integer.parseInt((String) new SegmentosValidations().HistSegmentos("offhistorico_segmentos", "offbtn" + atributo).get(0)) + 1;
                    new SegmentosValidations().UpdateHistSeg("offhistorico_segmentos", "offbtn" + atributo, String.valueOf(nclick));
                    new SegmentosValidations().SET(atributo, "0", "1");
                    new jobSend().onjob();
                }

            } catch (ClassNotFoundException ex) {
                Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
            }
        }

    }

    public String onOffColor(String atributo, AjaxBehaviorEvent event) {
        StringBuilder strBuilder = new StringBuilder();
        String condi = null;
        String on = "&#xf205;";
        String off = "&#xf204;";
//            String on="on";
//            String off="off";

        try {
            condi = (String) new SegmentosValidations().Consulta(atributo).get(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (condi.equals("1")) {
//                FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO,"", null);
//                FacesContext.getCurrentInstance().addMessage(null, fm);

            return "on";
        } else {
//                 FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", null);
//                 FacesContext.getCurrentInstance().addMessage(null, fm);
            return "off";
        }

    }

    public String onOffColor2(String atributo) {
        String condi = null;
//            String on="&#xf205;";
//            String off="&#xf204;";
        String on = "on";
        String off = "off";

        try {
            condi = (String) new SegmentosValidations().Consulta2(atributo).get(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (condi.equals("1")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return on;
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
            return off;
        }

    }

    public void onOffColor3(String atributo) {
        String condi = null;
//            String on="&#xf205;";
//            String off="&#xf204;";
        String on = "on";
        String off = "off";

        try {
            condi = (String) new SegmentosValidations().Consulta3(atributo).get(0);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Segmentos.class.getName()).log(Level.SEVERE, null, ex);
        }
        if (condi.equals("&#xf1c1")) {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_INFO, "on", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        } else {
            FacesMessage fm = new FacesMessage(FacesMessage.SEVERITY_ERROR, "off", null);
            FacesContext.getCurrentInstance().addMessage(null, fm);
        }

    }

    public static void main(String[] args) {

    }

}
