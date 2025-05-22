package principal;

import modelos.Moeda;
import modelos.MoedaInfo;
import utilitarios.ConversorMoeda;
import utilitarios.Menu;
import utilitarios.MoedaLoader;

import java.text.MessageFormat;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConversorMoeda conversorMoeda = new ConversorMoeda();
        Scanner scanner = new Scanner(System.in);
        double valor = 0;
        String result;
        Moeda moeda = new Moeda();
        Menu menu = new Menu();
        MoedaLoader loader = new MoedaLoader();
        List<MoedaInfo> listaMoedas = loader.carregarMoedasDeJson("src/arquivos/moedasSuportadas.json");

        int escolha = 0;
        while (escolha != 9) {
            menu.chamarMenu();
            escolha = scanner.nextInt();
            if (escolha != 7) {
                System.out.println("Digite o valor que deseja converter: ");
                valor = scanner.nextDouble();
                scanner.nextLine();
            }

            switch (escolha) {
                case 1:
                    result = conversorMoeda.converterValor(moeda, valor, "USD", "ARS");
                    System.out.println(result);
                    break;
                case 2:
                    result = conversorMoeda.converterValor(moeda, valor, "ARS", "USD");
                    System.out.println(result);
                    break;
                case 3:
                    result = conversorMoeda.converterValor(moeda, valor, "USD", "BRL");
                    System.out.println(result);
                    break;
                case 4:
                    result = conversorMoeda.converterValor(moeda, valor, "BRL", "USD");
                    System.out.println(result);
                    break;
                case 5:
                    result = conversorMoeda.converterValor(moeda, valor, "USD", "COP");
                    System.out.println(result);
                    break;
                case 6:
                    result = conversorMoeda.converterValor(moeda, valor, "COP", "USD");
                    System.out.println(result);
                    break;
                case 7:
                    listaMoedas.forEach(moedaInfo -> System.out.println(MessageFormat.format("{0} - {1} - {2}", moedaInfo.codigo(), moedaInfo.nome(), moedaInfo.pais())));
                    break;
                case 8:
                    String codigoBase = menu.solicitarMoeda(scanner, "BASE", listaMoedas);
                    String codigoConversao = menu.solicitarMoeda(scanner, "CONVERSÃO", listaMoedas);
                    result = conversorMoeda.converterValor(moeda, valor, codigoBase, codigoConversao);
                    System.out.println(result);
                    break;
                case 9:
                    System.out.println("Programa Encerrado.");
                    break;
            }
        }
    }
}