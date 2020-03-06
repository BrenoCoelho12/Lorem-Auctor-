/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.apresentacao;

import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Toolkit;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JMenuBar;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;
import net.sf.jasperreports.engine.JRException;
import org.postgresql.util.PGTime;
import tcc.dao.TimeDao;
import tcc.dominio.Time;
import tcc.relatorios.RelatorioClientes;
import tcc.relatorios.RelatorioDasVendasAtacadoPorData;
import tcc.relatorios.RelatorioDasVendasVarejoPorData;
import tcc.relatorios.RelatorioDeTodasVendasAtacado;
import tcc.relatorios.RelatorioDeTodasVendasVarejo;
import tcc.relatorios.RelatorioPecasBike;
import tcc.relatorios.RelatorioPecasMoto;

/**
 *
 * @author Breno-
 */
public class TelaPrincipal extends javax.swing.JFrame {

    private static MaskFormatter msk = null;

    public TelaPrincipal() {
        initComponents();
        cursorMouse();
        licenca();
        //    licenca();
        URL url = this.getClass().getResource("/icones/iconejpg.jpg");
        Image imagemTitulo = Toolkit.getDefaultToolkit().getImage(url);
        this.setIconImage(imagemTitulo);

        this.setExtendedState(MAXIMIZED_BOTH);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        Principal = new javax.swing.JDesktopPane();
        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabelCC = new javax.swing.JLabel();
        menuCP = new javax.swing.JLabel();
        jLabelRV = new javax.swing.JLabel();
        menuRV = new javax.swing.JLabel();
        menuCC = new javax.swing.JLabel();
        jLabelCP = new javax.swing.JLabel();
        menuVR = new javax.swing.JLabel();
        jLabelVR = new javax.swing.JLabel();
        menuAE = new javax.swing.JLabel();
        jLabelAE = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu7 = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenu5 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenu6 = new javax.swing.JMenu();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenuItem13 = new javax.swing.JMenuItem();
        jMenuItem21 = new javax.swing.JMenuItem();
        jMenuItem20 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem14 = new javax.swing.JMenuItem();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem17 = new javax.swing.JMenuItem();
        jMenuItem18 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 102, 102));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel2.setForeground(new java.awt.Color(0, 102, 102));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 160, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/Lorem Auctor (1) - Copia.png"))); // NOI18N

        jPanel3.setBackground(new java.awt.Color(204, 204, 204));
        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED, new java.awt.Color(204, 204, 204), null));

        jLabelCC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCC.setText("Cadastrar Clientes");
        jLabelCC.setToolTipText("Cadastre seus clientes aqui!");
        jLabelCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCCMouseClicked(evt);
            }
        });

        menuCP.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuCP.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-Edit Node Filled-50.png"))); // NOI18N
        menuCP.setToolTipText("Cadastre seus produtos aqui!");
        menuCP.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        menuCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCPMouseClicked(evt);
            }
        });

        jLabelRV.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelRV.setText("Realizar Venda");
        jLabelRV.setToolTipText("Realize suas vendas aqui!");
        jLabelRV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelRVMouseClicked(evt);
            }
        });

        menuRV.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuRV.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-Shopping Cart-50.png"))); // NOI18N
        menuRV.setToolTipText("Realize suas vendas aqui!");
        menuRV.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        menuRV.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuRVMouseClicked(evt);
            }
        });

        menuCC.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuCC.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icone.png"))); // NOI18N
        menuCC.setToolTipText("Cadastre seus clientes aqui!");
        menuCC.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        menuCC.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuCCMouseClicked(evt);
            }
        });

        jLabelCP.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelCP.setText("Cadastrar Produtos");
        jLabelCP.setToolTipText("Cadastre seus produtos aqui!");
        jLabelCP.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelCPMouseClicked(evt);
            }
        });

        menuVR.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuVR.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-Search Property-50.png"))); // NOI18N
        menuVR.setToolTipText("Consulte suas vendas no atacado!");
        menuVR.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        menuVR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuVRMouseClicked(evt);
            }
        });

        jLabelVR.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelVR.setText("Vendas Realizadas no Atacado");
        jLabelVR.setToolTipText("Consulte suas vendas no atacado!");
        jLabelVR.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelVRMouseClicked(evt);
            }
        });

        menuAE.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        menuAE.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/icons8-Restart-50.png"))); // NOI18N
        menuAE.setToolTipText("Atualize seu estoque aqui!");
        menuAE.setBorder(javax.swing.BorderFactory.createEtchedBorder(javax.swing.border.EtchedBorder.RAISED));
        menuAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuAEMouseClicked(evt);
            }
        });

        jLabelAE.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabelAE.setText("Atualizar Estoque");
        jLabelAE.setToolTipText("Atualize seu estoque aqui!");
        jLabelAE.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabelAEMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(menuCP, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(menuCC, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabelCP)
                        .addGap(18, 18, 18)
                        .addComponent(jLabelCC, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(menuRV, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabelRV))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabelVR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuVR, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabelAE)
                    .addComponent(menuAE, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(195, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(menuVR, javax.swing.GroupLayout.DEFAULT_SIZE, 69, Short.MAX_VALUE)
                    .addComponent(menuCP, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuRV, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuCC, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(menuAE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabelRV)
                    .addComponent(jLabelCC)
                    .addComponent(jLabelCP)
                    .addComponent(jLabelVR)
                    .addComponent(jLabelAE))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel1)
                        .addGap(43, 43, 43))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, 123, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(27, 27, 27))
        );

        Principal.setLayer(jPanel1, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout PrincipalLayout = new javax.swing.GroupLayout(Principal);
        Principal.setLayout(PrincipalLayout);
        PrincipalLayout.setHorizontalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        PrincipalLayout.setVerticalGroup(
            PrincipalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PrincipalLayout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(0, 0, 0))
        );

        jMenuBar1.setBackground(new java.awt.Color(102, 102, 255));
        jMenuBar1.setAlignmentX(1.0F);
        jMenuBar1.setAutoscrolls(true);
        jMenuBar1.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenuBar1.setMaximumSize(new java.awt.Dimension(100, 100));
        jMenuBar1.setOpaque(false);
        jMenuBar1.setPreferredSize(new java.awt.Dimension(20, 30));
        jMenuBar1.setVerifyInputWhenFocusTarget(false);

        jMenu7.setText("Cadastros");
        jMenu7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem2.setText("Cadastrar Cliente");
        jMenuItem2.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem2);

        jMenuItem5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem5.setText("Cadastrar Produtos");
        jMenuItem5.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu7.add(jMenuItem5);

        jMenuBar1.add(jMenu7);

        jMenu5.setText("Produtos");
        jMenu5.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N

        jMenuItem6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem6.setText("Tabela de Produtos de Moto");
        jMenuItem6.setToolTipText("Tabela com todos os produtos de Moto cadastrados!");
        jMenuItem6.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem6);

        jMenuItem7.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem7.setText("Tabela de Produtos de Bike");
        jMenuItem7.setToolTipText("Tabela com todos os produtos de Bike Cadastrados");
        jMenuItem7.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem7);

        jMenuItem9.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem9.setText("Atualizar Informações dos Produtos");
        jMenuItem9.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jMenu5.add(jMenuItem9);

        jMenu6.setText("Estoque");
        jMenu6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenu6.setPreferredSize(new java.awt.Dimension(220, 30));

        jMenuItem8.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem8.setText("Atualizar Estoque");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu6.add(jMenuItem8);

        jMenu5.add(jMenu6);

        jMenuBar1.add(jMenu5);

        jMenu2.setText("Vendas no Atacado");
        jMenu2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        jMenu2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenu2.setPreferredSize(new java.awt.Dimension(115, 29));

        jMenuItem13.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, java.awt.event.InputEvent.CTRL_MASK));
        jMenuItem13.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem13.setText("Realizar Venda");
        jMenuItem13.setToolTipText("Realizar Venda no Atacado");
        jMenuItem13.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem13ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem13);

        jMenuItem21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem21.setText("Parcelamento das Vendas");
        jMenuItem21.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem21.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem21ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem21);

        jMenuItem20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem20.setText("Tabela de Vendas no Atacado");
        jMenuItem20.setToolTipText("Tabela com todas as vendas Realizadas no Atacado!");
        jMenuItem20.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem20.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem20ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem20);

        jMenuItem10.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem10.setText("Tabela de Pré-vendas");
        jMenuItem10.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu2.add(jMenuItem10);

        jMenuBar1.add(jMenu2);

        jMenu1.setText("Vendas no Varejo");
        jMenu1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenu1.setPreferredSize(new java.awt.Dimension(104, 29));

        jMenuItem1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem1.setText("Entrada");
        jMenuItem1.setToolTipText("Cadastre aqui sua movimentação no Varejo!");
        jMenuItem1.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem1);

        jMenuItem3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem3.setText("Tabela vendas no Varejo");
        jMenuItem3.setToolTipText("Tabela com todas as movimentações no Varejo que foram cadastradas!");
        jMenuItem3.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem3);

        jMenuBar1.add(jMenu1);

        jMenu3.setText("Consultas");
        jMenu3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenu3.setPreferredSize(new java.awt.Dimension(65, 40));

        jMenuItem4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem4.setText("Tabela de Clientes");
        jMenuItem4.setToolTipText("Tabela com todos os Clientes Cadastrados!");
        jMenuItem4.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem4);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("Relatórios");
        jMenu4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenu4.setPreferredSize(new java.awt.Dimension(65, 40));

        jMenuItem14.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem14.setText("Relatório Vendas Varejo");
        jMenuItem14.setToolTipText("Relatório das Vendas realizadas no Varejo!");
        jMenuItem14.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem14ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem14);

        jMenuItem15.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem15.setText("Relatório Vendas Atacado");
        jMenuItem15.setToolTipText("Relatório das Vendas realizadas no Atacado");
        jMenuItem15.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem15);

        jMenuItem16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem16.setText("Relatório de Clientes");
        jMenuItem16.setToolTipText("Tabela com Informações dos Clientes!");
        jMenuItem16.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem16);

        jMenuItem17.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem17.setText("Relatório das Peças de Bicicleta");
        jMenuItem17.setToolTipText("Tabela com informações das Peças de Bike!");
        jMenuItem17.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem17ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem17);

        jMenuItem18.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jMenuItem18.setText("Relatório das Peças de Moto");
        jMenuItem18.setToolTipText("Tabela com as informações das Peças de Moto!");
        jMenuItem18.setPreferredSize(new java.awt.Dimension(220, 30));
        jMenuItem18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem18ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem18);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);
        jMenuBar1.getAccessibleContext().setAccessibleDescription("");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Principal)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(0, 0, 0)
                .addComponent(Principal))
        );

        setBounds(0, 0, 1053, 503);
    }// </editor-fold>//GEN-END:initComponents

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        MovimentosDiarios obj12 = new MovimentosDiarios();
        Principal.add(obj12);
        obj12.setVisible(true);
        centralizar(obj12);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem13ActionPerformed
        ExecutarVenda obj13 = new ExecutarVenda();
        Principal.add(obj13);
        obj13.setVisible(true);
        centralizar(obj13);
    }//GEN-LAST:event_jMenuItem13ActionPerformed

    private void jMenuItem17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem17ActionPerformed
        try {
            RelatorioPecasBike.gerarRelatorio("RelatorioPecasBike");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (JRException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
        } catch (IOException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
        }

    }//GEN-LAST:event_jMenuItem17ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        try {
            RelatorioClientes.gerarRelatorio("RelatorioClientes");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar o relatório. Tente novamente mais tarde.", "Erro!", JOptionPane.ERROR_MESSAGE);

        } catch (JRException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar o relatório. Tente novamente mais tarde.", "Erro!", JOptionPane.ERROR_MESSAGE);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Ocorreu um erro ao gerar o relatório. Tente novamente mais tarde.", "Erro!", JOptionPane.ERROR_MESSAGE);

        }

    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem18ActionPerformed

        try {
            RelatorioPecasMoto.gerarRelatorio("RelatorioPecasMoto");

        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (JRException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);

        }
    }//GEN-LAST:event_jMenuItem18ActionPerformed

    private void jMenuItem14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem14ActionPerformed
        //CRIANDO A MÁSCARA DA DATA
        try {
            msk = new MaskFormatter("##-##-####");
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CRIANDO OS CAMPOS
        JRadioButton selecionarTodasAsVendas = new JRadioButton("Gerar todas as vendas");
        JFormattedTextField dataInicio = new JFormattedTextField(msk);
        JFormattedTextField dataFim = new JFormattedTextField(msk);
        Object[] datas = {selecionarTodasAsVendas, "Data de início", dataInicio, "Data final", dataFim};

        //CRIANDO A CAIXA DE DIÁLOGO SE COLOCANDO OS CAMPOS DENTRO DELA
        int resultado = JOptionPane.showConfirmDialog(null, datas, "Filtro:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        String dataI = dataInicio.getText().substring(9);
        String dataF = dataFim.getText().substring(9);

        if (resultado == JOptionPane.OK_OPTION) {

            if (selecionarTodasAsVendas.isSelected()) {
                try {
                    RelatorioDeTodasVendasVarejo.gerarRelatorio("RelatorioMovimentacaoDiaria");
                } catch (SQLException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (JRException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (FileNotFoundException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
                } catch (IOException ex) {
                    ex.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
                }
                return;
            }

            if (dataI.equals(" ") || dataF.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Erro na data informada.");
                return;
            }

            //FORMATANDO A RESPOSTA DO USUÁRIO A FIM DE QUE O MYSQL ENTENDA O INTERVALO DAS DATAS SOLICITADAS, POIS O MYSQL SÓ ENTENDE DATAS DO TIPO YYYY/MM/DD.
            String Idia = dataInicio.getText().substring(0, 2);
            String Imes = dataInicio.getText().substring(3, 5);
            String Iano = dataInicio.getText().substring(6);
            String dataInicioMysql = Iano + "-" + Imes + "-" + Idia;
            String Fdia = dataFim.getText().substring(0, 2);
            String Fmes = dataFim.getText().substring(3, 5);
            String Fano = dataFim.getText().substring(6);
            String dataFimMysql = Fano + "-" + Fmes + "-" + Fdia;

            try {
                RelatorioDasVendasVarejoPorData.gerarRelatorio("RelatorioMovimentacaoDiaria", dataInicioMysql, dataFimMysql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (JRException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
            }

        }
    }//GEN-LAST:event_jMenuItem14ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        //CRIANDO A MÁSCARA DA DATA
        try {
            msk = new MaskFormatter("##-##-####");
        } catch (ParseException ex) {
            Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
        }

        //CRIANDO OS CAMPOS
        JRadioButton selecionarTodasAsVendas = new JRadioButton("Gerar todas as vendas");
        JFormattedTextField dataInicio = new JFormattedTextField(msk);
        JFormattedTextField dataFim = new JFormattedTextField(msk);
        Object[] datas = {selecionarTodasAsVendas, "Data de início", dataInicio, "Data final", dataFim};

        //CRIANDO A CAIXA DE DIÁLOGO SE COLOCANDO OS CAMPOS DENTRO DELA
        int resultado = JOptionPane.showConfirmDialog(null, datas, "Filtro:",
                JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);

        String dataI = dataInicio.getText().substring(9);
        String dataF = dataFim.getText().substring(9);

        //RECEBENDO A RESPOSTA DO USUÁRIO
        if (resultado == JOptionPane.OK_OPTION) {
            if (selecionarTodasAsVendas.isSelected()) {
                try {
                    RelatorioDeTodasVendasAtacado.gerarRelatorio("ControleVendas");
                } catch (SQLException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (JRException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                } catch (FileNotFoundException ex) {
                    Logger.getLogger(TelaPrincipal.class.getName()).log(Level.SEVERE, null, ex);
                }
                return;
            }

            if (dataI.equals(" ") || dataF.equals(" ")) {
                JOptionPane.showMessageDialog(null, "Erro na data informada.");
                return;
            }

            //FORMATANDO A RESPOSTA DO USUÁRIO A FIM DE QUE O MYSQL ENTENDA O INTERVALO DAS DATAS SOLICITADAS, POIS O MYSQL SÓ ENTENDE DATAS DO TIPO YYYY/MM/DD.
            String Idia = dataInicio.getText().substring(0, 2);
            String Imes = dataInicio.getText().substring(3, 5);
            String Iano = dataInicio.getText().substring(6);
            String dataInicioMysql = Iano + "-" + Imes + "-" + Idia;
            String Fdia = dataFim.getText().substring(0, 2);
            String Fmes = dataFim.getText().substring(3, 5);
            String Fano = dataFim.getText().substring(6);
            String dataFimMysql = Fano + "-" + Fmes + "-" + Fdia;

            try {
                RelatorioDasVendasAtacadoPorData.gerarRelatorio("ControleVendas", dataInicioMysql, dataFimMysql);
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (JRException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(null, "Não foi possível carregar o relatório. Por favor, tente novamente mais tarde!", "Erro", JOptionPane.ERROR_MESSAGE);
            }
        }

    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem21ActionPerformed
        CadastrarParcelamentoVendas obj22 = new CadastrarParcelamentoVendas();
        Principal.add(obj22);
        obj22.setVisible(true);
        centralizar(obj22);
    }//GEN-LAST:event_jMenuItem21ActionPerformed

    private void jMenuItem20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem20ActionPerformed
        TabelaVendaExecutadas obj19 = new TabelaVendaExecutadas();
        Principal.add(obj19);
        obj19.setVisible(true);
        centralizar(obj19);
    }//GEN-LAST:event_jMenuItem20ActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        TabelaMovimentacaoDiaria obj20 = new TabelaMovimentacaoDiaria();
        Principal.add(obj20);
        obj20.setVisible(true);
        centralizar(obj20);
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        TabeladeBicicleta obj6 = new TabeladeBicicleta();
        Principal.add(obj6);
        obj6.setVisible(true);
        centralizar(obj6);
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        TabeladeMoto obj5 = new TabeladeMoto();
        Principal.add(obj5);
        obj5.setVisible(true);
        centralizar(obj5);
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        TabeladeClientes obj4 = new TabeladeClientes();
        Principal.add(obj4);
        obj4.setVisible(true);
        centralizar(obj4);
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void menuCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCPMouseClicked
        Cadastrodepeças obj = new Cadastrodepeças();
        TelaPrincipal.Addtelaprincipal(obj);
        centralizar(obj);
    }//GEN-LAST:event_menuCPMouseClicked

    private void jLabelCPMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCPMouseClicked
        Cadastrodepeças obj = new Cadastrodepeças();
        TelaPrincipal.Addtelaprincipal(obj);
        centralizar(obj);
    }//GEN-LAST:event_jLabelCPMouseClicked

    private void menuCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuCCMouseClicked
        CadastroCliente obj1 = new CadastroCliente();
        TelaPrincipal.Addtelaprincipal(obj1);
        centralizar(obj1);
    }//GEN-LAST:event_menuCCMouseClicked

    private void jLabelCCMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelCCMouseClicked
        CadastroCliente obj1 = new CadastroCliente();
        TelaPrincipal.Addtelaprincipal(obj1);
        centralizar(obj1);
    }//GEN-LAST:event_jLabelCCMouseClicked

    private void jLabelRVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelRVMouseClicked
        ExecutarVenda obj2 = new ExecutarVenda();
        TelaPrincipal.Addtelaprincipal(obj2);
        centralizar(obj2);
    }//GEN-LAST:event_jLabelRVMouseClicked

    private void menuRVMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuRVMouseClicked
        ExecutarVenda obj2 = new ExecutarVenda();
        TelaPrincipal.Addtelaprincipal(obj2);
        centralizar(obj2);
    }//GEN-LAST:event_menuRVMouseClicked

    private void menuVRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuVRMouseClicked
        TabelaVendaExecutadas obj3 = new TabelaVendaExecutadas();
        TelaPrincipal.Addtelaprincipal(obj3);
        centralizar(obj3);
    }//GEN-LAST:event_menuVRMouseClicked

    private void jLabelVRMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelVRMouseClicked
        TabelaVendaExecutadas obj3 = new TabelaVendaExecutadas();
        TelaPrincipal.Addtelaprincipal(obj3);
        centralizar(obj3);
    }//GEN-LAST:event_jLabelVRMouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        Object[] categoriaProdutos = {"Motocicleta", "Bicicleta"};
        String res = (String) JOptionPane.showInputDialog(null, "Selecione a categoria do produto:", "Categoria",
                JOptionPane.PLAIN_MESSAGE, null, categoriaProdutos, "");

        if (res.equals("Motocicleta")) {
            AtualizarEstoqueMoto obj = new AtualizarEstoqueMoto();
            TelaPrincipal.Addtelaprincipal(obj);
            centralizar(obj);
        } else if (res.equals("Bicicleta")) {
            AtualizarEstoqueBike obj = new AtualizarEstoqueBike();
            TelaPrincipal.Addtelaprincipal(obj);
            centralizar(obj);
        }

    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        Object[] categoriaProdutos = {"Motocicleta", "Bicicleta"};
        String res = (String) JOptionPane.showInputDialog(null, "Selecione a categoria do produto:", "Categoria",
                JOptionPane.PLAIN_MESSAGE, null, categoriaProdutos, "");

        if (res.equals("Motocicleta")) {
            TabeladeMoto2 obj = new TabeladeMoto2();
            TelaPrincipal.Addtelaprincipal(obj);
            centralizar(obj);
        } else if (res.equals("Bicicleta")) {
            TabeladeBicicleta2 obj = new TabeladeBicicleta2();
            TelaPrincipal.Addtelaprincipal(obj);
            centralizar(obj);
        }

    }//GEN-LAST:event_jMenuItem9ActionPerformed

    private void menuAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuAEMouseClicked

        Object[] categoriaProdutos = {"Motocicleta", "Bicicleta"};
        String res = (String) JOptionPane.showInputDialog(null, "Selecione a categoria do produto:", "Categoria",
                JOptionPane.PLAIN_MESSAGE, null, categoriaProdutos, "");

        if (res.equals("Motocicleta")) {
            AtualizarEstoqueMoto obj = new AtualizarEstoqueMoto();
            TelaPrincipal.Addtelaprincipal(obj);
            centralizar(obj);
        } else if (res.equals("Bicicleta")) {
            AtualizarEstoqueBike obj = new AtualizarEstoqueBike();
            TelaPrincipal.Addtelaprincipal(obj);
            centralizar(obj);
        }

    }//GEN-LAST:event_menuAEMouseClicked

    private void jLabelAEMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabelAEMouseClicked
        Object[] categoriaProdutos = {"Motocicleta", "Bicicleta"};
        String res = (String) JOptionPane.showInputDialog(null, "Selecione a categoria do produto:", "Categoria",
                JOptionPane.PLAIN_MESSAGE, null, categoriaProdutos, "");

        if (res.equals("Motocicleta")) {
            AtualizarEstoqueMoto obj = new AtualizarEstoqueMoto();
            TelaPrincipal.Addtelaprincipal(obj);
            centralizar(obj);
        } else if (res.equals("Bicicleta")) {
            AtualizarEstoqueBike obj = new AtualizarEstoqueBike();
            TelaPrincipal.Addtelaprincipal(obj);
            centralizar(obj);
        }
    }//GEN-LAST:event_jLabelAEMouseClicked

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        CadastroCliente obj = new CadastroCliente();
        TelaPrincipal.Addtelaprincipal(obj);
        centralizar(obj);
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        Cadastrodepeças obj1 = new Cadastrodepeças();
        TelaPrincipal.Addtelaprincipal(obj1);
        centralizar(obj1);
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        TabelaPreVendas obj = new TabelaPreVendas();
        TelaPrincipal.Addtelaprincipal(obj);
        centralizar(obj);
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    public static void Addtelaprincipal(JInternalFrame iframe) {
        Principal.add(iframe);
        iframe.setVisible(true);
    }

    public static void centralizar(JInternalFrame fr) {
        Dimension d = fr.getDesktopPane().getSize();
        fr.setLocation((d.width - fr.getSize().width) / 2, (d.height - fr.getSize().height) / 2);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(TelaPrincipal.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new TelaPrincipal().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JDesktopPane Principal;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabelAE;
    private javax.swing.JLabel jLabelCC;
    private javax.swing.JLabel jLabelCP;
    private javax.swing.JLabel jLabelRV;
    private javax.swing.JLabel jLabelVR;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenu jMenu5;
    private javax.swing.JMenu jMenu6;
    private javax.swing.JMenu jMenu7;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem13;
    private javax.swing.JMenuItem jMenuItem14;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem17;
    private javax.swing.JMenuItem jMenuItem18;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem20;
    private javax.swing.JMenuItem jMenuItem21;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JLabel menuAE;
    private javax.swing.JLabel menuCC;
    private javax.swing.JLabel menuCP;
    private javax.swing.JLabel menuRV;
    private javax.swing.JLabel menuVR;
    // End of variables declaration//GEN-END:variables
    public void cursorMouse() {
        menuCP.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuCC.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuRV.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuVR.setCursor(new Cursor(Cursor.HAND_CURSOR));
        menuAE.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelCP.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelCC.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelRV.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelVR.setCursor(new Cursor(Cursor.HAND_CURSOR));
        jLabelAE.setCursor(new Cursor(Cursor.HAND_CURSOR));
    }

    public void licenca() {

        try {
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");

            byte[] mensagem = "31/12/2017".getBytes();

            // Usando chave de 128-bits (16 bytes)
            byte[] chave = "edson breno java".getBytes();

            // Encriptando...
            cipher.init(Cipher.ENCRYPT_MODE, new SecretKeySpec(chave, "AES"));
            byte[] encrypted = cipher.doFinal(mensagem);

            String s = new String(encrypted);

            // Decriptando...
            cipher.init(Cipher.DECRYPT_MODE, new SecretKeySpec(chave, "AES"));
            byte[] decrypted = cipher.doFinal(encrypted);

             SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
            
            //RECEBENDO HORA DO SERVIDOR DO MYSQL
            Time t = new Time();
            TimeDao tdao = new TimeDao();
            
            t = tdao.horaMysql();
           
            //
            

            Date dataExpiracao = dateFormat.parse(new String(decrypted));

            String senhaDecriptada = new String(chave);

            if (t.getHoraMysql().after(dataExpiracao)) {

                JOptionPane.showMessageDialog(null, "Sua licença expirou. Por favor, entre em contato com o desenvolvedor. \nContatos: (84)99908-5121 | brenotmv14@gmail.com", "Aviso", JOptionPane.WARNING_MESSAGE);
                JLabel jPassword = new JLabel("Senha:");
                JTextField senha = new JPasswordField();
                Object[] ob = {jPassword, senha};
                int result = JOptionPane.showConfirmDialog(null, ob, "Digite a senha para renovar sua licença:", JOptionPane.OK_CANCEL_OPTION);
                String senhax = senha.getText();

                if (senhax.equals(senhaDecriptada)) {

                    JOptionPane.showMessageDialog(null, "Senha correta");

                } else {

                    JOptionPane.showMessageDialog(null, "Senha incorreta");
                    System.exit(0);
                }

            } else {
                JOptionPane.showMessageDialog(null, "Acesso Liberado.");
            }

        } catch (Exception e) {

            e.printStackTrace();
        }
    }

}
