/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.ClienteFisico;
import tcc.dominio.PreVenda;
import tcc.dominio.Produtos;
import tcc.dominio.ProdutosPreVenda;
import tcc.dominio.TipoProduto;

/**
 *
 * @author Breno-
 */
public class PreVendaDao extends GenericDAO {
    
    public int SalvarPreVenda(PreVenda preVenda) throws SQLException {
        int idVendaGerado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO preVenda (idCliente, dataPreVenda, valorAtual) VALUES (?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1, preVenda.getIdCliente().getIdCliente());
            pstmt.setString(2, preVenda.getDataPreVenda());
            pstmt.setBigDecimal(3, preVenda.getValorAtual());
            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            while (rs.next()) {
                idVendaGerado = rs.getInt(1);
            }
        } finally {
            finishConnection();
        }
        return idVendaGerado;
    }

    public List<PreVenda> listarVendas() throws SQLException {
        List<PreVenda> y = new ArrayList<PreVenda>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT pv.*, cf.* FROM preVenda pv INNER JOIN cliente_fisico cf ON (pv.idCliente = cf.idCliente) ORDER BY nomeCliente ASC;");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ClienteFisico cf = new ClienteFisico();
                cf.setIdCliente(resultSet.getInt("idCliente"));
                cf.setNome(resultSet.getString("nomeCliente"));
                cf.setCpf(resultSet.getString("cpf"));
                cf.setCidade(resultSet.getString("cidade"));
                cf.setEmail(resultSet.getString("email"));
                cf.setEndereco(resultSet.getString("endereco"));
                cf.setEstado(resultSet.getString("estado"));
                cf.setRginscricao(resultSet.getString("rgInscricao"));
                cf.setT_celular(resultSet.getString("tCelular"));
                cf.setT_residencial(resultSet.getString("tResidencial"));
                
                PreVenda pv = new PreVenda();
                pv.setIdPreVenda(resultSet.getInt("idPreVenda"));
                pv.setDataPreVenda(resultSet.getString("dataPreVenda"));
                pv.setValorAtual(resultSet.getBigDecimal("valorAtual"));
                pv.setIdCliente(cf);
                y.add(pv);

            }
        } finally {
            finishConnection();
        }
        return y;

    }
    
    public int apagarPreVenda(int pv) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("DELETE FROM PreVenda WHERE idPreVenda = ?");
            pstmt.setInt(1, pv);
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
     
}
