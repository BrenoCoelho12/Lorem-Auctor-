package tcc.dominio;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class Venda {
 
    private int idVenda;
    private String dataVenda;
    private String formaPagamento;
    private String observacoes;
    private BigDecimal acrescimos;
    private BigDecimal total;
    private BigDecimal totalCompra;
    private BigDecimal totalConta;
    private BigDecimal totalRestante;
    private BigDecimal totalPago;
    private int qtdVolume;
    private Vendedor vendedor;
    private ClienteFisico clienteFisico;
    private List<ItemProduto> itensProduto = new ArrayList<ItemProduto>();
    private List<DetalhamentoConta> detalhamentoConta = new ArrayList<DetalhamentoConta>();
    private List<Parcelas> parcelas = new ArrayList<Parcelas>();
    private String situacao; 

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public String getDataVenda() {
        return dataVenda;
    }

    public void setDataVenda(String dataVenda) {
        this.dataVenda = dataVenda;
    }

    public String getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(String formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public String getObservacoes() {
        return observacoes;
    }

    public void setObservacoes(String observacoes) {
        this.observacoes = observacoes;
    }

    public BigDecimal getAcrescimos() {
        return acrescimos;
    }

    public void setAcrescimos(BigDecimal acrescimos) {
        this.acrescimos = acrescimos;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getTotalCompra() {
        return totalCompra;
    }

    public void setTotalCompra(BigDecimal totalCompra) {
        this.totalCompra = totalCompra;
    }

    public BigDecimal getTotalConta() {
        return totalConta;
    }

    public void setTotalConta(BigDecimal totalConta) {
        this.totalConta = totalConta;
    }

    public BigDecimal getTotalRestante() {
        return totalRestante;
    }

    public void setTotalRestante(BigDecimal totalRestante) {
        this.totalRestante = totalRestante;
    }

    public BigDecimal getTotalPago() {
        return totalPago;
    }

    public void setTotalPago(BigDecimal totalPago) {
        this.totalPago = totalPago;
    }

    public int getQtdVolume() {
        return qtdVolume;
    }

    public void setQtdVolume(int qtdVolume) {
        this.qtdVolume = qtdVolume;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public ClienteFisico getClienteFisico() {
        return clienteFisico;
    }

    public void setClienteFisico(ClienteFisico clienteFisico) {
        this.clienteFisico = clienteFisico;
    }

    public List<ItemProduto> getItensProduto() {
        return itensProduto;
    }

    public void setItensProduto(List<ItemProduto> itensProduto) {
        this.itensProduto = itensProduto;
    }

    public List<DetalhamentoConta> getDetalhamentoConta() {
        return detalhamentoConta;
    }

    public void setDetalhamentoConta(List<DetalhamentoConta> detalhamentoConta) {
        this.detalhamentoConta = detalhamentoConta;
    }

    public List<Parcelas> getParcelas() {
        return parcelas;
    }

    public void setParcelas(List<Parcelas> parcelas) {
        this.parcelas = parcelas;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    
}
