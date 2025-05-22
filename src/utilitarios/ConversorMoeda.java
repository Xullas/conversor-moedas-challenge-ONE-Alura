package utilitarios;

import com.google.gson.Gson;
import modelos.Moeda;
import modelos.MoedaResposta;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.text.MessageFormat;

public class ConversorMoeda {

    private double buscarCotacao(String moedaBase, String moedaConversao){
        URI endereco = URI.create("https://v6.exchangerate-api.com/v6/b9a15125a700edce0f97772d/latest/" + moedaBase);

        HttpRequest request = HttpRequest.newBuilder()
                .uri(endereco)
                .build();

        try{
            HttpResponse<String> response = HttpClient.newHttpClient()
                    .send(request, HttpResponse.BodyHandlers.ofString());
            MoedaResposta moedaRetorno = new Gson().fromJson(response.body(), MoedaResposta.class);
            return moedaRetorno.conversion_rates().get(moedaConversao);
        } catch (IOException | InterruptedException e) {
            throw new RuntimeException("Não consegui obter valores/nome moeda!");
        }
    }

    public String converterValor(Moeda moeda, double valor, String moedaBase, String moedaConversao){
        moeda.setValorMoeda(valor);
        moeda.setMoedaBase(moedaBase);
        moeda.setMoedaConversao(moedaConversao);
        moeda.setRatioConversao(buscarCotacao(moeda.getMoedaBase(), moeda.getMoedaConversao()));
        moeda.converterMoeda();
        return MessageFormat.format("Valor {0, number,#.##} [{1}] corresponde ao valor final de =>>> {2, number,#.##} [{3}]",
                moeda.getValorMoeda(), moeda.getMoedaBase(), moeda.getValorMoedaConversao(), moeda.getMoedaConversao());
    }

}
