package br.com.fiap.to;
import jakarta.validation.constraints.PastOrPresent;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class UsuarioTO {
    private int idUsuario;
    private int totalPontos;
    private boolean clientePorto;
    private String cpf;
    private String nome;
    private String email;

    public UsuarioTO() {
    }

    public UsuarioTO(int idUsuario, @PastOrPresent LocalDate ultimaRevisao, int totalPontos, boolean clientePorto, String cpf, String nome, String email) {
        this.idUsuario = idUsuario;
        this.totalPontos = totalPontos;
        this.clientePorto = clientePorto;
        this.cpf = cpf;
        this.nome = nome;
        this.email = email;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getTotalPontos() {
        return totalPontos;
    }

    public void setTotalPontos(int totalPontos) {
        this.totalPontos = totalPontos;
    }

    public boolean isClientePorto() {
        return clientePorto;
    }

    public void setClientePorto(boolean clientePorto) {
        this.clientePorto = clientePorto;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
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

    public void buscarHistoricoRecompensa(List<RecompensaTO> recompensas) {

    }

    public boolean verificarClientePorto(String cpf) {
        return true;
    }
}
