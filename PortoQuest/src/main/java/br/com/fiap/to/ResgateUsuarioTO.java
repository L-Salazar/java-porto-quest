package br.com.fiap.to;

import java.time.LocalDate;

public class ResgateUsuarioTO {

    private int idResgate;
    private int idUsuario;
    private int idRecompensa;
    private LocalDate dtResgate;
    private int qtPontosUtilizados;
    private String descricaoRecompensa;

    public ResgateUsuarioTO() {
    }

    public ResgateUsuarioTO(int idResgate, int idUsuario, int idRecompensa, LocalDate dtResgate, int qtPontosUtilizados) {
        this.idResgate = idResgate;
        this.idUsuario = idUsuario;
        this.idRecompensa = idRecompensa;
        this.dtResgate = dtResgate;
        this.qtPontosUtilizados = qtPontosUtilizados;
    }

    public String getDescricaoRecompensa() {
        return descricaoRecompensa;
    }

    public void setDescricaoRecompensa(String descricaoRecompensa) {
        this.descricaoRecompensa = descricaoRecompensa;
    }

    public int getIdResgate() {
        return idResgate;
    }

    public void setIdResgate(int idResgate) {
        this.idResgate = idResgate;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public LocalDate getDtResgate() {
        return dtResgate;
    }

    public void setDtResgate(LocalDate dtResgate) {
        this.dtResgate = dtResgate;
    }

    public int getQtPontosUtilizados() {
        return qtPontosUtilizados;
    }

    public void setQtPontosUtilizados(int qtPontosUtilizados) {
        this.qtPontosUtilizados = qtPontosUtilizados;
    }

}
