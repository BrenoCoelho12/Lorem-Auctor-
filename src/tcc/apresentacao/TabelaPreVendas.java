/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.apresentacao;

import com.sun.glass.events.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static tcc.apresentacao.ExecutarVenda.tabelaVendas;
import tcc.dao.PreVendaDao;
import tcc.dao.ProdutosPreVendaDao;
import tcc.dominio.PreVenda;
import tcc.dominio.ProdutosPreVenda;

/**
 *
 * @author Breno-
 */
public class TabelaPreVendas extends javax.swing.JInternalFrame {

    String[] colunas = {"Cod.Pré-Venda", "Cliente", "Data do arquivamento", "Valor atual da venda"};
    String[] colunasVenda = {"Cod.", "Produto", "Valore Revenda", "Quantidade", "Subtotal", "Unidade"};
    public TabelaPreVendas() {
        initComponents();
        listaPreVendas();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPreVendas = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));
        setClosable(true);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        tabelaPreVendas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabelaPreVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        tabelaPreVendas.setRowHeight(28);
        tabelaPreVendas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tabelaPreVendasMouseClicked(evt);
            }
        });
        tabelaPreVendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaPreVendasKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                tabelaPreVendasKeyReleased(evt);
            }
        });
        jScrollPane2.setViewportView(tabelaPreVendas);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 710, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(63, 63, 63))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 387, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tabelaPreVendasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaPreVendasKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            adicionarPreVenda();
        }
    }//GEN-LAST:event_tabelaPreVendasKeyPressed

    private void tabelaPreVendasKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaPreVendasKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_tabelaPreVendasKeyReleased

    private void tabelaPreVendasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tabelaPreVendasMouseClicked
        if(evt.getClickCount() == 2){
            adicionarPreVenda();
        }
    }//GEN-LAST:event_tabelaPreVendasMouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable tabelaPreVendas;
    // End of variables declaration//GEN-END:variables

    private void listaPreVendas() {
           
        try {
            PreVendaDao vdao = new PreVendaDao();
            List<PreVenda> venda = vdao.listarVendas();
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            for (PreVenda y : venda) {
                model.addRow(new Object[] {
                    y.getIdPreVenda(),
                    y.getIdCliente().getNome(),
                    y.getDataPreVenda(),
                    y.getValorAtual()
                  });
            }
           tabelaPreVendas.setModel(model);
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar as Vendas!");
        }
        
       tabelaPreVendas.setDefaultEditor(Object.class, null);
          }

    private void abrirInformacoesPreVenda(int idPreVenda) {
           
        try {
            ProdutosPreVendaDao ppvdao = new ProdutosPreVendaDao();
            List<ProdutosPreVenda> venda = ppvdao.ItensPreVenda(idPreVenda);
            DefaultTableModel model = new DefaultTableModel(colunasVenda, 0);
            for (ProdutosPreVenda y : venda) {
                model.addRow(new Object[] {
                    y.getProduto().getIdProduto(),
                    y.getProduto().getNomeProduto(),
                    y.getValorRevenda(),
                    y.getQuantidade(),
                    0,
                    y.getProduto().getUnidade()
                  });
            }
           tabelaVendas.setModel(model);
           
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar as Vendas!");
        }
       tabelaVendas.getColumnModel().getColumn(0).setPreferredWidth(5);
       tabelaVendas.getColumnModel().getColumn(1).setPreferredWidth(320);
       tabelaVendas.getColumnModel().getColumn(2).setPreferredWidth(15);
       tabelaVendas.getColumnModel().getColumn(3).setPreferredWidth(15);
       tabelaVendas.getColumnModel().getColumn(4).setPreferredWidth(15);
       tabelaVendas.getColumnModel().getColumn(5).setPreferredWidth(15);
       tabelaVendas.setDefaultEditor(Object.class, null);
          }
    
    private void adicionarPreVenda() {
        
                if(tabelaPreVendas.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Selecione uma venda!");
            return;
        }
        
        int preVendaSelecionada = tabelaPreVendas.getSelectedRow();
        
        int idPVenda = (Integer) tabelaPreVendas.getValueAt(preVendaSelecionada, 0);
        String cliente = tabelaPreVendas.getValueAt(preVendaSelecionada, 1).toString();
        BigDecimal valorAtualPreVenda = new BigDecimal (tabelaPreVendas.getValueAt(preVendaSelecionada, 3).toString());
        abrirInformacoesPreVenda(idPVenda);
        ExecutarVenda.calculaValoresProdutoTabela();
        ExecutarVenda.receberIdPreVenda(idPVenda, cliente, valorAtualPreVenda);
       
        this.dispose();

    }
}

