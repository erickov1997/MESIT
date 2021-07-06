/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.reportes;

import com.amats.conn.DBHandler;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import javax.enterprise.context.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.JasperRunManager;
import net.sf.jasperreports.engine.export.JRXlsExporter;
import net.sf.jasperreports.engine.export.ooxml.JRPptxExporter;

/**
 *
 * @author Usuario
 */
@Named("appHist")
@SessionScoped
public class ReportHictoric implements Serializable{
    public void exportarPDF(ActionEvent actionEvent) throws JRException, IOException, ClassNotFoundException {
        Map<String, Object> parametros = new HashMap<String, Object>();
        parametros.put("txtUsuario", "Erick Ortiz");

        JasperReport reporte = null;

        DBHandler handler = new DBHandler();
        handler.getConnection();

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/MesItHistorico.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, handler.conn);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
        ServletOutputStream stream = response.getOutputStream();

        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }

    public void exportarExcel(ActionEvent actionEvent) throws JRException, IOException, ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/MesItHistorico.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, handler.conn);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.xls");
        ServletOutputStream stream = response.getOutputStream();

        JRXlsExporter exporter = new JRXlsExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
//

    public void exportarPPT(ActionEvent actionEvent) throws JRException, IOException, ClassNotFoundException {
        DBHandler handler = new DBHandler();
        handler.getConnection();

        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/MesItHistorico.jasper"));
        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), null, handler.conn);

        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.ppt");
        ServletOutputStream stream = response.getOutputStream();

        JRPptxExporter exporter = new JRPptxExporter();
        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
        exporter.exportReport();

        stream.flush();
        stream.close();
        FacesContext.getCurrentInstance().responseComplete();
    }
//
//    public void exportarDOC(ActionEvent actionEvent) throws JRException, IOException {
//        Map<String, Object> parametros = new HashMap<String, Object>();
//        parametros.put("txtUsuario", "Erick Ortiz");
//
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/report.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.getPersonas()));
//
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.doc");
//        ServletOutputStream stream = response.getOutputStream();
//
//        JRDocxExporter exporter = new JRDocxExporter();
//        exporter.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
//        exporter.setParameter(JRExporterParameter.OUTPUT_STREAM, stream);
//        exporter.exportReport();
//
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }
//    

    public void verPDF(ActionEvent actionEvent) throws Exception {
        DBHandler handler = new DBHandler();
        handler.getConnection();
        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/MesItHistorico.jasper"));

        byte[] bytes = JasperRunManager.runReportToPdf(jasper.getPath(), null, handler.conn);
        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
        response.setContentType("application/pdf");
        response.setContentLength(bytes.length);
        ServletOutputStream outStream = response.getOutputStream();
        outStream.write(bytes, 0, bytes.length);
        outStream.flush();
        outStream.close();

        FacesContext.getCurrentInstance().responseComplete();
    }
}
