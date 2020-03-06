/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Breno-
 */
public class PreVenda {
    int idPreVenda;
    ClienteFisico idCliente;
    String dataPreVenda;
    BigDecimal valorAtual;
    private List<ProdutosPreVenda> itensProduto = new ArrayList<ProdutosPreVenda>();

        public BigDecimal getValorAtual() {
        return valorAtual;
    }

    public void setValorAtual(BigDecimal valorAtual) {
        this.valorAtual = valorAtual;
    }

    public String getDataPreVenda() {
        return dataPreVenda;
    }

    public void setDataPreVenda(String dataPreVenda) {
        this.dataPreVenda = dataPreVenda;
    }
    
    public List<ProdutosPreVenda> getItensProduto() {
        return itensProduto;
    }

    public void setItensProduto(List<ProdutosPreVenda> itensProduto) {
        this.itensProduto = itensProduto;
    }
    
    public int getIdPreVenda() {
        return idPreVenda;
    }

    public void setIdPreVenda(int idPreVenda) {
        this.idPreVenda = idPreVenda;
    }

    public ClienteFisico getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(ClienteFisico idCliente) {
        this.idCliente = idCliente;
    }
    
    
    
}
