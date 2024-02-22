package com.projetoCep.pesquisaCep.modelo;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;


public class DadosCidade {

    private String localidade;
    private String uf;
    private String logradouro;
    private String bairro;
    private String cep;

    public DadosCidade(String localidade, String uf, String logradouro, String bairro, String cep) {
        this.localidade = localidade;
        this.uf = uf;
        this.logradouro = logradouro;
        this.bairro = bairro;
        this.cep = cep;
    }

    public DadosCidade(DadosViaCep dadosViaCep) {
        this.localidade = dadosViaCep.localidade();
        this.cep = dadosViaCep.cep();
        this.logradouro = dadosViaCep.logradouro();
        this.bairro = dadosViaCep.bairro();
        this.uf = dadosViaCep.uf();
    }

    public DadosCidade() {
    }

    public String getLocalidade() {
        return localidade;
    }

    public String getUf() {
        return uf;
    }

    public String getLogradouro() {
        return logradouro;
    }

    public String getBairro() {
        return bairro;
    }

    public String getCep() {
        return cep;
    }

    @Override
    public String toString() {
        return "Localidade: " + localidade +
                ", UF: " + uf +
                ", Logradouro: " + logradouro  +
                ", Bairro: " + bairro +
                ", Cep: " + cep + "\n";
    }
}
