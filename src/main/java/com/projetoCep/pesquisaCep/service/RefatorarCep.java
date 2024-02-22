package com.projetoCep.pesquisaCep.service;

public class RefatorarCep {
    public String refadoraCep(String cep) {

        if (cep.length() > 8) {
            var cepCorrigido = cep.replaceAll(" ", "");
            cep = cepCorrigido.replaceAll("-", "");

            return cep;

        } else if (cep.length() < 8) {

            return null;

        } else {
            return cep;
        }

    }
}
