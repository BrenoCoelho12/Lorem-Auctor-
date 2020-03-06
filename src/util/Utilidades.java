/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.sql.SQLException;
import java.util.List;
import java.util.Vector;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import tcc.apresentacao.ExecutarVenda;
import static tcc.apresentacao.ExecutarVenda.tabelaVendas;
import tcc.apresentacao.MovimentosDiarios;
import static tcc.apresentacao.TabeladeMoto2.tabelaProdutosMoto2;
import tcc.dao.ClienteFisicoDao;
import tcc.dao.MovimentoDiarioDao;
import tcc.dao.ProdutosDao;
import tcc.dominio.ClienteFisico;
import tcc.dominio.MovimentoDiario;
import tcc.dominio.Produtos;
import static tcc.apresentacao.MovimentosDiarios.tabelaMovimentoDiario;


public class Utilidades {
    
    public static void informacoesProdutos(JTable tabela, JLabel descricao, JLabel vCompra, JLabel vRevenda, JLabel vVarejo, JLabel Marca, 
            JLabel localizacao, JLabel qtdEstoque, JLabel unidade, JLabel idProduto){
          
        Produtos p = new Produtos();
        ProdutosDao pdao = new ProdutosDao();
        
        int linha = tabela.getSelectedRow();
        try {
            p = pdao.InformacoesProduto((Integer)tabela.getValueAt(linha, 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        descricao.setText    (p.getNomeProduto());
        vCompra.setText(p.getPrecoDeCompra().toString());
        vRevenda.setText(p.getPrecoRevenda().toString());
        vVarejo.setText(p.getPrecoVarejo().toString());
        Marca.setText(p.getMarca());
        localizacao.setText(p.getLocalizador());
        qtdEstoque.setText(String.valueOf(p.getQuantidadeEstoque()));
        idProduto.setText(String.valueOf(p.getIdProduto()));
        unidade.setText(p.getUnidade());
    }
    
    public static void informacoesProdutos2(JTable tabela, JTextField descricao, JTextField vCompra, JTextField vRevenda, JTextField vVarejo, JTextField Marca, 
            JTextField localizacao, JTextField qtdEstoque, JTextField unidade, JTextField idProduto){
          
        Produtos p = new Produtos();
        ProdutosDao pdao = new ProdutosDao();
        
        int linha = tabela.getSelectedRow();
        try {
            p = pdao.InformacoesProduto((Integer)tabela.getValueAt(linha, 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        descricao.setText    (p.getNomeProduto());
        vCompra.setText(p.getPrecoDeCompra().toString());
        vRevenda.setText(p.getPrecoRevenda().toString());
        vVarejo.setText(p.getPrecoVarejo().toString());
        Marca.setText(p.getMarca());
        localizacao.setText(p.getLocalizador());
        qtdEstoque.setText(String.valueOf(p.getQuantidadeEstoque()));
        unidade.setText(p.getUnidade());
        idProduto.setText(String.valueOf(p.getIdProduto()));
    }
    
    public static void larguraColunasTabelas(JTable tabela){
        tabela.getColumnModel().getColumn(0).setPreferredWidth(10);
        tabela.getColumnModel().getColumn(1).setPreferredWidth(220);
        tabela.getColumnModel().getColumn(2).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(3).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(4).setPreferredWidth(20);
        tabela.getColumnModel().getColumn(5).setPreferredWidth(20);
        tabela.setDefaultEditor(Object.class, null);
       }
    
    public static void informacoesClientePorID(JTable tabela, JLabel estado, JLabel cidade, JLabel endereco, JLabel nome, JLabel cpf, JLabel rgInscricao, 
            JLabel email, JLabel telCelular, JLabel telEmpresarial, JLabel idCliente){
          
        ClienteFisico c = new ClienteFisico();
        ClienteFisicoDao cdao = new ClienteFisicoDao();
        
        int linha = tabela.getSelectedRow();
        try {
            c = cdao.informacoesClientesPorID((Integer)tabela.getValueAt(linha, 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        estado.setText(c.getEstado());
        cidade.setText(c.getCidade());
        endereco.setText(c.getEndereco());
        nome.setText(c.getNome());
        cpf.setText(c.getCpf());
        rgInscricao.setText(c.getRginscricao());
        email.setText(c.getEmail());
        telCelular.setText(c.getT_celular());
        telEmpresarial.setText(c.getT_residencial());
        idCliente.setText(String.valueOf(c.getIdCliente()));
    }
    
     public static void informacoesMovimentacaoDiaria(JTable tabela, JLabel idMovimentacao, JLabel dataMovimentacao,
             JLabel valorDiarioMovimentacao){
          
       MovimentoDiario m = new MovimentoDiario();
       MovimentoDiarioDao mdao = new MovimentoDiarioDao();
        
        int linha = tabela.getSelectedRow();
        try {
            m = mdao.informacoesMovimentacaoDiaria((Integer)tabela.getValueAt(linha, 0));
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        idMovimentacao.setText(String.valueOf(m.getIdMovimento()));
        dataMovimentacao.setText(m.getDataCadastroVarejo());
        valorDiarioMovimentacao.setText(m.getPrecoTotal().toString());
    }
     
     //ESSE MÉTODO VERIFICA AS CONDIÇÕES DO ESTOQUE
    public static void botaoEnterParaAdicionarProduto(JTable tabela, JInternalFrame jif, BigDecimal valorCompra, BigDecimal valorVarejo) {   
        //VERIFICANDO SE O PRODUTO JA EXISTE NA VENDA
       for(int z = 0;z<tabelaVendas.getRowCount();z++){
            int idProdutoNaVenda = (int)tabelaVendas.getValueAt(z, 0);
            int codProduto = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
            if(idProdutoNaVenda == codProduto){
                JOptionPane.showMessageDialog(null, "O produto já existe na venda!");
                return;
        }
    }
       
       //VERIFICANDO SE O ESTOQUE ESTÁ DISPONÍVEL
        String qtd = JOptionPane.showInputDialog(null, "Informe a quantidade desejada", "Informe a quantidade", JOptionPane.INFORMATION_MESSAGE);
        int quantidade = Integer.parseInt(qtd);
        
        int quantidadeEstoque = (int) tabela.getValueAt(tabela.getSelectedRow(), 5);
        if(quantidadeEstoque >= quantidade){
            int quantidadeAtualizada = quantidadeEstoque - quantidade;
            
            Produtos p = new Produtos();
            p.setNomeProduto((String)tabela.getValueAt(tabela.getSelectedRow(), 1));
            p.setPrecoDeCompra(valorCompra);
            p.setPrecoRevenda((BigDecimal)tabela.getValueAt(tabela.getSelectedRow(), 6));
            p.setPrecoVarejo(valorVarejo);
            p.setQuantidadeEstoque(quantidadeAtualizada);
            p.setUnidade((String)tabela.getValueAt(tabela.getSelectedRow(), 3));
            p.setLocalizador((String)tabela.getValueAt(tabela.getSelectedRow(), 4));
            p.setMarca((String)tabela.getValueAt(tabela.getSelectedRow(), 2));
            p.setIdProduto((int)tabela.getValueAt(tabela.getSelectedRow(), 0));
            
            ProdutosDao pdao = new ProdutosDao();
           try {
               pdao.atualizarProduto(p);
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Não foi possível atualizar o estoque no banco de dados. Informe ao desenvolvedor.");
               ex.printStackTrace();
           }
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade no estoque indisponível");
            return;
        }
        
        int[] linhasSelecionadas = tabela.getSelectedRows();
        for (int i = 0; i < linhasSelecionadas.length ; i++) {
            int linha = linhasSelecionadas[i];
            Vector vetor = ((DefaultTableModel) tabela.getModel()).getDataVector();
            ExecutarVenda.addLinha((Vector)vetor.get(linha), quantidade);
            ExecutarVenda.calculaValoresProdutoTabela();
            jif.dispose();
        }
        tabelaVendas.setDefaultEditor(Object.class, null);
       }
    
    public static void botaoEnterParaAdicionarProduto2(JTable tabela, JInternalFrame jif, BigDecimal valorCompra, BigDecimal valorVarejo) {
        //VERIFICANDO SE O PRODUTO JA EXISTE NA VENDA
       for(int z = 0;z<tabelaMovimentoDiario.getRowCount();z++){
            int idProdutoNaVenda = (int)tabelaMovimentoDiario.getValueAt(z, 0);
            int codProduto = (int) tabela.getValueAt(tabela.getSelectedRow(), 0);
            if(idProdutoNaVenda == codProduto){
                JOptionPane.showMessageDialog(null, "O produto já existe na venda!");
                return;
        }
    }
       
       //VERIFICANDO SE O ESTOQUE ESTÁ DISPONÍVEL
        String qtd = JOptionPane.showInputDialog(null, "Informe a quantidade desejada", "Informe a quantidade", JOptionPane.INFORMATION_MESSAGE);
        int quantidade = Integer.parseInt(qtd);
        
        int quantidadeEstoque = (int) tabela.getValueAt(tabela.getSelectedRow(), 5);
        if(quantidadeEstoque >= quantidade){
            int quantidadeAtualizada = quantidadeEstoque - quantidade;
            
            Produtos p = new Produtos();
            p.setNomeProduto((String)tabela.getValueAt(tabela.getSelectedRow(), 1));
            p.setPrecoDeCompra(valorCompra);
            p.setPrecoRevenda((BigDecimal)tabela.getValueAt(tabela.getSelectedRow(), 6));
            p.setPrecoVarejo(valorVarejo);
            p.setQuantidadeEstoque(quantidadeAtualizada);
            p.setUnidade((String)tabela.getValueAt(tabela.getSelectedRow(), 3));
            p.setLocalizador((String)tabela.getValueAt(tabela.getSelectedRow(), 4));
            p.setMarca((String)tabela.getValueAt(tabela.getSelectedRow(), 2));
            p.setIdProduto((int)tabela.getValueAt(tabela.getSelectedRow(), 0));
            
            ProdutosDao pdao = new ProdutosDao();
           try {
               pdao.atualizarProduto(p);
           } catch (SQLException ex) {
               JOptionPane.showMessageDialog(null, "Não foi possível atualizar o estoque no banco de dados. Informe ao desenvolvedor.");
               ex.printStackTrace();
           }
        } else {
            JOptionPane.showMessageDialog(null, "Quantidade no estoque indisponível");
            return;
        }
       
        int[] linhasSelecionadas = tabela.getSelectedRows();
        for (int i = 0; i < linhasSelecionadas.length ; i++) {
            int linha = linhasSelecionadas[i];
            Vector vetor = ((DefaultTableModel) tabela.getModel()).getDataVector();
            MovimentosDiarios.addLinha((Vector)vetor.get(linha), quantidade);
            MovimentosDiarios.calculaValoresProdutoTabela();
            jif.dispose();
        }
       }

       public static void buscarProdutosMoto(String pesquisar, Object[] colunas, JTable tabela ) {
        try {
            ProdutosDao pdao = new ProdutosDao();
            List<Produtos> pesquisarProdutos = pdao.PesquisarProdutosMoto(pesquisar);
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            for (Produtos y : pesquisarProdutos) {
                model.addRow(new Object[] {
                    y.getIdProduto(),
                    y.getNomeProduto(),
                    y.getMarca(),
                    y.getUnidade(),
                    y.getLocalizador(),
                    y.getQuantidadeEstoque(),
                    y.getPrecoRevenda(),
                    y.getPrecoVarejo()
                });
            }
           tabela.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar os Produtos!");
        }
        Utilidades.larguraColunasTabelas(tabela);
    }
       
       public static void buscarProdutosMoto2(String pesquisar, Object[] colunas, JTable tabela ) {
        try {
            ProdutosDao pdao = new ProdutosDao();
            List<Produtos> pesquisarProdutos = pdao.PesquisarProdutosMoto(pesquisar);
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            for (Produtos y : pesquisarProdutos) {
                model.addRow(new Object[] {
                    y.getIdProduto(),
                    y.getNomeProduto(),
                    y.getQuantidadeEstoque(),
                    y.getMarca(),
                    y.getPrecoRevenda(),
                    y.getPrecoVarejo()
                });
            }
           tabela.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar os Produtos!");
        }
        Utilidades.larguraColunasTabelas(tabela);
    }
 
         public static void buscarProdutosBike(String pesquisar, Object[] colunas, JTable tabela ) {
        try {
            ProdutosDao pdao = new ProdutosDao();
            List<Produtos> pesquisarProdutos = pdao.PesquisarProdutosBike(pesquisar);
            DefaultTableModel model = new DefaultTableModel(colunas, 0);
            for (Produtos y : pesquisarProdutos) {
                model.addRow(new Object[] {
                    y.getIdProduto(),
                    y.getNomeProduto(),
                    y.getMarca(),
                    y.getUnidade(),
                    y.getLocalizador(),
                    y.getQuantidadeEstoque(),
                    y.getPrecoRevenda(),
                    y.getPrecoVarejo()
                });
            }
           tabela.setModel(model);
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao listar os Produtos!");
        }
        Utilidades.larguraColunasTabelas(tabela);
    }
         
}
