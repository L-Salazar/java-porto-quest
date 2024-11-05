package br.com.fiap.to;

public class PecaTO {

    private int idPeca;
    private String nomePeca;
    private String codigoPeca;
    private String descricacoPeca;
    private double valorUnitario;

    public PecaTO() {
    }

    public PecaTO(int idPeca, String nomePeca, String codigoPeca, String descricacoPeca, double valorUnitario) {
        this.idPeca = idPeca;
        this.nomePeca = nomePeca;
        this.codigoPeca = codigoPeca;
        this.descricacoPeca = descricacoPeca;
        this.valorUnitario = valorUnitario;
    }

    public int getIdPeca() {
        return idPeca;
    }

    public void setIdPeca(int idPeca) {
        this.idPeca = idPeca;
    }

    public String getNomePeca() {
        return nomePeca;
    }

    public void setNomePeca(String nomePeca) {
        this.nomePeca = nomePeca;
    }

    public String getCodigoPeca() {
        return codigoPeca;
    }

    public void setCodigoPeca(String codigoPeca) {
        this.codigoPeca = codigoPeca;
    }

    public String getDescricacoPeca() {
        return descricacoPeca;
    }

    public void setDescricacoPeca(String descricacoPeca) {
        this.descricacoPeca = descricacoPeca;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }



}
