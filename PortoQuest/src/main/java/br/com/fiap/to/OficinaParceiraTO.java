package br.com.fiap.to;

import jakarta.validation.constraints.NotBlank;

public class OficinaParceiraTO {
    private int idOficina;
    @NotBlank private String urlBanner;
    @NotBlank private String nome;
    private int prioridade;

    public OficinaParceiraTO() {
    }

    public OficinaParceiraTO(int idOficina,@NotBlank String urlBanner,@NotBlank String nome, EnderecoTO endereco, int prioridade) {
        this.idOficina = idOficina;
        this.urlBanner = urlBanner;
        this.nome = nome;
        this.prioridade = prioridade;
    }

    public int getIdOficina() {
        return idOficina;
    }

    public void setIdOficina(int idOficina) {
        this.idOficina = idOficina;
    }

    public String getUrlBanner() {
        return urlBanner;
    }

    public void setUrlBanner(String urlBanner) {
        this.urlBanner = urlBanner;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getPrioridade() {
        return prioridade;
    }

    public void setPrioridade(int prioridade) {
        this.prioridade = prioridade;
    }
}
