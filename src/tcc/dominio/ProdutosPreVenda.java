/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dominio;

import java.math.BigDecimal;

/**
 *
 * @author Breno-
 */
public class ProdutosPreVenda {
    int idProdutosPreVenda;
    Produtos produto;
    private PreVenda preVenda;
    private BigDecimal valorRevenda;
    private int quantidade;

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }
    
    public int getIdProdutosPreVenda() {
        return idProdutosPreVenda;
    }

    public void setIdProdutosPreVenda(int idProdutosPreVenda) {
        this.idProdutosPreVenda = idProdutosPreVenda;
    }

    public PreVenda getPreVenda() {
        return preVenda;
    }

    public void setPreVenda(PreVenda preVenda) {
        this.preVenda = preVenda;
    }

    public BigDecimal getValorRevenda() {
        return valorRevenda;
    }

    public void setValorRevenda(BigDecimal valorRevenda) {
        this.valorRevenda = valorRevenda;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    

        
}
