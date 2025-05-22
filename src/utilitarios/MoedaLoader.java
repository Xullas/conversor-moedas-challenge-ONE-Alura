package utilitarios;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import modelos.MoedaInfo;

import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;
import java.util.List;

public class MoedaLoader {

    public List<MoedaInfo> carregarMoedasDeJson(String caminhoDoArquivo) {
        try (Reader reader = new FileReader(caminhoDoArquivo)) {
            Gson gson = new Gson();

            Type listType = new TypeToken<List<MoedaInfo>>() {}.getType();
            return gson.fromJson(reader, listType);

        } catch (IOException e) {
            throw new RuntimeException("Erro ao carregar JSON de moedas", e);
        }
    }
}