/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import tcc.dominio.ClienteFisico;

/**
 *
 * @author Breno-
 */
public class ClienteFisicoDao extends GenericDAO {
    
   public int adicionarCliente(ClienteFisico cliente) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("INSERT INTO Cliente_fisico (nomeCliente, email, cidade, estado, endereco, tCelular, tResidencial, cpf, rgInscricao, bairro, complemento, numero, observacao) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)");
            pstmt.setString(1, cliente.getNome());
            pstmt.setString(2, cliente.getEmail());
            pstmt.setString(3, cliente.getCidade());
            pstmt.setString(4, cliente.getEstado());
            pstmt.setString(5, cliente.getEndereco());
            pstmt.setString(6, cliente.getT_celular());
            pstmt.setString(7, cliente.getT_residencial());
            pstmt.setString(8, cliente.getCpf());
            pstmt.setString(9, cliente.getRginscricao());
            pstmt.setString(10, cliente.getBairro());
            pstmt.setString(11, cliente.getComplemento());
            pstmt.setString(12, cliente.getNumero());
            pstmt.setString(13, cliente.getObservacao());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
   
public List<ClienteFisico> listarClientes() throws SQLException {
        List<ClienteFisico> x = new ArrayList<ClienteFisico>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM cliente_fisico ORDER BY nomeCliente ASC");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ClienteFisico y = new ClienteFisico();
                
                y.setIdCliente(resultSet.getInt("idCliente"));
                y.setNome(resultSet.getString("nomeCliente"));
                y.setCidade(resultSet.getString("cidade"));
                y.setEstado(resultSet.getString("estado"));
                y.setEndereco(resultSet.getString("endereco"));
                y.setT_celular(resultSet.getString("tCelular"));
                y.setT_residencial(resultSet.getString("tResidencial"));
                y.setEmail(resultSet.getString("email"));
                y.setCpf(resultSet.getString("cpf"));
                y.setRginscricao(resultSet.getString("rgInscricao"));
                x.add(y);
            }
        } finally {
            finishConnection();
        }
        return x;
    }

    public List<ClienteFisico> buscarClientes(String pesquisar) throws SQLException {
        List<ClienteFisico> x = new ArrayList<ClienteFisico>();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM cliente_fisico WHERE nomeCliente LIKE ? ORDER BY nomeCliente ASC");
            pstmt.setString(1, "%"+pesquisar+"%");
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                ClienteFisico y = new ClienteFisico();
                
                y.setIdCliente(resultSet.getInt("idCliente"));
                y.setNome(resultSet.getString("nomeCliente"));
                y.setCidade(resultSet.getString("cidade"));
                y.setEstado(resultSet.getString("estado"));
                y.setEndereco(resultSet.getString("endereco"));
                y.setT_celular(resultSet.getString("tCelular"));
                y.setT_residencial(resultSet.getString("tResidencial"));
                y.setEmail(resultSet.getString("email"));
                y.setCpf(resultSet.getString("cpf"));
                y.setRginscricao(resultSet.getString("rgInscricao"));
                x.add(y);
            }
        } finally {
            finishConnection();
        }
        return x;
    }
    
    //CRIEI ESSE MÉTODO PARA USAR EM EXECUTAR VENDA PARA QUE SEJA POSSÍVEL BUSCAR AS INFORMAÇÕES
    //DOS CLIENTES ATRAVÉS DO SEU NOME
        public ClienteFisico informacoesClientes(String pesquisar) throws SQLException {
        ClienteFisico y = new ClienteFisico();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM cliente_fisico WHERE nomeCliente = ?");
            pstmt.setString(1, pesquisar);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                
                y.setIdCliente(resultSet.getInt("idCliente"));
                y.setNome(resultSet.getString("nomeCliente"));
                y.setCidade(resultSet.getString("cidade"));
                y.setEstado(resultSet.getString("estado"));
                y.setEndereco(resultSet.getString("endereco"));
                y.setT_celular(resultSet.getString("tCelular"));
                y.setT_residencial(resultSet.getString("tResidencial"));
                y.setEmail(resultSet.getString("email"));
                y.setCpf(resultSet.getString("cpf"));
                y.setRginscricao(resultSet.getString("rgInscricao"));
            }
        } finally {
            finishConnection();
        }
        return y;
    }
        //CRIEI ESSE MÉTODO PARA SER USADO NA TABELA DE CLIENTES, PARA QUE SEJA POSSÍVEL EU BUSCAR OS CLIENTES
        //PELO ID E SETAR SUAS INFORMAÇÕES EM JLABEL.
        public ClienteFisico informacoesClientesPorID(int idCliente) throws SQLException {
        ClienteFisico y = new ClienteFisico();
        try {
            getConnection();
            pstmt = connection.prepareStatement("SELECT * FROM cliente_fisico WHERE idCliente = ?");
            pstmt.setInt(1, idCliente);
            resultSet = pstmt.executeQuery();
            while (resultSet.next()) {
                
                y.setIdCliente(resultSet.getInt("idCliente"));
                y.setNome(resultSet.getString("nomeCliente"));
                y.setCidade(resultSet.getString("cidade"));
                y.setEstado(resultSet.getString("estado"));
                y.setEndereco(resultSet.getString("endereco"));
                y.setT_celular(resultSet.getString("tCelular"));
                y.setT_residencial(resultSet.getString("tResidencial"));
                y.setEmail(resultSet.getString("email"));
                y.setCpf(resultSet.getString("cpf"));
                y.setRginscricao(resultSet.getString("rgInscricao"));
            }
        } finally {
            finishConnection();
        }
        return y;
    }
        
    public int apagarCliente(ClienteFisico cliente) throws SQLException {
        int resultado = 0;
        try {
            getConnection();
            pstmt = connection.prepareStatement("DELETE FROM cliente_fisico WHERE idCliente = ?");
            pstmt.setInt(1, cliente.getIdCliente());
            resultado = pstmt.executeUpdate();
        } finally {
            finishConnection();
        }
        return resultado;
    }
 
}
