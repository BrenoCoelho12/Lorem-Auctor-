/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.apresentacao;

import java.math.BigDecimal;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import tcc.dominio.Produtos;
import tcc.negocio.ProdutosController;
import util.Utilidades;

/**
 *
 * @author Breno-
 */
public class AtualizarPecasBike extends javax.swing.JInternalFrame {

    ProdutosController ProdutosbikeController = new ProdutosController();

    public AtualizarPecasBike() {
        initComponents();
        idProduto.setEnabled(false);
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
        nProduto = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        idProduto = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        vCompra = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        vRevenda = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        vVarejo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        nLocalizacao = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        nUnidade = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        nQtdEstoque = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        nMarca = new javax.swing.JTextField();
        nomeProduto = new javax.swing.JLabel();

        setClosable(true);
        setResizable(true);
        setTitle("Lorem Auctor - Atualizar Produtos");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Cód. Produto:");

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Novo Nome:");

        jLabel3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel3.setText("Novo Preço de Compra:");

        vCompra.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vCompraKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Novo Preço de Revenda:");

        vRevenda.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vRevendaKeyReleased(evt);
            }
        });

        jLabel5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel5.setText("Novo Preço de Varejo:");

        vVarejo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                vVarejoKeyReleased(evt);
            }
        });

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setText("Nova Localização:");

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel8.setText("Unidade:");

        jLabel11.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel11.setText("Quantidade no Estoque:");

        nQtdEstoque.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nQtdEstoqueKeyReleased(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1.png"))); // NOI18N
        jButton1.setText("Atualizar");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jLabel9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel9.setText("Marca");

        nMarca.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                nMarcaKeyReleased(evt);
            }
        });

        nomeProduto.setFont(new java.awt.Font("Arial", 1, 12)); // NOI18N
        nomeProduto.setText("-");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2)
                                .addComponent(jLabel3)
                                .addComponent(jLabel4)
                                .addComponent(jLabel1))
                            .addGap(47, 47, 47)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(vRevenda)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(idProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(0, 43, Short.MAX_VALUE))
                                .addComponent(vCompra)
                                .addComponent(nProduto)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel6)
                                .addComponent(jLabel5)
                                .addComponent(jLabel8)
                                .addComponent(jLabel9))
                            .addGap(61, 61, 61)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(nLocalizacao)
                                .addComponent(vVarejo, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nUnidade, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 199, Short.MAX_VALUE)
                                .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(nMarca)))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addComponent(jLabel11)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(nQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(nomeProduto))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(nomeProduto)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(idProduto)
                    .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(nProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(vCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(vRevenda, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(vVarejo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nMarca)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(nLocalizacao))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(nUnidade)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(nQtdEstoque, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(1, 1, 1)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void vCompraKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vCompraKeyReleased
        vCompra.setText(vCompra.getText().toUpperCase());

        if((evt.getKeyCode() < 48 || evt.getKeyCode() > 58) && (evt.getKeyCode() != 8 && evt.getKeyCode() != 46))
        if(evt.getKeyCode() < 96 || evt.getKeyCode() > 105)
        if(vCompra.getText().length() > 0)
        vCompra.setText(vCompra.getText().
            substring(0, vCompra.getText().length()-1));
        if(evt.getKeyCode() == 44 || evt.getKeyCode() == 110)
        vCompra.setText(vCompra.getText()+".");
    }//GEN-LAST:event_vCompraKeyReleased

    private void vRevendaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vRevendaKeyReleased
        vRevenda.setText(vRevenda.getText().toUpperCase());

        if((evt.getKeyCode() < 48 || evt.getKeyCode() > 58) && (evt.getKeyCode() != 8 && evt.getKeyCode() != 46))
        if(evt.getKeyCode() < 96 || evt.getKeyCode() > 105)
        if(vRevenda.getText().length() > 0)
        vRevenda.setText(vRevenda.getText().
            substring(0, vRevenda.getText().length()-1));
        if(evt.getKeyCode() == 44 || evt.getKeyCode() == 110)
        vRevenda.setText(vRevenda.getText()+".");
    }//GEN-LAST:event_vRevendaKeyReleased

    private void vVarejoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_vVarejoKeyReleased
        vVarejo.setText(vVarejo.getText().toUpperCase());

        if((evt.getKeyCode() < 48 || evt.getKeyCode() > 58) && (evt.getKeyCode() != 8 && evt.getKeyCode() != 46))
        if(evt.getKeyCode() < 96 || evt.getKeyCode() > 105)
        if(vVarejo.getText().length() > 0)
        vVarejo.setText(vVarejo.getText().
            substring(0, vVarejo.getText().length()-1));
        if(evt.getKeyCode() == 44 || evt.getKeyCode() == 110)
        vVarejo.setText(vVarejo.getText()+".");
    }//GEN-LAST:event_vVarejoKeyReleased

    private void nQtdEstoqueKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nQtdEstoqueKeyReleased
        if((evt.getKeyCode() < 48 || evt.getKeyCode() > 58) && (evt.getKeyCode() != 8 && evt.getKeyCode() != 46))
        if(evt.getKeyCode() < 96 || evt.getKeyCode() > 105)
        if(nQtdEstoque.getText().length() > 0)
        nQtdEstoque.setText(nQtdEstoque.getText().
            substring(0, nQtdEstoque.getText().length()-1));

    }//GEN-LAST:event_nQtdEstoqueKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        nLocalizacao.setText(nLocalizacao.getText().toUpperCase());
        nProduto.setText(nProduto.getText().toUpperCase());
        nMarca.setText(nMarca.getText().toUpperCase());
        nUnidade.setText(nUnidade.getText().toUpperCase());
        if(idProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Selecione um Produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(nProduto.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o novo nome do Produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(vCompra.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o novo preço de compra do Produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if(vRevenda.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o novo valor de revenda do Produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(vVarejo.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha o novo valor de varejo do Produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(nLocalizacao.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a nova localização do Produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(nUnidade.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a nova informação de Unidade do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if(nQtdEstoque.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "Preencha a quantidade no estoque do produto", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Produtos produto = new Produtos();

        BigDecimal campo_valor_revenda = new BigDecimal(vRevenda.getText().trim());
        BigDecimal campo_valor_varejo = new BigDecimal(vVarejo.getText().trim());
        BigDecimal campo_valor_compra = new BigDecimal(vCompra.getText().trim());
        int campoid = Integer.parseInt(idProduto.getText().trim());
        int qtdEstoque = Integer.parseInt(nQtdEstoque.getText().trim());

        produto.setIdProduto(campoid);
        produto.setNomeProduto(nProduto.getText().trim());
        produto.setPrecoVarejo(campo_valor_varejo);
        produto.setPrecoRevenda(campo_valor_revenda);
        produto.setPrecoDeCompra(campo_valor_compra);
        produto.setLocalizador(nLocalizacao.getText().trim());
        produto.setMarca(nMarca.getText().trim());
        produto.setUnidade(nUnidade.getText().trim());
        produto.setQuantidadeEstoque(qtdEstoque);
        try {
            ProdutosbikeController.Atualizarpecas(produto);
            JOptionPane.showMessageDialog(null, "Produto atualizado com sucesso!");
            limparDados();
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao atualizar as informações do produto!");
        }

        limparDados();
        this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void nMarcaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_nMarcaKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_nMarcaKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField idProduto;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private static javax.swing.JTextField nLocalizacao;
    private static javax.swing.JTextField nMarca;
    private static javax.swing.JTextField nProduto;
    private static javax.swing.JTextField nQtdEstoque;
    private static javax.swing.JTextField nUnidade;
    private static javax.swing.JLabel nomeProduto;
    private static javax.swing.JTextField vCompra;
    private static javax.swing.JTextField vRevenda;
    private static javax.swing.JTextField vVarejo;
    // End of variables declaration//GEN-END:variables

    private void limparDados() {
        
        nLocalizacao.setText("");
        nProduto.setText("");
        vCompra.setText("");
        vRevenda.setText("");
        vVarejo.setText("");
        idProduto.setText("");
        nMarca.setText("");
        nQtdEstoque.setText("");
        nUnidade.setText("");
      
    }
    
    public static void produto(String produto, JTable tabela){
        nomeProduto.setText(produto);
        Utilidades.informacoesProdutos2(tabela, nProduto, vCompra, vRevenda, vVarejo, nMarca, nLocalizacao, nQtdEstoque, nUnidade, idProduto);
    }
    }
