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
import tcc.dao.MovimentoDiarioDao;
import tcc.dominio.MovimentoDiario;

/**
 *
 * @author Breno-
 */
public class RelatorioDasVendasVarejoPorData {
    
        private static MovimentoDiarioDao MovimentacaoDao = new MovimentoDiarioDao();
    private static String pastaRelatorio = "relatorios/";
    private static String extensaoJRXML = ".jrxml";
    private static String extensaoPDF = ".pdf";
            
    public static void gerarRelatorio(String nomeRelatorio, String dataInicio, String dataFim) throws SQLException, JRException, FileNotFoundException {
        System.out.println("Gerando relatório...");
       
        List<MovimentoDiario> listaMovimentacao = MovimentacaoDao.listarMovimentacaoVarejoPorData(dataInicio, dataFim);
        
        Map parameters = new HashMap();
   
        JasperReport report = JasperCompileManager.compileReport(RelatorioDasVendasVarejoPorData.class.getClassLoader().getResourceAsStream("jrxml/RelatorioMovimentacaoDiaria.jrxml"));
        //PfdVenda.class.getResourceAsStream("tcc/jrxml/RelatorioMovimentacaoDiaria"
        
        JasperPrint print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(listaMovimentacao));
        
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
