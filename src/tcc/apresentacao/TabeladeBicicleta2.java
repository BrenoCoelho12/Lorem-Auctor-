/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.apresentacao;

import java.awt.event.KeyEvent;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import tcc.dominio.Produtos;
import tcc.negocio.ProdutosController;
import util.Utilidades;

public class TabeladeBicicleta2 extends javax.swing.JInternalFrame {

    ProdutosController ProdutosController = new ProdutosController();

    static String[] colunas = {"Id", "NomeProduto", "Marca", "Und.", "Localizacao", "Estoque", "Preço de Atacado"};
                      
    public TabeladeBicicleta2() {
        initComponents();
        listarProdutos();
        
    }
        @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        buscaProduto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaProdutosBicicleta2 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        vCompra = new javax.swing.JLabel();
        vRevenda = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        vVarejo = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        marca = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        localização = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        qtdEstoque = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        descricao = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        id = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        unidade = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setTitle("Lorem Auctor - Tabela de Produtos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        buscaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                buscaProdutoKeyPressed(evt);
            }
        });

        TabelaProdutosBicicleta2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        TabelaProdutosBicicleta2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabelaProdutosBicicleta2.setGridColor(new java.awt.Color(0, 0, 0));
        TabelaProdutosBicicleta2.setRowHeight(35);
        TabelaProdutosBicicleta2.setSelectionBackground(new java.awt.Color(0, 0, 0));
        TabelaProdutosBicicleta2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaProdutosBicicleta2MouseClicked(evt);
            }
        });
        TabelaProdutosBicicleta2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TabelaProdutosBicicleta2KeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaProdutosBicicleta2KeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaProdutosBicicleta2);

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/a2.png"))); // NOI18N
        jLabel4.setText("Pesquisar");

        jButton4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1.png"))); // NOI18N
        jButton4.setText("Atualizar Tabela");
        jButton4.setToolTipText("Atualizar Informações da Tabela");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton1.setText("Pesquisar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 255)));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel1.setText("Valor de Compra:");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel2.setText("Valor de Revenda:");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel3.setText("Valor de Varejo:");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel5.setText("$");

        vCompra.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        vCompra.setText("0.00");

        vRevenda.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        vRevenda.setText("0.00");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel6.setText("$");

        vVarejo.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        vVarejo.setText("0.00");

        jLabel7.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        jLabel7.setText("$");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel8.setText("Marca:");

        marca.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        marca.setText("-");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel9.setText("Localização:");

        localização.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        localização.setText("-");

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel10.setText("Quantidade no Estoque:");

        qtdEstoque.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        qtdEstoque.setText("-");

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel11.setText("Descrição:");

        descricao.setBackground(new java.awt.Color(255, 0, 0));
        descricao.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        descricao.setForeground(new java.awt.Color(255, 0, 0));
        descricao.setText("-");

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel12.setText("Identificador:");

        id.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        id.setText("-");

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1.png"))); // NOI18N
        jButton2.setText("Atualizar Produto");
        jButton2.setToolTipText("Atualizar Produto");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel13.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel13.setText("Unidade");

        unidade.setFont(new java.awt.Font("Arial Narrow", 1, 18)); // NOI18N
        unidade.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(vCompra))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addComponent(jLabel6)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vRevenda))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel8))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jLabel7)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(vVarejo))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(localização))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(marca))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel11))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel9))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(descricao))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(qtdEstoque))
                                .addGap(49, 49, 49)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(id)
                                    .addComponent(jLabel12)
                                    .addComponent(jLabel13)
                                    .addComponent(unidade))))))
                .addContainerGap(48, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel11)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricao)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(vCompra))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vRevenda)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(vVarejo))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(marca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(jLabel13))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(localização)
                    .addComponent(unidade))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(qtdEstoque)
                    .addComponent(id))
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(buscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jButton1))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton4)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 909, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(buscaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(20, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
   
    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
     AtualizarPecasBike apb = new AtualizarPecasBike();
     TelaPrincipal.Addtelaprincipal(apb);
        TelaPrincipal.centralizar(apb);
     int i = TabelaProdutosBicicleta2.getSelectedRow();
     AtualizarPecasBike.produto(TabelaProdutosBicicleta2.getValueAt(i, 1).toString(), TabelaProdutosBicicleta2);
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        listarProdutos();
    }//GEN-LAST:event_jButton4ActionPerformed

    private void TabelaProdutosBicicleta2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaProdutosBicicleta2KeyPressed
         if(evt.getKeyCode() == KeyEvent.VK_ENTER){
         Utilidades.botaoEnterParaAdicionarProduto(TabelaProdutosBicicleta2, this, new BigDecimal (vCompra.getText()), new BigDecimal (vVarejo.getText()));
         }
    }//GEN-LAST:event_TabelaProdutosBicicleta2KeyPressed

    private void buscaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_buscaProdutoKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            buscaProduto.setText(buscaProduto.getText().toUpperCase().trim());
            Utilidades.buscarProdutosBike(buscaProduto.getText().toUpperCase().trim(), colunas, TabelaProdutosBicicleta2);
        }
    }//GEN-LAST:event_buscaProdutoKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        buscaProduto.setText(buscaProduto.getText().toUpperCase());
        Utilidades.buscarProdutosBike(buscaProduto.getText().toUpperCase().trim(), colunas, TabelaProdutosBicicleta2);
    }//GEN-LAST:event_jButton1ActionPerformed

    private void TabelaProdutosBicicleta2KeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaProdutosBicicleta2KeyReleased
        Utilidades.informacoesProdutos(TabelaProdutosBicicleta2, descricao, vCompra, vRevenda, vVarejo, marca, localização, qtdEstoque, unidade, id);
    }//GEN-LAST:event_TabelaProdutosBicicleta2KeyReleased

    private void TabelaProdutosBicicleta2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaProdutosBicicleta2MouseClicked
        Utilidades.informacoesProdutos(TabelaProdutosBicicleta2, descricao, vCompra, vRevenda, vVarejo, marca, localização, qtdEstoque, unidade, id);
        if(evt.getClickCount() == 2){
         Utilidades.botaoEnterParaAdicionarProduto(TabelaProdutosBicicleta2, this, new BigDecimal (vCompra.getText()), new BigDecimal (vVarejo.getText()));   
        }
    }//GEN-LAST:event_TabelaProdutosBicicleta2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    public static javax.swing.JTable TabelaProdutosBicicleta2;
    public static javax.swing.JTextField buscaProduto;
    private static javax.swing.JLabel descricao;
    private static javax.swing.JLabel id;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel localização;
    private static javax.swing.JLabel marca;
    private static javax.swing.JLabel qtdEstoque;
    private static javax.swing.JLabel unidade;
    private static javax.swing.JLabel vCompra;
    private static javax.swing.JLabel vRevenda;
    private static javax.swing.JLabel vVarejo;
    // End of variables declaration//GEN-END:variables
         public static void pesquisarProduto(String produto){
            buscaProduto.setText(produto.toUpperCase().trim());
            Utilidades.buscarProdutosBike(produto, colunas, TabelaProdutosBicicleta2);
        }
       private void listarProdutos() {
        try {
            List<Produtos> listaProdutos = ProdutosController.listarProdutosbike();
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            for (Produtos y : listaProdutos) {
                model.addRow(new Object[] {
                    y.getIdProduto(),
                    y.getNomeProduto(),
                    y.getMarca(),
                    y.getUnidade(),
                    y.getLocalizador(),
                    y.getQuantidadeEstoque(),
                    y.getPrecoRevenda()
                });
            }
           TabelaProdutosBicicleta2.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar os Produtos!");
        }
        Utilidades.larguraColunasTabelas(TabelaProdutosBicicleta2);
    }
       
}

