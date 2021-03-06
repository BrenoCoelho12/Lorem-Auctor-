/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.apresentacao;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import static tcc.apresentacao.TabeladeMoto.colunas;
import tcc.dao.ProdutosDao;
import tcc.dominio.Produtos;
import tcc.negocio.ProdutosController;
import util.Utilidades;

/**
 *
 * @author Breno-
 */
public class AtualizarEstoqueBike extends javax.swing.JInternalFrame {

   static String[] colunas = {"Id", "NomeProduto", "Estoque", "Marca", "Preço de Atacado", "Preço de Varejo"};
    ProdutosController ProdutosController = new ProdutosController();
    public AtualizarEstoqueBike() {
        initComponents();
        listarProdutos();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane3 = new javax.swing.JScrollPane();
        TabelaProdutosBike = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        quantidade = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        buscaProduto = new javax.swing.JTextField();
        jButton6 = new javax.swing.JButton();

        setClosable(true);

        TabelaProdutosBike.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TabelaProdutosBike.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        TabelaProdutosBike.setRowHeight(35);
        TabelaProdutosBike.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProdutosBikeMouseClicked(evt);
            }
        });
        TabelaProdutosBike.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaProdutosBikeKeyReleased(evt);
            }
        });
        jScrollPane3.setViewportView(TabelaProdutosBike);

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Quantidade Atual:");

        quantidade.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        quantidade.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                quantidadeKeyTyped(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/13.png"))); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel17.setForeground(new java.awt.Color(0, 0, 102));
        jLabel17.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/a2.png"))); // NOI18N
        jLabel17.setText("Pesquisar");

        buscaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscaProdutoKeyPressed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton6.setText("Pesquisar");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 767, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 121, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(27, 27, 27)
                        .addComponent(jButton1))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                        .addComponent(jButton6)
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(jLabel17)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(buscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 272, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(buscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane3, javax.swing.GroupLayout.DEFAULT_SIZE, 389, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(quantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(38, 38, 38))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void buscaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaProdutoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscaProduto.setText(buscaProduto.getText().toUpperCase().trim());
            Utilidades.buscarProdutosMoto2(buscaProduto.getText().toUpperCase().trim(), colunas, TabelaProdutosBike);
        }
    }//GEN-LAST:event_buscaProdutoKeyPressed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        buscaProduto.setText(buscaProduto.getText().toUpperCase());
        Utilidades.buscarProdutosMoto2(buscaProduto.getText().toUpperCase().trim(), colunas, TabelaProdutosBike);
    }//GEN-LAST:event_jButton6ActionPerformed

    private void TabelaProdutosBikeKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaProdutosBikeKeyReleased
        quantidadeEstoqueProduto();
    }//GEN-LAST:event_TabelaProdutosBikeKeyReleased

    private void TabelaProdutosBikeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProdutosBikeMouseClicked
        quantidadeEstoqueProduto();
    }//GEN-LAST:event_TabelaProdutosBikeMouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(TabelaProdutosBike.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Selecione um produto.");
        }
        
        int produtoSelecionado = TabelaProdutosBike.getSelectedRow();
        
        int idProduto = (Integer) TabelaProdutosBike.getValueAt(produtoSelecionado, 0);
        int qtdEstoque = Integer.parseInt(quantidade.getText().trim());
        Produtos p = new Produtos();
        p.setIdProduto(idProduto);
        p.setQuantidadeEstoque(qtdEstoque);
        ProdutosDao pdao = new ProdutosDao();
       try {
           pdao.atualizarEstoque(p);
           JOptionPane.showMessageDialog(null, "Estoque atualizado com sucesso!");
           listarProdutos();
       } catch (SQLException ex) {
           JOptionPane.showMessageDialog(null, "Não foi possível atualizar o estoque! Entre em contato com  o desenvolvedor.");
           Logger.getLogger(AtualizarEstoqueBike.class.getName()).log(Level.SEVERE, null, ex);
       }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void quantidadeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_quantidadeKeyTyped
        String caracteres = "0123456789";
        if(!caracteres.contains(evt.getKeyChar()+"")){
         evt.consume();
        }
    }//GEN-LAST:event_quantidadeKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTable TabelaProdutosBike;
    public static javax.swing.JTextField buscaProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JTextField quantidade;
    // End of variables declaration//GEN-END:variables
    private void listarProdutos() {
        try {
            List<Produtos> listaProdutos = ProdutosController.listarProdutosbike();
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            for (Produtos y : listaProdutos) {
                model.addRow(new Object[] {
                     y.getIdProduto(),
                    y.getNomeProduto(),
                    y.getQuantidadeEstoque(),
                    y.getMarca(),
                    y.getPrecoRevenda(),
                    y.getPrecoVarejo()
                });
            }
           TabelaProdutosBike.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar os Produtos!");
        }
        Utilidades.larguraColunasTabelas(TabelaProdutosBike);
    }
    
    private void quantidadeEstoqueProduto(){
        int produtoSelecionado = TabelaProdutosBike.getSelectedRow();
        String qtdEstoque = TabelaProdutosBike.getValueAt(produtoSelecionado, 2).toString();
        String nomeProduto = TabelaProdutosBike.getValueAt(produtoSelecionado, 1).toString();
        quantidade.setText(qtdEstoque);
        buscaProduto.setText(nomeProduto);
}
}


