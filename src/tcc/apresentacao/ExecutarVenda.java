/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.apresentacao;

import com.lowagie.text.pdf.Barcode;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import java.beans.PropertyVetoException;
import java.io.FileNotFoundException;
import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Locale;
import java.util.StringTokenizer;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JOptionPane;
import javax.swing.KeyStroke;
import javax.swing.border.BevelBorder;
import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import net.sf.jasperreports.components.barcode4j.BarcodeFillFactory;
import net.sf.jasperreports.engine.JRException;
import org.apache.poi.ss.usermodel.ExcelStyleDateFormatter;
import tcc.dao.ClienteFisicoDao;
import tcc.dao.PreVendaDao;
import tcc.dao.ProdutosDao;
import tcc.dao.ProdutosPreVendaDao;
import tcc.dominio.ClienteFisico;
import tcc.dominio.DetalhamentoConta;
import tcc.dominio.ItemProduto;
import tcc.dominio.Parcelas;
import tcc.dominio.PreVenda;
import tcc.dominio.Produtos;
import tcc.dominio.ProdutosPreVenda;
import tcc.dominio.TipoProduto;
import tcc.dominio.Venda;
import tcc.dominio.Vendedor;
import tcc.negocio.ClienteFisicoController;
import tcc.negocio.DetalhamentoController;
import tcc.negocio.ParcelaController;
import tcc.negocio.PreVendaController;
import tcc.negocio.ProdutosController;
import tcc.negocio.VendaController;
import tcc.negocio.VendedorController;
import tcc.relatorios.PfdVenda;
import util.Utilidades;

/**
 *
 * @author Breno-
 */
public class ExecutarVenda extends javax.swing.JInternalFrame {

    ProdutosController ProdutosController = new ProdutosController();
    ClienteFisicoController ClientefisicoController = new ClienteFisicoController();
    VendedorController vendedorcontroller = new VendedorController();
    VendaController vendaController = new VendaController();
    DetalhamentoController detalhamentocontroller = new DetalhamentoController();
    ParcelaController parcelacontroller = new ParcelaController();
    PreVendaController pcController = new PreVendaController();

    Locale locale = new Locale("pt", "BR");
    GregorianCalendar calendar = new GregorianCalendar();

    SimpleDateFormat formatador = new SimpleDateFormat("dd/MM/yyyy");

    public ExecutarVenda() {
        initComponents();
        situacao.setEnabled(false);
        carregarNomeFuncionarios();
        carregarDescricao();
        carregarClientes();
        utilidades();

        TableModelListener listener;
        listener = new TableModelListener() {
            float soma = 0;
            float valoracrescimo = 0;
            @Override
            public void tableChanged(TableModelEvent e) {

                if (e.getType() == TableModelEvent.UPDATE) {
                    int linha = e.getFirstRow();
                    int coluna = e.getColumn();
                    float valorQtd = Float.parseFloat(tabelaVendas.getModel().getValueAt(linha, 3).toString());
                    float valorRevenda = Float.parseFloat(tabelaVendas.getModel().getValueAt(linha, 2).toString());
                    float subTotal = Float.parseFloat(tabelaVendas.getModel().getValueAt(linha, 4).toString());
                    if (subTotal != valorQtd * valorRevenda) {
                        NumberFormat nf = new DecimalFormat("####.##");
                        nf.setMinimumFractionDigits(2);
                        nf.setMaximumFractionDigits(2);
                        double acrescimoo = 0.00;
                        double desconto = 0.00;
                        acrescimos.setText(String.valueOf(nf.format(acrescimoo).replaceAll(",", ".")));
                        calculaValoresProdutoTabela();
                    }
                }
            }
        };

        tabelaVendas.getModel().addTableModelListener(listener);

    }

    public static void calculaValoresProdutoTabela() {
        NumberFormat df = new DecimalFormat("####.##");
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        float soma = 0F;

        for (int i = 0; i < tabelaVendas.getModel().getRowCount(); i++) {
            float valorQtd = Float.parseFloat(tabelaVendas.getModel().getValueAt(i, 3).toString());
            float valorRevenda = Float.parseFloat(tabelaVendas.getModel().getValueAt(i, 2).toString());
            tabelaVendas.getModel().setValueAt(
                    (float) valorQtd * valorRevenda,
                    i,
                    4);
            Float valor = (Float) tabelaVendas.getValueAt(i, 4);
            soma = soma + valor;
            df.format(soma);

        }
        NumberFormat nf = new DecimalFormat("####.##");
        double acrescimoo = 0.00;

        totalProdutos.setText(String.valueOf(df.format(soma).replaceAll(",", ".")));
        totalBruto.setText(String.valueOf(df.format(soma).replaceAll(",", ".")));
        int nLinhas = tabelaVendas.getRowCount();
        String nLinhasS = Integer.toString(nLinhas);
        nProdutosVenda.setText(nLinhasS);
        acrescimos.setText(String.valueOf(nf.format(acrescimoo).replaceAll(",", ".")));

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        id = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaVendas = new javax.swing.JTable();
        vData = new javax.swing.JFormattedTextField();
        jButton2 = new javax.swing.JButton();
        jLabel21 = new javax.swing.JLabel();
        jButton4 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        observacoes = new javax.swing.JTextArea();
        jLabel22 = new javax.swing.JLabel();
        nProdutosVenda = new javax.swing.JLabel();
        vendedor = new javax.swing.JComboBox();
        jPanel2 = new javax.swing.JPanel();
        jLabel6 = new javax.swing.JLabel();
        pesquisaProduto = new javax.swing.JTextField();
        descricao = new javax.swing.JComboBox();
        idPreVenda = new javax.swing.JLabel();
        jButton3 = new javax.swing.JButton();
        jLayeredPane1 = new javax.swing.JLayeredPane();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        acrescimos = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        volume = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        totalProdutos = new javax.swing.JTextField();
        jLabel24 = new javax.swing.JLabel();
        totalBruto = new javax.swing.JTextField();
        jLabel23 = new javax.swing.JLabel();
        formaPagamento = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        listaClientes = new javax.swing.JComboBox();
        situacao = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Lorem Auctor - Venda");
        addInternalFrameListener(new javax.swing.event.InternalFrameListener() {
            public void internalFrameActivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosed(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameClosing(javax.swing.event.InternalFrameEvent evt) {
                formInternalFrameClosing(evt);
            }
            public void internalFrameDeactivated(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameDeiconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameIconified(javax.swing.event.InternalFrameEvent evt) {
            }
            public void internalFrameOpened(javax.swing.event.InternalFrameEvent evt) {
            }
        });

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel1.setText("Vendedor:");

        tabelaVendas.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        tabelaVendas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cód.", "Produto", "Valor Revenda", "Quantidade", "Subtotal", "Unidade"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.Integer.class, java.lang.Double.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        tabelaVendas.setRowHeight(27);
        tabelaVendas.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                tabelaVendasKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(tabelaVendas);
        if (tabelaVendas.getColumnModel().getColumnCount() > 0) {
            tabelaVendas.getColumnModel().getColumn(0).setMinWidth(40);
            tabelaVendas.getColumnModel().getColumn(0).setPreferredWidth(40);
            tabelaVendas.getColumnModel().getColumn(0).setMaxWidth(40);
            tabelaVendas.getColumnModel().getColumn(2).setMinWidth(150);
            tabelaVendas.getColumnModel().getColumn(2).setPreferredWidth(150);
            tabelaVendas.getColumnModel().getColumn(2).setMaxWidth(150);
            tabelaVendas.getColumnModel().getColumn(3).setMinWidth(70);
            tabelaVendas.getColumnModel().getColumn(3).setPreferredWidth(70);
            tabelaVendas.getColumnModel().getColumn(3).setMaxWidth(70);
            tabelaVendas.getColumnModel().getColumn(4).setMinWidth(70);
            tabelaVendas.getColumnModel().getColumn(4).setPreferredWidth(70);
            tabelaVendas.getColumnModel().getColumn(4).setMaxWidth(70);
            tabelaVendas.getColumnModel().getColumn(5).setMinWidth(70);
            tabelaVendas.getColumnModel().getColumn(5).setPreferredWidth(70);
            tabelaVendas.getColumnModel().getColumn(5).setMaxWidth(70);
        }

        vData.setBackground(new java.awt.Color(255, 255, 204));
        try {
            vData.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        vData.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        vData.setText("  /     /    ");

        jButton2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/13.png"))); // NOI18N
        jButton2.setText("Cadastrar Venda");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel21.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel21.setText("Data:");

        jButton4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/15.png"))); // NOI18N
        jButton4.setText("Remover produto");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        observacoes.setColumns(20);
        observacoes.setRows(5);
        jScrollPane2.setViewportView(observacoes);

        jLabel22.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel22.setText("Nº produtos na venda:");

        nProdutosVenda.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        nProdutosVenda.setText("nº");

        vendedor.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        vendedor.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel6.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/5.png"))); // NOI18N
        jLabel6.setText("Pesquisar:");

        pesquisaProduto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                pesquisaProdutoKeyPressed(evt);
            }
        });

        descricao.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        descricao.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        descricao.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                descricaoKeyPressed(evt);
            }
        });

        idPreVenda.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        idPreVenda.setText("-");

        jButton3.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/12.png"))); // NOI18N
        jButton3.setText("Abrir pré-venda");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(descricao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addComponent(jButton3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(idPreVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel6)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel2Layout.createSequentialGroup()
                        .addGap(2, 2, 2)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(pesquisaProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(descricao)
                                .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(idPreVenda, javax.swing.GroupLayout.PREFERRED_SIZE, 21, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jLayeredPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel16.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel16.setText("Acrescimo:");

        acrescimos.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        acrescimos.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                acrescimosFocusLost(evt);
            }
        });
        acrescimos.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                acrescimosKeyReleased(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel4.setText("Volumes:");

        volume.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        volume.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                volumeKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel16)
                        .addGap(22, 22, 22)
                        .addComponent(acrescimos))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 31, Short.MAX_VALUE)
                        .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(acrescimos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(volume, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addContainerGap(42, Short.MAX_VALUE))
        );

        jLabel20.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel20.setText("Total Líquido:");

        jLabel24.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel24.setText("Total Bruto:");

        jLayeredPane1.setLayer(jPanel3, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel20, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(totalProdutos, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(jLabel24, javax.swing.JLayeredPane.DEFAULT_LAYER);
        jLayeredPane1.setLayer(totalBruto, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jLayeredPane1Layout = new javax.swing.GroupLayout(jLayeredPane1);
        jLayeredPane1.setLayout(jLayeredPane1Layout);
        jLayeredPane1Layout.setHorizontalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel20)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jLayeredPane1Layout.createSequentialGroup()
                        .addComponent(jLabel24)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(totalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        jLayeredPane1Layout.setVerticalGroup(
            jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jLayeredPane1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20)
                    .addComponent(totalProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jLayeredPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel24)
                    .addComponent(totalBruto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 12, Short.MAX_VALUE))
        );

        jLabel23.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel23.setText("Forma de Pagamento:");

        formaPagamento.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        formaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " ", "15", "29", "30", "34", "35", "45", "60", "75", "90", "105", "120", "15/30", "29/44", "15/30/45", "15/30/45/60", "15/30/45/60/75", "30/45/60/75", "30/45", "30/60", "30/45/60", "15/30/45/60/75/90", "15/30/45/60/75/90/105", "15/30/45/60/75/90/105/120", "29/44/59/69" }));
        formaPagamento.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel2.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jLabel2.setText("Informe o Cliente:");

        listaClientes.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        listaClientes.setModel(new javax.swing.DefaultComboBoxModel(new String[] { " " }));
        listaClientes.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jButton1.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/icones/9.png"))); // NOI18N
        jButton1.setText("Arquivar Venda");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jButton4)
                                .addGap(91, 91, 91)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel23)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(formaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel22)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(nProdutosVenda)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 99, Short.MAX_VALUE)
                        .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane1)
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel1))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, 219, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(listaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jLabel21)
                        .addGap(26, 26, 26)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(vData, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(situacao, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(2, 2, 2)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(vData, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel21))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(listaClientes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(vendedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(situacao, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, 55, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 246, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel23)
                                    .addComponent(formaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel22)
                                        .addComponent(nProdutosVenda))
                                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLayeredPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(22, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(id))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(185, 185, 185)
                .addComponent(id)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (tabelaVendas.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Insira um produto na venda!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }
        if (listaClientes.getSelectedItem().toString().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe um Cliente para a venda!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (formaPagamento.getSelectedItem().toString().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe uma forma de pagamento válida!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (volume.getText().equals("0") || volume.getText().equals("")) {
            JOptionPane.showMessageDialog(null, "A quantidade de Volumes está incorreta!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        Date data = new Date();
        String dataformatada = formatador.format(data);

        String dia = vData.getText().substring(0, 2);
        String mes = vData.getText().substring(3, 5);
        String ano = vData.getText().substring(6);

        double Pago = 0.00;
        BigDecimal totalPago = new BigDecimal(Pago);

        ClienteFisico cf = new ClienteFisico();
        ClienteFisicoDao cdao = new ClienteFisicoDao();

        try {
            cf = cdao.informacoesClientes(listaClientes.getSelectedItem().toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        System.out.println(cf.getIdCliente());
        cf.setIdCliente(cf.getIdCliente());
        System.out.println(cf.getIdCliente());
        cf.setNome(cf.getNome());
        cf.setCidade(cf.getCidade());
        cf.setCpf(cf.getCpf());
        cf.setEmail(cf.getEmail());
        cf.setEndereco(cf.getEndereco());
        cf.setEstado(cf.getEstado());
        cf.setRginscricao(cf.getRginscricao());
        cf.setT_celular(cf.getT_celular());
        cf.setT_residencial(cf.getT_residencial());

        Venda venda = new Venda();

        for (int i = 0; i < tabelaVendas.getModel().getRowCount(); i++) {
            Produtos produto = new Produtos();
            produto.setIdProduto(Integer.parseInt(tabelaVendas.getModel().getValueAt(i, 0).toString()));
            produto.setNomeProduto((tabelaVendas.getModel().getValueAt(i, 1).toString()));
            produto.setUnidade(tabelaVendas.getModel().getValueAt(i, 5).toString());

            ItemProduto ip = new ItemProduto();
            ip.setProduto(produto);
            ip.setValorRevenda(new BigDecimal(tabelaVendas.getModel().getValueAt(i, 2).toString()));
            ip.setQuantidade(Integer.parseInt(tabelaVendas.getModel().getValueAt(i, 3).toString()));
            ip.setUnidade(produto);
            venda.getItensProduto().add(ip);
        }

        BigDecimal acrescimox = new BigDecimal(acrescimos.getText().trim());
        BigDecimal totalLiquido = new BigDecimal(totalProdutos.getText().trim());
        BigDecimal totalCompra = new BigDecimal(totalBruto.getText().trim());
        int qtd_volume = Integer.parseInt(volume.getText().trim());
        String formaPagamentoVenda = formaPagamento.getSelectedItem().toString();
        if(formaPagamentoVenda.equals("À vista")){
            formaPagamentoVenda = "0";
        }
        Vendedor vendedorx = (Vendedor) vendedor.getSelectedItem();

        DetalhamentoConta dc = new DetalhamentoConta();

        dc.setCliente(cf);
        dc.setValor(totalCompra);
        dc.setData(dataformatada);
        dc.setObservação("NOVA COMPRA");
        dc.setFormaPagamento(formaPagamentoVenda);
        dc.setSituacao("EM ABERTO");
        dc.setDatasVencimento(formaPagamentoVenda);
        dc.setValorPago(totalPago);
        dc.setSaldoDevedor(totalCompra);
        venda.getDetalhamentoConta().add(dc);

        venda.setVendedor(vendedorx);
        venda.setClienteFisico(cf);
        venda.setTotal(totalLiquido);
        venda.setDataVenda(ano + "-" + mes + "-" + dia);
        venda.setAcrescimos(acrescimox);
        venda.setObservacoes(observacoes.getText().trim());
        venda.setQtdVolume(qtd_volume);
        venda.setSituacao(situacao.getText().trim());
        venda.setTotalCompra(totalCompra);
        venda.setTotalRestante(totalCompra);
        venda.setTotalPago(totalPago);
        venda.setFormaPagamento(formaPagamentoVenda);
        System.out.println("formaPagamentoVenda");

        try {
            vendaController.cadastrarVenda(venda);
            JOptionPane.showMessageDialog(null, "Venda cadastrada com sucesso!");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "A venda não foi cadastrada, tente novamente!");
        }

        try {
            JOptionPane.showMessageDialog(null, "Gerando PDF...");
            PfdVenda.gerarRelatorio(venda, "RelatorioVenda");
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "");
        } catch (JRException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "");
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "");
        }

        JOptionPane.showMessageDialog(null, "Cadastre as parcelas da venda...");
        CadastrarParcelamentoVendas obj = new CadastrarParcelamentoVendas();
        TelaPrincipal.Addtelaprincipal(obj);

        int result = JOptionPane.showConfirmDialog(null, "Deseja Realizar uma nova Venda?");
        if (result == JOptionPane.OK_OPTION) {
            fechar();
            abrirNovamente();
        } else {
            dispose();
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        Produtos p = new Produtos();
        ProdutosDao pdao = new ProdutosDao();
        int linhaSelecionada = tabelaVendas.getSelectedRow();
        try {
            p = pdao.receberQuantidadeEstoqueProduto((int) tabelaVendas.getValueAt(linhaSelecionada, 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        int quantidadeEstoque = p.getQuantidadeEstoque();
        int quantidadeDevolver = (int) tabelaVendas.getValueAt(linhaSelecionada, 3);
        int quantidadeAtualizada = quantidadeEstoque + quantidadeDevolver;

        p.setIdProduto(p.getIdProduto());
        p.setLocalizador(p.getLocalizador());
        p.setMarca(p.getMarca());
        p.setNomeProduto(p.getNomeProduto());
        p.setPrecoDeCompra(p.getPrecoDeCompra());
        p.setPrecoRevenda(p.getPrecoRevenda());
        p.setPrecoVarejo(p.getPrecoVarejo());
        p.setQuantidadeEstoque(quantidadeAtualizada);
        p.setUnidade(p.getUnidade());

        try {
            pdao.atualizarProduto(p);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possível atualizar o estoque. Entre em contato com o desenvolvedor.");
        }
        ((DefaultTableModel) tabelaVendas.getModel()).removeRow(linhaSelecionada);

        calculaValoresProdutoTabela();
        JOptionPane.showMessageDialog(null, "Produto removido!");


    }//GEN-LAST:event_jButton4ActionPerformed

    private void acrescimosFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_acrescimosFocusLost
        NumberFormat df = new DecimalFormat("####.##");
        df.setMaximumFractionDigits(2);
        df.setMinimumFractionDigits(2);
        float valorAcrescimo = Float.parseFloat(acrescimos.getText());
        float valorCompra = Float.parseFloat(totalProdutos.getText());
        float valorTotalCompra = valorAcrescimo + valorCompra;
        acrescimos.setText(String.valueOf(df.format(valorAcrescimo).replaceAll(",", ".")));
        totalBruto.setText(String.valueOf(df.format(valorTotalCompra).replaceAll(",", ".")));

    }//GEN-LAST:event_acrescimosFocusLost

    private void acrescimosKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acrescimosKeyReleased

        if ((evt.getKeyCode() < 48 || evt.getKeyCode() > 58) && (evt.getKeyCode() != 8 && evt.getKeyCode() != 46)) {
            if (evt.getKeyCode() < 96 || evt.getKeyCode() > 105) {
                if (acrescimos.getText().length() > 0) {
                    acrescimos.setText(acrescimos.getText().
                            substring(0, acrescimos.getText().length() - 1));
                }
            }
        }
        if (evt.getKeyCode() == 44 || evt.getKeyCode() == 110) {
            acrescimos.setText(acrescimos.getText() + ".");
        }

    }//GEN-LAST:event_acrescimosKeyReleased

    private void formInternalFrameClosing(javax.swing.event.InternalFrameEvent evt) {//GEN-FIRST:event_formInternalFrameClosing
        int resultado = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja Sair?");

        if (resultado == JOptionPane.OK_OPTION) {

            if (tabelaVendas.getRowCount() == 0) {
                dispose();
            } else if (!idPreVenda.getText().equals("-")) {
                dispose();
            } else {
                JOptionPane.showMessageDialog(null, "Remova todos os itens da venda antes de fechar.");
            }
        }
    }//GEN-LAST:event_formInternalFrameClosing

    private void tabelaVendasKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_tabelaVendasKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_DELETE) {

            int linhaselecionada = tabelaVendas.getSelectedRow();
            ((DefaultTableModel) tabelaVendas.getModel()).removeRow(linhaselecionada);

            calculaValoresProdutoTabela();
            JOptionPane.showMessageDialog(null, "Produto removido!");

        }
    }//GEN-LAST:event_tabelaVendasKeyPressed

    private void pesquisaProdutoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_pesquisaProdutoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            abrirTabelaProdutos();
        }
    }//GEN-LAST:event_pesquisaProdutoKeyPressed

    private void descricaoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_descricaoKeyPressed
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            abrirTabelaProdutos();
        }
    }//GEN-LAST:event_descricaoKeyPressed

    private void volumeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_volumeKeyTyped
        String caracteres = "0123456789";
        if (!caracteres.contains(evt.getKeyChar() + "")) {
            evt.consume();
        }

    }//GEN-LAST:event_volumeKeyTyped

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        if (tabelaVendas.getRowCount() == 0) {
            JOptionPane.showMessageDialog(null, "Insira um produto na venda!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (listaClientes.getSelectedItem().toString().equals(" ")) {
            JOptionPane.showMessageDialog(null, "Informe um Cliente para a venda!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return;
        }

        //VERIFICANDO SE É UMA NOVA PRE-VENDA
        if (idPreVenda.getText().equals("-")) {

            String dia = vData.getText().substring(0, 2);
            String mes = vData.getText().substring(3, 5);
            String ano = vData.getText().substring(6);

            ClienteFisico cf = new ClienteFisico();
            ClienteFisicoDao cdao = new ClienteFisicoDao();

            try {
                cf = cdao.informacoesClientes(listaClientes.getSelectedItem().toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            cf.setIdCliente(cf.getIdCliente());
            cf.setNome(cf.getNome());
            cf.setCidade(cf.getCidade());
            cf.setCpf(cf.getCidade());
            cf.setEmail(cf.getEmail());
            cf.setEndereco(cf.getEndereco());
            cf.setEstado(cf.getEstado());
            cf.setRginscricao(cf.getRginscricao());
            cf.setT_celular(cf.getT_celular());
            cf.setT_residencial(cf.getT_residencial());

            PreVenda preVenda = new PreVenda();

            for (int i = 0; i < tabelaVendas.getModel().getRowCount(); i++) {
                Produtos produto = new Produtos();
                produto.setIdProduto(Integer.parseInt(tabelaVendas.getModel().getValueAt(i, 0).toString()));
                produto.setNomeProduto((tabelaVendas.getModel().getValueAt(i, 1).toString()));
                produto.setUnidade(tabelaVendas.getModel().getValueAt(i, 5).toString());

                ProdutosPreVenda ppv = new ProdutosPreVenda();
                ppv.setProduto(produto);
                ppv.setValorRevenda(new BigDecimal(tabelaVendas.getModel().getValueAt(i, 2).toString()));
                ppv.setQuantidade(Integer.parseInt(tabelaVendas.getModel().getValueAt(i, 3).toString()));
                preVenda.getItensProduto().add(ppv);
            }

            preVenda.setIdCliente(cf);
            preVenda.setDataPreVenda(ano + "-" + mes + "-" + dia);
            preVenda.setValorAtual(new BigDecimal(totalProdutos.getText().trim()));
            try {
                pcController.salvarPreVenda(preVenda);
                JOptionPane.showMessageDialog(null, "Pré-Venda arquivada com sucesso.");
                opcaoPosVenda();
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ExecutarVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        } 

        //EXISTE UMA PRE-VENDA ABERTA PARA SER "ATUALIZADA"
        else {
            ProdutosPreVendaDao ppvdao = new ProdutosPreVendaDao();
            PreVendaDao pvdao = new PreVendaDao();
            //APAGANDO PRE-VENDA
            try {
                ppvdao.apagarProdutosPreVenda(Integer.parseInt(idPreVenda.getText().trim()));
                pvdao.apagarPreVenda(Integer.parseInt(idPreVenda.getText().trim()));
            } catch (SQLException ex) {
                Logger.getLogger(ExecutarVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
            //CRIANDO (ATUALIZANDO) PRE-VENDA

            String dia = vData.getText().substring(0, 2);
            String mes = vData.getText().substring(3, 5);
            String ano = vData.getText().substring(6);

            ClienteFisico cf = new ClienteFisico();
            ClienteFisicoDao cdao = new ClienteFisicoDao();

            try {
                cf = cdao.informacoesClientes(listaClientes.getSelectedItem().toString());
            } catch (SQLException ex) {
                ex.printStackTrace();
            }

            cf.setIdCliente(cf.getIdCliente());
            cf.setNome(cf.getNome());
            cf.setCidade(cf.getCidade());
            cf.setCpf(cf.getCidade());
            cf.setEmail(cf.getEmail());
            cf.setEndereco(cf.getEndereco());
            cf.setEstado(cf.getEstado());
            cf.setRginscricao(cf.getRginscricao());
            cf.setT_celular(cf.getT_celular());
            cf.setT_residencial(cf.getT_residencial());

            PreVenda preVenda = new PreVenda();

            for (int i = 0; i < tabelaVendas.getModel().getRowCount(); i++) {
                Produtos produto = new Produtos();
                produto.setIdProduto(Integer.parseInt(tabelaVendas.getModel().getValueAt(i, 0).toString()));
                produto.setNomeProduto((tabelaVendas.getModel().getValueAt(i, 1).toString()));
                produto.setUnidade(tabelaVendas.getModel().getValueAt(i, 5).toString());

                ProdutosPreVenda ppv = new ProdutosPreVenda();
                ppv.setProduto(produto);
                ppv.setValorRevenda(new BigDecimal(tabelaVendas.getModel().getValueAt(i, 2).toString()));
                ppv.setQuantidade(Integer.parseInt(tabelaVendas.getModel().getValueAt(i, 3).toString()));
                preVenda.getItensProduto().add(ppv);
            }

            preVenda.setIdCliente(cf);
            preVenda.setDataPreVenda(ano + "-" + mes + "-" + dia);
            preVenda.setValorAtual(new BigDecimal(totalProdutos.getText().trim()));
            try {
                pcController.salvarPreVenda(preVenda);
                JOptionPane.showMessageDialog(null, "Pré-Venda atualizada com sucesso.");
                opcaoPosVenda();
                this.dispose();
            } catch (SQLException ex) {
                Logger.getLogger(ExecutarVenda.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        TabelaPreVendas obj = new TabelaPreVendas();
        TelaPrincipal.Addtelaprincipal(obj);
        TelaPrincipal.centralizar(obj);
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private static javax.swing.JTextField acrescimos;
    private javax.swing.JComboBox descricao;
    public static javax.swing.JComboBox formaPagamento;
    private static javax.swing.JLabel id;
    public static javax.swing.JLabel idPreVenda;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLayeredPane jLayeredPane1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private static javax.swing.JComboBox listaClientes;
    public static javax.swing.JLabel nProdutosVenda;
    private javax.swing.JTextArea observacoes;
    public static javax.swing.JTextField pesquisaProduto;
    private javax.swing.JTextField situacao;
    public static javax.swing.JTable tabelaVendas;
    private static javax.swing.JTextField totalBruto;
    private static javax.swing.JTextField totalProdutos;
    private javax.swing.JFormattedTextField vData;
    private javax.swing.JComboBox vendedor;
    private javax.swing.JTextField volume;
    // End of variables declaration//GEN-END:variables

    public static void addLinha(Vector v, int quantidade) {
        ((DefaultTableModel) tabelaVendas.getModel()).addRow(new Object[]{
            v.elementAt(0),
            v.elementAt(1),
            v.elementAt(6),
            quantidade,
            0,
            v.elementAt(3)
        });

    }

    private void carregarDescricao() {
        try {
            List<TipoProduto> produtos = ProdutosController.listarDescricao();
            for (TipoProduto produto : produtos) {

                descricao.addItem(produto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel mostrar os produtos!");

        }
    }

    private void fechar() {
        dispose();
    }

    private void abrirNovamente() {
        ExecutarVenda obj13 = new ExecutarVenda();
        TelaPrincipal.Addtelaprincipal(obj13);
        TelaPrincipal.centralizar(obj13);
    }

    private void carregarNomeFuncionarios() {
        try {
            List<Vendedor> produtos = vendedorcontroller.listarnomeVendedores();
            for (Vendedor produto : produtos) {

                vendedor.addItem(produto);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel mostrar os Funcionarios!");
            ex.printStackTrace();
        }
    }

    private void carregarClientes() {
        try {
            List<ClienteFisico> clientes = ClientefisicoController.listarClientes();
            for (ClienteFisico cliente : clientes) {

                listaClientes.addItem(cliente);
            }
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Não foi possivel mostrar os produtos!");

        }
    }

    private void utilidades() {
        tabelaVendas.setDefaultEditor(Object.class, null);
        situacao.setText("EM ABERTO");
        vData.setText(formatador.format(calendar.getTime()));
        vData.setEnabled(false);
        observacoes.setFont(new Font("Times New Roman", Font.CENTER_BASELINE, 14));
        observacoes.setText("Observações:");
        observacoes.setBorder(new BevelBorder(BevelBorder.RAISED));
        totalProdutos.setFont(new Font("Times New Roman", Font.BOLD, 14));
        totalProdutos.setForeground(Color.BLUE);
        acrescimos.setForeground(Color.RED);
        acrescimos.setFont(new Font("Times New Roman", Font.BOLD, 14));
        volume.setForeground(Color.BLACK);
        volume.setFont(new Font("Times New Roman", Font.BOLD, 14));

    }

    public void abrirTabelaProdutos() {
        String tipoProduto = descricao.getSelectedItem().toString();

        if (tipoProduto.equals("Motocicleta")) {
            TabeladeMoto2 tbm = new TabeladeMoto2();
            TelaPrincipal.Addtelaprincipal(tbm);
            TelaPrincipal.centralizar(tbm);
            TabeladeMoto2.pesquisarProduto(pesquisaProduto.getText());
        } else if (tipoProduto.equals("Bicicleta")) {
            TabeladeBicicleta2 tbb = new TabeladeBicicleta2();
            TelaPrincipal.Addtelaprincipal(tbb);
            TelaPrincipal.centralizar(tbb);
            TabeladeBicicleta2.pesquisarProduto(pesquisaProduto.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Selecione o tipo do produto ao lado.");
        }

    }

    public static void receberIdPreVenda(int idPVenda, String cliente, BigDecimal valorVenda) {

        idPreVenda.setText(String.valueOf(idPVenda));
        listaClientes.getModel().setSelectedItem(cliente);
        totalProdutos.setText(String.valueOf(valorVenda));
    }

    private void opcaoPosVenda() {
        int result = JOptionPane.showConfirmDialog(null, "Deseja Realizar uma nova Venda?");
        if (result == JOptionPane.OK_OPTION) {
            fechar();
            abrirNovamente();
        } else {
            dispose();
        }
    }
    
    public static void receberNovoPrazo(JComboBox jcb, String prazo){
        jcb.addItem(prazo);
        jcb.getModel().setSelectedItem(prazo);
    }
}
