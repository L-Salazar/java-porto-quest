package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PositiveOrZero;

public class RecompensaTO {
    private int idRecompensa;
    @NotBlank private String descricao;
    @NotNull @PositiveOrZero private int valorEmEstrelas;
    private String qrCode;

    public RecompensaTO() {
    }

    public RecompensaTO(int idRecompensa, String descricao, @NotNull @PositiveOrZero int valorEmEstrelas, String qrCode) {
        this.idRecompensa = idRecompensa;
        this.descricao = descricao;
        this.valorEmEstrelas = valorEmEstrelas;
        this.qrCode = qrCode;
    }

    public int getIdRecompensa() {
        return idRecompensa;
    }

    public void setIdRecompensa(int idRecompensa) {
        this.idRecompensa = idRecompensa;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getValorEmEstrelas() {
        return valorEmEstrelas;
    }

    public void setValorEmEstrelas(int valorEmEstrelas) {
        this.valorEmEstrelas = valorEmEstrelas;
    }

    public String getQrCode() {
        return qrCode;
    }

    public void setQrCode(String qrCode) {
        this.qrCode = qrCode;
    }

    public void resgatar() {
    }

    public boolean validarRecompensa() {
        return true;
    }
}
