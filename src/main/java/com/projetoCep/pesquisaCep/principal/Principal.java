package com.projetoCep.pesquisaCep.principal;

import com.projetoCep.pesquisaCep.modelo.DadosCidade;
import com.projetoCep.pesquisaCep.modelo.DadosViaCep;
import com.projetoCep.pesquisaCep.service.ConsumirApi;
import com.projetoCep.pesquisaCep.service.ConvensorDados;
import com.projetoCep.pesquisaCep.service.RefatorarCep;

import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Principal {
    private final String ENDERECO = "https://viacep.com.br/ws/";
    private Scanner sc = new Scanner(System.in);
    private ConsumirApi consumirApi = new ConsumirApi();
    private ConvensorDados convensor = new ConvensorDados();
    private RefatorarCep refatorar = new RefatorarCep();


    public void menu() {
        var menu = """
                \nEscolha uma das opções abaixo para iniciar a pesquisa:
                
                1 - Pesquisar por CEP.
                
                2 - Descobrir CEP pelo seu endereço.
                
                0 - Sair
                """;
        var opcao = -1;

        while (opcao != 0) {

            System.out.println(menu);
            opcao = sc.nextInt();
            sc.nextLine();

            switch (opcao) {

                case 1:
                    pesquisaPorCep();
                    break;

                case 2:
                    pesquisaPorLocalidade();
                    break;

                case 0:
                    System.out.println("Saindo...");
                    break;
            }

        }
    }
    private void pesquisaPorCep() {
        System.out.println("Digite o CEP para busca: ");
        var cepBuscado = sc.nextLine();

        try {
            var endereco = ENDERECO + refatorar.refadoraCep(cepBuscado) + "/json/";
            String json = consumirApi.consumirApi(endereco);
            DadosViaCep dados = convensor.obterDados(json, DadosViaCep.class);
            DadosCidade dadosCidade = new DadosCidade(dados);
            System.out.println(dadosCidade);
        } catch (Exception e){
            System.out.println("CEP inválido!!");
        }

    }

    private void pesquisaPorLocalidade() {
        System.out.println("Digite o UF da sua localidade: ");
        var uf = sc.nextLine();
        System.out.println("Digite o nome da cidade: ");
        var nomeCidade = sc.nextLine();
        System.out.println("Digite sua rua: ");
        var rua = sc.nextLine();

        var endereco = ENDERECO + uf.toUpperCase() + "/" + nomeCidade + "/" + rua + "/json/";

        String json = consumirApi.consumirApi(endereco.replaceAll(" ", "%20"));

       List<DadosViaCep> listaCep = convensor.obterLista(json, DadosViaCep.class);
       if (listaCep.isEmpty()){
           System.out.println("Não foi possível encontrar o CEP");
       } else {
           List<DadosCidade> lista = listaCep.stream()
                   .map(d -> new DadosCidade(d))
                   .collect(Collectors.toList());
           lista.forEach(System.out::println);
       }

    }
}
