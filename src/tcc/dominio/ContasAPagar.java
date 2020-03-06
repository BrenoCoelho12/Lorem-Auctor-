/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dominio;

import java.math.BigDecimal;
import java.util.Date;




/**
 *
 * @author Breno-
 */
public class ContasAPagar {
    
    private int idConta;
    private BigDecimal valor;
    private String dataVencimento;
    private FormaPagamento formaPagamento;
    private String empresa;
    private String dataCheque;
    private String contaBancaria;
    private String situacaoConta;

    public int getIdConta() {
        return idConta;
    }

    public void setIdConta(int idConta) {
        this.idConta = idConta;
    }

    public BigDecimal getValor() {
        return valor;
    }

    public void setValor(BigDecimal valor) {
        this.valor = valor;
    }

    public String getDataVencimento() {
        return dataVencimento;
    }

    public void setDataVencimento(String dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getEmpresa() {
        return empresa;
    }

    public void setEmpresa(String empresa) {
        this.empresa = empresa;
    }

    public String getDataCheque() {
        return dataCheque;
    }

    public void setDataCheque(String dataCheque) {
        this.dataCheque = dataCheque;
    }

    public String getContaBancaria() {
        return contaBancaria;
    }

    public void setContabancaria(String contaBancaria) {
        this.contaBancaria = contaBancaria;
    }

    public String getSituacaoConta() {
        return situacaoConta;
    }

    public void setSituacaoConta(String situacaoConta) {
        this.situacaoConta = situacaoConta;
    }

    
    
}
