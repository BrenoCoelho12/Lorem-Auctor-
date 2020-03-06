/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tcc.dominio;

/**
 *
 * @author Breno-
 */
public class ClienteFisico {
    
    private Integer idCliente;
    private String nome;
    private String email;
    private String cidade;
    private String estado;
    private String endereco;
    private String t_celular;
    private String t_residencial;
    private String cpf;
    private String rginscricao;
    private String bairro;
    private String numero;
    private String complemento;
    private String observacao;

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getT_celular() {
        return t_celular;
    }

    public void setT_celular(String t_celular) {
        this.t_celular = t_celular;
    }

    public String getT_residencial() {
        return t_residencial;
    }

    public void setT_residencial(String t_residencial) {
        this.t_residencial = t_residencial;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRginscricao() {
        return rginscricao;
    }

    public void setRginscricao(String rginscricao) {
        this.rginscricao = rginscricao;
    }

    
    
 @Override
    public String toString() {
        return this.getNome();
    }
    
    
}
