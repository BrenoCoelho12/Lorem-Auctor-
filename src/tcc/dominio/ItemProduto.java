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
public class ItemProduto {

    private int id;
    private Produtos produto;
    private Venda venda;
    private BigDecimal valorRevenda;
    private int quantidade;
    private Produtos unidade;
    
    public Produtos getUnidade() {
        return unidade;
    }

    public void setUnidade(Produtos unidade) {
        this.unidade = unidade;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Produtos getProduto() {
        return produto;
    }

    public void setProduto(Produtos produto) {
        this.produto = produto;
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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
