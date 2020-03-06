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
public class MovimentoDiario {
    
    private int idMovimento;
    private BigDecimal precoTotal;
    private String dataCadastroVarejo;
    
    public String getDataCadastroVarejo() {
        return dataCadastroVarejo;
    }

    public void setDataCadastroVarejo(String dataCadastroVarejo) {
        this.dataCadastroVarejo = dataCadastroVarejo;
    }
    
    public int getIdMovimento() {
        return idMovimento;
    }

    public void setIdMovimento(int idMovimento) {
        this.idMovimento = idMovimento;
    }

    public BigDecimal getPrecoTotal() {
        return precoTotal;
    }

    public void setPrecoTotal(BigDecimal precoTotal) {
        this.precoTotal = precoTotal;
    }
    
}
