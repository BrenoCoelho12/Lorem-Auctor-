/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.apresentacao;

import java.awt.event.KeyEvent;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableRowSorter;
import tcc.dao.ClienteFisicoDao;
import tcc.dominio.ClienteFisico;
import tcc.negocio.ClienteFisicoController;
import util.Utilidades;

/**
 *
 * @author Breno-
 */
public class TabeladeClientes extends javax.swing.JInternalFrame {

    ClienteFisicoController Cliente_fisicoController  = new ClienteFisicoController();
    
     String[] colunas = {"Cód. Cliente", "Nome", "Cidade", "Tel. Celular", "Tel. Residencial"};
    
    public TabeladeClientes() {
        initComponents();
        listarClientes();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        TabelaCliente = new javax.swing.JTable();
        apagar = new javax.swing.JButton();
        cadastrar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        pesquisarCliente = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cidadeCliente = new javax.swing.JLabel();
        enderecoCliente = new javax.swing.JLabel();
        cpfCliente = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        rgInscricaoCliente = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        emailCliente = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        telCelular = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        nomeCliente = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        telEmpresarial = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        estadoCliente = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        idCliente = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setTitle("Lorem Auctor - Tabela de Clientes");

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        TabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {

            }
        ));
        TabelaCliente.setRowHeight(35);
        TabelaCliente.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                TabelaClienteMouseClicked(evt);
            }
        });
        TabelaCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                TabelaClienteKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                TabelaClienteKeyReleased(evt);
            }
        });
        jScrollPane1.setViewportView(TabelaCliente);

        apagar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        apagar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/15.png"))); // NOI18N
        apagar.setText("Apagar Cliente");
        apagar.setToolTipText("Apagar Informações do Cliente");
        apagar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apagarActionPerformed(evt);
            }
        });

        cadastrar.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        cadastrar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/3.png"))); // NOI18N
        cadastrar.setText("AdicionarCliente");
        cadastrar.setToolTipText("Cadastrar Cliente");
        cadastrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cadastrarActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 102));
        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/a2.png"))); // NOI18N
        jLabel4.setText("Pesquisar");

        pesquisarCliente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pesquisarClienteKeyPressed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/1.png"))); // NOI18N
        jButton5.setText("Atualizar Tabela");
        jButton5.setToolTipText("Atualizar Informações da Tabela");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Arial", 0, 14)); // NOI18N
        jButton2.setText("Pesquisar");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder(new java.awt.Color(204, 204, 204), new java.awt.Color(204, 204, 255)));

        jLabel1.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel1.setText("Cidade");

        jLabel2.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel2.setText("Endereço:");

        jLabel3.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel3.setText("CPF:");

        cidadeCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        cidadeCliente.setText("-");

        enderecoCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        enderecoCliente.setText("-");

        cpfCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        cpfCliente.setText("-");

        jLabel8.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel8.setText("RG/Inscrição:");

        rgInscricaoCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        rgInscricaoCliente.setText("-");

        jLabel9.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel9.setText("Email:");

        emailCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        emailCliente.setText("-");

        jLabel10.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel10.setText("Telefone Celular:");

        telCelular.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        telCelular.setText("-");

        jLabel11.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel11.setText("Nome do Cliente:");

        nomeCliente.setBackground(new java.awt.Color(255, 0, 0));
        nomeCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        nomeCliente.setForeground(new java.awt.Color(255, 0, 0));
        nomeCliente.setText("-");

        jLabel12.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel12.setText("Telefone Empresarial");

        telEmpresarial.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        telEmpresarial.setText("-");

        jLabel5.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel5.setText("Estado:");

        estadoCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        estadoCliente.setText("-");

        jLabel6.setFont(new java.awt.Font("Arial Narrow", 0, 14)); // NOI18N
        jLabel6.setText("Cód. Cliente:");

        idCliente.setFont(new java.awt.Font("Arial Narrow", 1, 14)); // NOI18N
        idCliente.setText("-");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel3)
                    .addComponent(jLabel1)
                    .addComponent(jLabel8)
                    .addComponent(jLabel11)
                    .addComponent(jLabel9)
                    .addComponent(nomeCliente)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel10)
                                    .addComponent(telCelular))
                                .addGap(49, 49, 49))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                                .addComponent(rgInscricaoCliente)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(telEmpresarial)
                            .addComponent(jLabel12)
                            .addComponent(jLabel5)
                            .addComponent(estadoCliente)
                            .addComponent(jLabel6)
                            .addComponent(idCliente)))
                    .addComponent(cpfCliente)
                    .addComponent(enderecoCliente)
                    .addComponent(cidadeCliente)
                    .addComponent(emailCliente))
                .addContainerGap(78, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nomeCliente)
                    .addComponent(estadoCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cidadeCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(enderecoCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cpfCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rgInscricaoCliente)
                    .addComponent(idCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(emailCliente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jLabel12))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(telCelular)
                    .addComponent(telEmpresarial))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jButton2)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57)
                        .addComponent(cadastrar)
                        .addGap(18, 18, 18)
                        .addComponent(apagar)
                        .addGap(18, 18, 18)
                        .addComponent(jButton5))
                    .addComponent(jScrollPane1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(pesquisarCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cadastrar, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(apagar, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 485, Short.MAX_VALUE))))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cadastrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cadastrarActionPerformed
        CadastroCliente cc = new CadastroCliente();
        TelaPrincipal.Addtelaprincipal(cc);
        TelaPrincipal.centralizar(cc);
    }//GEN-LAST:event_cadastrarActionPerformed

    private void apagarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apagarActionPerformed
        if(TabelaCliente.getSelectedRowCount() == 0){
            JOptionPane.showMessageDialog(null, "Selecione um cliente.");
        }
        int linha = TabelaCliente.getSelectedRow();
        int qtdLinhasSelecionadas = TabelaCliente.getSelectedRowCount();
        
        ClienteFisico cf = new ClienteFisico();
        int id = (Integer) TabelaCliente.getValueAt(linha, 0);
        String nome = (String) TabelaCliente.getValueAt(linha, 1);
        String cidade = (String) TabelaCliente.getValueAt(linha, 2);
        String estado = estadoCliente.getText();
        String CPF = cpfCliente.getText();
        String RG = rgInscricaoCliente.getText();
        
        cf.setIdCliente(id);
      
         if(qtdLinhasSelecionadas > 1){
            JOptionPane.showMessageDialog(null, "Selecione Apenas 1 linha!");
            return;
        }

        if(qtdLinhasSelecionadas < 0){
            JOptionPane.showMessageDialog(null, "Selecione 1 linha!");
            return;
        }
        
      int result =   JOptionPane.showConfirmDialog(rootPane, "Tem certeza que deseja Apagar este Cliente?" + "\n ID: "+ id +"\n Nome: " + nome +  "\n Cidade: " + cidade + "\n Estado: " + estado +"\n CPF: " + CPF + "\n RG: " + RG);
      if(result == JOptionPane.OK_OPTION){
            try {
                Cliente_fisicoController.ApagarCliente(cf);
                JOptionPane.showMessageDialog(null, "Cliente Apagado com sucesso");
                listarClientes();
            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(null, "Não foi possível apagar o cliente. Tente Novamente.");
                ex.printStackTrace();
            }
      }

       
        
    }//GEN-LAST:event_apagarActionPerformed

    private void TabelaClienteMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_TabelaClienteMouseClicked
        Utilidades.informacoesClientePorID(TabelaCliente, cidadeCliente, cidadeCliente, enderecoCliente, nomeCliente, cpfCliente, rgInscricaoCliente, 
                emailCliente, telCelular, telEmpresarial, idCliente);
    }//GEN-LAST:event_TabelaClienteMouseClicked

    private void TabelaClienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaClienteKeyReleased
        Utilidades.informacoesClientePorID(TabelaCliente, cidadeCliente, cidadeCliente, enderecoCliente, nomeCliente, cpfCliente, rgInscricaoCliente, 
                emailCliente, telCelular, telEmpresarial, idCliente);
    }//GEN-LAST:event_TabelaClienteKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        listarClientes();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void TabelaClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_TabelaClienteKeyPressed
/*        if(evt.getKeyCode() == KeyEvent.VK_ENTER)
         botaoEnterParaAddCliente();*/
            
    }//GEN-LAST:event_TabelaClienteKeyPressed

    private void pesquisarClienteKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisarClienteKeyPressed
        if(evt.getKeyCode() == KeyEvent.VK_ENTER){
            pesquisarCliente.setText(pesquisarCliente.getText().toUpperCase());
            buscarClientes(pesquisarCliente.getText());
        }
    }//GEN-LAST:event_pesquisarClienteKeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        pesquisarCliente.setText(pesquisarCliente.getText().toUpperCase());
        buscarClientes(pesquisarCliente.getText());
    }//GEN-LAST:event_jButton2ActionPerformed

   
    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTable TabelaCliente;
    private javax.swing.JButton apagar;
    private javax.swing.JButton cadastrar;
    private static javax.swing.JLabel cidadeCliente;
    private static javax.swing.JLabel cpfCliente;
    private static javax.swing.JLabel emailCliente;
    private static javax.swing.JLabel enderecoCliente;
    private static javax.swing.JLabel estadoCliente;
    private static javax.swing.JLabel idCliente;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private static javax.swing.JLabel nomeCliente;
    private javax.swing.JTextField pesquisarCliente;
    private static javax.swing.JLabel rgInscricaoCliente;
    private static javax.swing.JLabel telCelular;
    private static javax.swing.JLabel telEmpresarial;
    // End of variables declaration//GEN-END:variables
             private void listarClientes() {
        try {
            List<ClienteFisico> listaClientes = Cliente_fisicoController.listarClientes();
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            for (ClienteFisico z : listaClientes) {
                model.addRow(new Object[] {
                    z.getIdCliente(),
                    z.getNome(),
                    z.getCidade(),
                    z.getT_celular(),
                    z.getT_residencial(),
                });
            }
           TabelaCliente.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar os Clientes!");
        }
        TabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(10);
        TabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(150);
        TabelaCliente.setDefaultEditor(Object.class, null);
    }
                private void buscarClientes(String pesquisar) {
        try {
            ClienteFisicoDao cdao = new ClienteFisicoDao();
            List<ClienteFisico> buscarClientes = cdao.buscarClientes(pesquisar);
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            for (ClienteFisico z : buscarClientes) {
                model.addRow(new Object[] {
                    z.getIdCliente(),
                    z.getNome(),
                    z.getCidade(),
                    z.getT_celular(),
                    z.getT_residencial(),
                });
            }
           TabelaCliente.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar os Clientes!");
        }
        TabelaCliente.getColumnModel().getColumn(0).setPreferredWidth(10);
        TabelaCliente.getColumnModel().getColumn(1).setPreferredWidth(150);
        TabelaCliente.setDefaultEditor(Object.class, null);
    }

/*    
        public void botaoEnterParaAddCliente() {
        int linhaSelecionada = TabelaCliente.getSelectedRow();
        Vector vetor = ((DefaultTableModel) TabelaCliente.getModel()).getDataVector();
        ExecutarVenda.carregarinformacoescliente((Vector)vetor.get(linhaSelecionada));
        this.dispose();
        }
  */      
  
}
