package modelos;

import java.util.Map;

public record MoedaResposta(String base_code, Map<String, Double> conversion_rates) {
}
