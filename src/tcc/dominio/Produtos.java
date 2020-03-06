/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dominio;

import java.math.BigDecimal;
import java.text.DecimalFormat;



/**
 *
 * @author Breno-
 */
    
public class Produtos {
        
    TipoProduto descricao;
    String nomeProduto;
    BigDecimal precoVarejo;
    BigDecimal precoRevenda;
    BigDecimal precoDeCompra;
    String localizador;
    String marca;
    String unidade;
    int quantidadeEstoque;
    int idProduto;

    public TipoProduto getDescricao() {
        return descricao;
    }

    public void setDescricao(TipoProduto descricao) {
        this.descricao = descricao;
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public BigDecimal getPrecoVarejo() {
        return precoVarejo;
    }

    public void setPrecoVarejo(BigDecimal precoVarejo) {
        this.precoVarejo = precoVarejo;
    }

    public BigDecimal getPrecoRevenda() {
        return precoRevenda;
    }

    public void setPrecoRevenda(BigDecimal precoRevenda) {
        this.precoRevenda = precoRevenda;
    }

    public BigDecimal getPrecoDeCompra() {
        return precoDeCompra;
    }

    public void setPrecoDeCompra(BigDecimal precoDeCompra) {
        this.precoDeCompra = precoDeCompra;
    }

    public String getLocalizador() {
        return localizador;
    }

    public void setLocalizador(String localizador) {
        this.localizador = localizador;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public int getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(int idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return this.getNomeProduto();
    }

}
