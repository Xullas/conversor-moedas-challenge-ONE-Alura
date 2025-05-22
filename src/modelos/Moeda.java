package modelos;

public class Moeda {
    private String moedaBase;
    private String moedaConversao;
    private double valorMoeda;
    private double valorMoedaConversao;
    private double ratioConversao;

    public void setMoedaBase(String moedaBase) {
        this.moedaBase = moedaBase;
    }

    public void setRatioConversao(double ratioConversao) {
        this.ratioConversao = ratioConversao;
    }

    public void setMoedaConversao(String moedaConversao) {
        this.moedaConversao = moedaConversao;
    }

    public void setValorMoeda(double valorMoeda) {
        this.valorMoeda = valorMoeda;
    }

    public String getMoedaBase() {
        return moedaBase;
    }

    public String getMoedaConversao() {
        return moedaConversao;
    }

    public double getValorMoeda() {
        return valorMoeda;
    }

    public double getValorMoedaConversao() {
        return valorMoedaConversao;
    }

    public void converterMoeda() {
        this.valorMoedaConversao = this.valorMoeda * this.ratioConversao;
    }
}
