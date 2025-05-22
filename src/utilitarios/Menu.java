package utilitarios;

import modelos.MoedaInfo;

import java.util.List;
import java.util.Scanner;

public class Menu {

    public void chamarMenu() {
        int tamanho = 40;
        System.out.println("*".repeat(tamanho));
        System.out.println("Seja bem-vindo/a ao Conversor de Moeda!\n");
        System.out.println("1) Dólar =>> Peso argentino");
        System.out.println("2) Peso argentino =>> Dólar");
        System.out.println("3) Dólar =>> Real brasileiro");
        System.out.println("4) Real brasileiro =>> Dólar");
        System.out.println("5) Dólar =>> Peso colombiano");
        System.out.println("6) Peso colombiano =>> Dólar");
        System.out.println("7) Listar Moedas Suportadas para Conversão");
        System.out.println("8) Inserir Valor e Moedas para Conversão");
        System.out.println("9) Sair da aplicação\n");
        System.out.println("Escolha uma opção válida:");
        System.out.println("*".repeat(tamanho));
    }

    public String solicitarMoeda(Scanner scanner, String tipo, List<MoedaInfo> listaMoedasSuportadas){

        while(true){
            System.out.print("Digite o código da moeda " + tipo + " (ex: USD, BRL): ");
            String codigo = scanner.nextLine().trim().toUpperCase();
            if(listaMoedasSuportadas.stream().anyMatch(moedaInfo -> moedaInfo.codigo().equals(codigo))){
                return codigo;
            } else {
                System.out.println("Código da Moeda inválido! Tente novamente!");
            }
        }
    }
}
