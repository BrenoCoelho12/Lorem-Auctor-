/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.relatorios;

import java.awt.Desktop;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.data.JRBeanCollectionDataSource;
import tcc.dao.ParcelaDao;
import tcc.dominio.Parcelas;

/**
 *
 * @author Breno-
 */
public class GeracaoCarnê {
     private static ParcelaDao parcelaDao = new ParcelaDao();
    private static String pastaRelatorio = "relatorios/";
    private static String extensaoJRXML = ".jrxml";
    private static String extensaoPDF = ".pdf";
            
    public static void gerarRelatorio(String nomeRelatorio, int idVenda) throws SQLException, JRException, FileNotFoundException {
        System.out.println("Gerando relatório...");
       
        List<Parcelas> listaParcelas = parcelaDao.listarParcelas(idVenda);
        
        Map parameters = new HashMap();
   
        JasperReport report = JasperCompileManager.compileReport(GeracaoCarnê.class.getClassLoader().getResourceAsStream("jrxml/GeracaoCarne.jrxml"));
        
        JasperPrint print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(listaParcelas));
        
        JasperExportManager.exportReportToPdfFile(print, pastaRelatorio + nomeRelatorio + extensaoPDF);
        
        abrirJanelaComPDF(pastaRelatorio + nomeRelatorio + extensaoPDF);
        
        System.out.println("Relatório gerado.");
    }
   
    
    /**
    * @param arquivoDestino 
     */
    private static void abrirJanelaComPDF(String arquivoDestino) {
        if (Desktop.isDesktopSupported()) {
            try {
                File arquivoPDF = new File(arquivoDestino);
                Desktop.getDesktop().open(arquivoPDF);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }
    }
   
}
