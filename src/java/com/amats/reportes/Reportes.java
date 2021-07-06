/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.amats.reportes;

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
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;

/**
 *
 * @author Usuario
 */
@Named("appRepores")
@SessionScoped
public class Reportes implements Serializable {
//     public void exportarPDF(ActionEvent actionEvent) throws IOException, JRException  {
//        Map<String, Object> parametros = new HashMap<String, Object>();
//        parametros.put("txtUsuario", "Erick Ortiz");
//
//        File jasper = new File(FacesContext.getCurrentInstance().getExternalContext().getRealPath("/reportes/MesItActual.jasper"));
//        JasperPrint jasperPrint = JasperFillManager.fillReport(jasper.getPath(), parametros, new JRBeanCollectionDataSource(this.getPersonas()));
//
//        HttpServletResponse response = (HttpServletResponse) FacesContext.getCurrentInstance().getExternalContext().getResponse();
//        response.addHeader("Content-disposition", "attachment; filename=jsfReporte.pdf");
//        ServletOutputStream stream = response.getOutputStream();
//
//        JasperExportManager.exportReportToPdfStream(jasperPrint, stream);
//
//        stream.flush();
//        stream.close();
//        FacesContext.getCurrentInstance().responseComplete();
//    }

    
}
