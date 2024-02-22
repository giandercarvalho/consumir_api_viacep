package com.projetoCep.pesquisaCep.modelo;

import com.fasterxml.jackson.annotation.JsonAlias;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public record DadosViaCep(String localidade,
                          String uf,
                          String logradouro,
                          String bairro,
                          String cep) {
}
