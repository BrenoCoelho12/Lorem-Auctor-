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
public class DetalhamentoConta {
    
    private int idDetalhamento;
    private Venda venda;
    private ClienteFisico cliente;
    private Parcelas parcela;
    private String data;
    private String observação;
    private BigDecimal valor;
    private BigDecimal valorPago;
    private BigDecimal valorCompras;
    private BigDecimal saldoDevedor;
    private String formaPagamento;
    private String datasVencimento;
    private String situacao;
    
    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }
    
    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    

    public String getDatasVencimento() {
        return datasVencimento;
    }

    public void setDatasVencimento(String datasVencimento) {
        this.datasVencimento = datasVencimento;
    }
    
    
    public Parcelas getParcela() {
        return parcela;
    }

    public void setParcela(Parcelas parcela) {
        this.parcela = parcela;
    }
    
    public BigDecimal getValorPago() {
        return valorPago;
    }

    public void setValorPago(BigDecimal valorPago) {
        this.valorPago = valorPago;
    }

    public BigDecimal getValorCompras() {
        return valorCompras;
    }

    public void setValorCompras(BigDecimal valorCompras) {
        this.valorCompras = valorCompras;
    }

    public BigDecimal getSaldoDevedor() {
        return saldoDevedor;
    }

    public void setSaldoDevedor(BigDecimal saldoDevedor) {
        this.saldoDevedor = saldoDevedor;
    }
    
    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
    }
    
    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public int getIdDetalhamento() {
        return idDetalhamento;
    }

    public void setIdDetalhamento(int idDetalhamento) {
        this.idDetalhamento = idDetalhamento;
    }

    public ClienteFisico getCliente() {
        return cliente;
    }

    public void setCliente(ClienteFisico cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getObservação() {
        return observação;
    }

    public void setObservação(String observação) {
        this.observação = observação;
    }
    
}
