/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.grafica;

import com.amats.segmentos.Colores;
import com.amats.segmentos.ColoresValidations;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.scene.chart.Axis;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;
import javax.inject.Named;
import org.primefaces.model.chart.AxisType;
import org.primefaces.model.chart.BarChartModel;
import org.primefaces.model.chart.ChartSeries;

/**
 *
 * @author Usuario
 */
@Named("appGrafica")
@SessionScoped
public class GraficaSegmentos implements Serializable {

    private BarChartModel barModelSl;
    private BarChartModel barModelS2;
    private BarChartModel barModelS3;
    private BarChartModel barModelS4;
    private BarChartModel barModelS5;
    private BarChartModel barModelBuzzer;

    private List<Colores> getsegoffon;

    List<String> coloresl = new ArrayList<String>() {
        {
            add("Verde");
            add("Rojo");
            add("Azul");
            add("Blinking");
            add("Flashing");
        }
    };

    List<String> bufferl = new ArrayList<String>() {
        {
            add("Off");
            add("1Hz");
            add("5hz");
        }
    };

    public GraficaSegmentos() {

//        createBarModels();
    }

//    @PostConstruct
//    public void init() {
//       createBarModels();
//    }
    public BarChartModel getBarModelSl() {
        return barModelSl;
    }

    public void setBarModelSl(BarChartModel barModelSl) {
        this.barModelSl = barModelSl;
    }

    public BarChartModel getBarModelS2() {
        return barModelS2;
    }

    public void setBarModelS2(BarChartModel barModelS2) {
        this.barModelS2 = barModelS2;
    }

    public BarChartModel getBarModelS3() {
        return barModelS3;
    }

    public void setBarModelS3(BarChartModel barModelS3) {
        this.barModelS3 = barModelS3;
    }

    public BarChartModel getBarModelS4() {
        return barModelS4;
    }

    public void setBarModelS4(BarChartModel barModelS4) {
        this.barModelS4 = barModelS4;
    }

    public BarChartModel getBarModelS5() {
        return barModelS5;
    }

    public void setBarModelS5(BarChartModel barModelS5) {
        this.barModelS5 = barModelS5;
    }

    public BarChartModel getBarModelBuzzer() {
        return barModelBuzzer;
    }

    public void setBarModelBuzzer(BarChartModel barModelBuzzer) {
        this.barModelBuzzer = barModelBuzzer;
    }

    private void createBarModels() {

    }

    public void createBarModelS1(AjaxBehaviorEvent event) {
        createBarModelSeg1();

    }

    public void createBarModelS2(AjaxBehaviorEvent event) {
        createBarModelSeg2();

    }

    public void createBarModelS3(AjaxBehaviorEvent event) {
        createBarModelSeg3();

    }

    public void createBarModelS4(AjaxBehaviorEvent event) {
        createBarModelSeg4();

    }

    public void createBarModelS5(AjaxBehaviorEvent event) {
        createBarModelSeg5();

    }

    public void createBarModelBuzz(AjaxBehaviorEvent event) {
        createBarModelBuzzer();

    }

    private void createBarModelSeg1() {
        barModelSl = initBarModelSeg1();
        barModelSl.setTitle("Segmento 1");
        barModelSl.setLegendPosition("ne");

        org.primefaces.model.chart.Axis xAxis = barModelSl.getAxis(AxisType.X);
        xAxis.setLabel("Variables");

        org.primefaces.model.chart.Axis yAxis = barModelSl.getAxis(AxisType.Y);
        yAxis.setLabel("No. veces accionado");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private BarChartModel initBarModelSeg1() {
        List<Number> on = null;
        List<Number> off = null;

        try {
            on = new ColoresValidations().GetSegmentosOffOn("onhistorico_segmentos", "btns1verde", "btns1rojo", "btns1azul", "btns1blink", "btns1flashing");
            off = new ColoresValidations().GetSegmentosOffOn("offhistorico_segmentos", "offbtns1verde", "offbtns1rojo", "offbtns1azul", "offbtns1blink", "offbtns1flashing");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GraficaSegmentos.class.getName()).log(Level.SEVERE, null, ex);
        }

        BarChartModel model = new BarChartModel();
        ChartSeries onsg1 = new ChartSeries();

        onsg1.setLabel("On");

        for (int i = 0; i < on.size(); i++) {
            onsg1.set(coloresl.get(i), (Number) on.get(i));
        }

        ChartSeries offsg1 = new ChartSeries();
        offsg1.setLabel("Off");
        for (int i = 0; i < coloresl.size(); i++) {
            offsg1.set(coloresl.get(i), (Number) off.get(i));
        }

        model.addSeries(onsg1);
        model.addSeries(offsg1);

        return model;
    }

    ///////////////////////
    private void createBarModelSeg2() {
        barModelS2 = initBarModelSeg2();
        barModelS2.setTitle("Segmento 2");
        barModelS2.setLegendPosition("ne");

        org.primefaces.model.chart.Axis xAxis = barModelS2.getAxis(AxisType.X);
        xAxis.setLabel("Variables");

        org.primefaces.model.chart.Axis yAxis = barModelS2.getAxis(AxisType.Y);
        yAxis.setLabel("No. veces accionado");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private BarChartModel initBarModelSeg2() {

        List<Number> on = null;
        List<Number> off = null;

        try {
            on = new ColoresValidations().GetSegmentosOffOn("onhistorico_segmentos", "btns2verde", "btns2rojo", "btns2azul", "btns2blink", "btns2flashing");
            off = new ColoresValidations().GetSegmentosOffOn("offhistorico_segmentos", "offbtns2verde", "offbtns2rojo", "offbtns2azul", "offbtns2blink", "offbtns2flashing");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GraficaSegmentos.class.getName()).log(Level.SEVERE, null, ex);
        }

        BarChartModel model = new BarChartModel();
        ChartSeries onsg2 = new ChartSeries();

        onsg2.setLabel("On");

        for (int i = 0; i < coloresl.size(); i++) {
            onsg2.set(coloresl.get(i), on.get(i));
        }

        ChartSeries offsg2 = new ChartSeries();
        offsg2.setLabel("Off");
        for (int i = 0; i < coloresl.size(); i++) {
            offsg2.set(coloresl.get(i), off.get(i));
        }

        model.addSeries(onsg2);
        model.addSeries(offsg2);

        return model;
    }

    /////////
    private void createBarModelSeg3() {
        barModelS3 = initBarModelSeg3();

        barModelS3.setTitle("Segmento 3");
        barModelS3.setLegendPosition("ne");

        org.primefaces.model.chart.Axis xAxis = barModelS3.getAxis(AxisType.X);
        xAxis.setLabel("Variables");

        org.primefaces.model.chart.Axis yAxis = barModelS3.getAxis(AxisType.Y);
        yAxis.setLabel("No. veces accionado");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private BarChartModel initBarModelSeg3() {

        List<Number> on = null;
        List<Number> off = null;

        try {
            on = new ColoresValidations().GetSegmentosOffOn("onhistorico_segmentos", "btns3verde", "btns3rojo", "btns3azul", "btns3blink", "btns3flashing");
            off = new ColoresValidations().GetSegmentosOffOn("offhistorico_segmentos", "offbtns3verde", "offbtns3rojo", "offbtns3azul", "offbtns3blink", "offbtns3flashing");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GraficaSegmentos.class.getName()).log(Level.SEVERE, null, ex);
        }

        BarChartModel model = new BarChartModel();
        ChartSeries onsg3 = new ChartSeries();

        onsg3.setLabel("On");

        for (int i = 0; i < coloresl.size(); i++) {
            onsg3.set(coloresl.get(i), on.get(i));
        }

        ChartSeries offsg3 = new ChartSeries();
        offsg3.setLabel("Off");
        for (int i = 0; i < coloresl.size(); i++) {
            offsg3.set(coloresl.get(i), off.get(i));
        }

        model.addSeries(onsg3);
        model.addSeries(offsg3);

        return model;
    }

    /////segmento 4////
    private void createBarModelSeg4() {
        barModelS4 = initBarModelSeg4();

        barModelS4.setTitle("Segmento 4");
        barModelS4.setLegendPosition("ne");

        org.primefaces.model.chart.Axis xAxis = barModelS4.getAxis(AxisType.X);
        xAxis.setLabel("Variables");

        org.primefaces.model.chart.Axis yAxis = barModelS4.getAxis(AxisType.Y);
        yAxis.setLabel("No. veces accionado");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private BarChartModel initBarModelSeg4() {

        List<Number> on = null;
        List<Number> off = null;

        try {
            on = new ColoresValidations().GetSegmentosOffOn("onhistorico_segmentos", "btns4verde", "btns4rojo", "btns4azul", "btns4blink", "btns4flashing");
            off = new ColoresValidations().GetSegmentosOffOn("offhistorico_segmentos", "offbtns4verde", "offbtns4rojo", "offbtns4azul", "offbtns4blink", "offbtns4flashing");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GraficaSegmentos.class.getName()).log(Level.SEVERE, null, ex);
        }

        BarChartModel model = new BarChartModel();
        ChartSeries onseg4 = new ChartSeries();

        onseg4.setLabel("On");

        for (int i = 0; i < coloresl.size(); i++) {
            onseg4.set(coloresl.get(i), on.get(i));
        }

        ChartSeries offseg4 = new ChartSeries();
        offseg4.setLabel("Off");
        for (int i = 0; i < coloresl.size(); i++) {
            offseg4.set(coloresl.get(i), off.get(i));
        }

        model.addSeries(onseg4);
        model.addSeries(offseg4);

        return model;
    }

    /////segmento 5////
    private void createBarModelSeg5() {
        barModelS5 = initBarModelSeg5();

        barModelS5.setTitle("Segmento 5");
        barModelS5.setLegendPosition("ne");

        org.primefaces.model.chart.Axis xAxis = barModelS5.getAxis(AxisType.X);
        xAxis.setLabel("Variables");

        org.primefaces.model.chart.Axis yAxis = barModelS5.getAxis(AxisType.Y);
        yAxis.setLabel("No. veces accionado");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private BarChartModel initBarModelSeg5() {

        List<Number> on = null;
        List<Number> off = null;

        try {
            on = new ColoresValidations().GetSegmentosOffOn("onhistorico_segmentos", "btns5verde", "btns5rojo", "btns5azul", "btns5blink", "btns5flashing");
            off = new ColoresValidations().GetSegmentosOffOn("offhistorico_segmentos", "offbtns5verde", "offbtns5rojo", "offbtns5azul", "offbtns5blink", "offbtns5flashing");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GraficaSegmentos.class.getName()).log(Level.SEVERE, null, ex);
        }

        BarChartModel model = new BarChartModel();
        ChartSeries onseg5 = new ChartSeries();

        onseg5.setLabel("On");

        for (int i = 0; i < coloresl.size(); i++) {
            onseg5.set(coloresl.get(i), on.get(i));
        }

        ChartSeries offseg5 = new ChartSeries();
        offseg5.setLabel("Off");
        for (int i = 0; i < coloresl.size(); i++) {
            offseg5.set(coloresl.get(i), off.get(i));
        }

        model.addSeries(onseg5);
        model.addSeries(offseg5);

        return model;
    }
//Buferrz

    private void createBarModelBuzzer() {
        barModelBuzzer = initBarModelBuzzer();

        barModelBuzzer.setTitle("Buzzer");
        barModelBuzzer.setLegendPosition("ne");

        org.primefaces.model.chart.Axis xAxis = barModelBuzzer.getAxis(AxisType.X);
        xAxis.setLabel("Variables");

        org.primefaces.model.chart.Axis yAxis = barModelBuzzer.getAxis(AxisType.Y);
        yAxis.setLabel("No. veces accionado");
        yAxis.setMin(0);
        yAxis.setMax(100);
    }

    private BarChartModel initBarModelBuzzer() {

        List<Number> on = null;
        List<Number> off = null;

        try {
            on = new ColoresValidations().GetBuffOffOn("onhistorico_segmentos", "btnbuzzer", "btnbuf1hz", "btnbuf5hz");
            off = new ColoresValidations().GetBuffOffOn("offhistorico_segmentos", "offbtnbuzzer", "offbtnbuf1hz", "offbtnbuf5hz");

        } catch (ClassNotFoundException ex) {
            Logger.getLogger(GraficaSegmentos.class.getName()).log(Level.SEVERE, null, ex);
        }

        BarChartModel model = new BarChartModel();
        ChartSeries onbuzzer = new ChartSeries();

        onbuzzer.setLabel("On");

        for (int i = 0; i < bufferl.size(); i++) {
            onbuzzer.set(bufferl.get(i), on.get(i));
        }

        ChartSeries offbuzzer = new ChartSeries();
        offbuzzer.setLabel("Off");
        for (int i = 0; i < bufferl.size(); i++) {
            offbuzzer.set(bufferl.get(i), off.get(i));
        }

        model.addSeries(onbuzzer);
        model.addSeries(offbuzzer);

        return model;
    }

}
