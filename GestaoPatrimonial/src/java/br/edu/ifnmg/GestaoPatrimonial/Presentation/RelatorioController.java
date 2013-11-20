/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifnmg.GestaoPatrimonial.Presentation;

import java.awt.event.ActionEvent;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Named;
import javax.enterprise.context.Dependent;
import javax.faces.context.FacesContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRDataSource;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JRExporterParameter;
import net.sf.jasperreports.engine.JRResultSetDataSource;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.export.JRXlsExporter;

/**
 *
 * @author veronica
 */
@Named(value = "relatorioController")
@Dependent
public class RelatorioController {

    /**
     * Creates a new instance of RelatorioController
     */
    public RelatorioController() {
    }
    
    public void PDF(ActionEvent actionEvent) throws JRException, IOException {
        Connection conn;
        String arquivo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/relatorios/ConsolidacaoInventario.jasper");
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GestaoPatrimonial","root","root");
            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("select C.CONTA, C.DESCRICAO,  SUM (B.VALOR) valor, SUM (B.QUANTIDADE) quantidade\n" +
"FROM CONTAPATRIMONIAL C JOIN BEMPATRIMONIAL B\n" +
"ON B.CONTA_ID = C.ID\n" +
"GROUP BY C.CONTA,C.DESCRICAO");
            JRDataSource ds = new JRResultSetDataSource(rs);
            JasperPrint jasperPrint = JasperFillManager.fillReport(arquivo, null, ds);
 
 
        HttpServletResponse httpServletResponse = (HttpServletResponse)     FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=report.pdf");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        FacesContext.getCurrentInstance().responseComplete();
 
            
            
        } catch (JRException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void XLS(ActionEvent actionEvent) throws JRException, IOException {
        Connection conn;
        String arquivo = FacesContext.getCurrentInstance().getExternalContext().getRealPath("/relatorios/ConsolidacaoInventario.jasper");
        try {
            
            Class.forName("org.apache.derby.jdbc.ClientDriver");
            conn = DriverManager.getConnection("jdbc:derby://localhost:1527/GestaoPatrimonial","root","root");
            Statement sql = conn.createStatement();
            ResultSet rs = sql.executeQuery("select C.CONTA, C.DESCRICAO,  SUM (B.VALOR) valor, SUM (B.QUANTIDADE) quantidade\n" +
"FROM CONTAPATRIMONIAL C JOIN BEMPATRIMONIAL B\n" +
"ON B.CONTA_ID = C.ID\n" +
"GROUP BY C.CONTA,C.DESCRICAO");
            JRDataSource ds = new JRResultSetDataSource(rs);
            JasperPrint jasperPrint = JasperFillManager.fillReport(arquivo, null, ds);
 
 
        HttpServletResponse httpServletResponse = (HttpServletResponse)     FacesContext.getCurrentInstance().getExternalContext().getResponse();
        httpServletResponse.addHeader("Content-disposition", "attachment; filename=ConsolidacaoInventario.xls");
        ServletOutputStream servletOutputStream = httpServletResponse.getOutputStream();
        //JasperExportManager.exportReportToPdfStream(jasperPrint, servletOutputStream);
        JRXlsExporter xls = new JRXlsExporter();
        xls.setParameter(JRExporterParameter.JASPER_PRINT, jasperPrint);
        xls.setParameter(JRExporterParameter.OUTPUT_STREAM, servletOutputStream);
        xls.exportReport();
        FacesContext.getCurrentInstance().responseComplete();
 
            
            
        } catch (JRException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
