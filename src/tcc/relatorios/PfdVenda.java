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
import tcc.dao.ProdutosDao;
import tcc.dominio.Produtos;
import tcc.dominio.Venda;

/**
 *
 * @author Breno-
 */
public class PfdVenda {
    
       
    private static ProdutosDao ProdutoDao = new ProdutosDao();
    private static String pastaRelatorio = "relatorios/";
    private static String extensaoJRXML = ".jrxml";
    private static String extensaoPDF = ".pdf";
            
    public static void gerarRelatorio(Venda venda, String nomeRelatorio) throws SQLException, JRException, FileNotFoundException {
        System.out.println("Gerando relatório...");
        
        Map parameters = new HashMap();
        parameters.put("nome_cliente",      venda.getClienteFisico().getNome());
        parameters.put("endereco_cliente",  venda.getClienteFisico().getEndereco());
        parameters.put("cidade_cliente",    venda.getClienteFisico().getCidade());
        parameters.put("estado_cliente",    venda.getClienteFisico().getEstado());
        parameters.put("t_celular",         venda.getClienteFisico().getT_celular());
        parameters.put("t_residencial",     venda.getClienteFisico().getT_residencial());
        parameters.put("cpf",               venda.getClienteFisico().getCpf());
        parameters.put("rginscricao",       venda.getClienteFisico().getRginscricao());
        parameters.put("email",             venda.getClienteFisico().getEmail());
        parameters.put("qtd_volume",        venda.getQtdVolume());
        parameters.put("totalCompra",       venda.getTotalCompra());
        parameters.put("total",             venda.getTotal());
        parameters.put("acrescimos",        venda.getAcrescimos());
        parameters.put("observacoes",       venda.getObservacoes());
        
        JasperReport report = JasperCompileManager.compileReport(PfdVenda.class.getClassLoader().getResourceAsStream("jrxml/RelatorioVenda.jrxml"));
        
        JasperPrint print = JasperFillManager.fillReport(report, parameters, new JRBeanCollectionDataSource(venda.getItensProduto()));
        
        JasperExportManager.exportReportToPdfFile(print, pastaRelatorio + venda.getClienteFisico().getNome() + extensaoPDF);
        
        abrirJanelaComPDF(pastaRelatorio + venda.getClienteFisico().getNome() + extensaoPDF);
        
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
