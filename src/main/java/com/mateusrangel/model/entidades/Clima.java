package com.mateusrangel.model.entidades;

public class Clima {

    public static class ClimaInvalidoException extends Exception {
        public ClimaInvalidoException(String mensagem) {
            super(mensagem);
        }
    }
    
    private String nomeCidade; 
    private double temperaturaCidade; 
    private String descricaoClima; 
    private String categoriaClima;

    public Clima(String nomeCidade, double temperaturaCidade, String descricaoClima, String categoriaClima) throws ClimaInvalidoException {
        setNomeCidade(nomeCidade);
        setTemperaturaCidade(temperaturaCidade);
        setDescricaoClima(descricaoClima);
        setCategoriaClima(categoriaClima);
    }

    public String getNomeCidade() {
        return nomeCidade;
    }

    public void setNomeCidade(String nomeCidade) throws ClimaInvalidoException {
        if (nomeCidade == null || nomeCidade.trim().isEmpty()) {
            throw new ClimaInvalidoException("O nome da cidade não pode ser nulo ou vazio.");
        }
        this.nomeCidade = nomeCidade.trim();
    }

    public double getTemperaturaCidade() {
        return temperaturaCidade;
    }

    public void setTemperaturaCidade(double temperaturaCidade) throws ClimaInvalidoException {
        if (temperaturaCidade < -273.15) {
            throw new ClimaInvalidoException("Temperatura inválida: o valor não pode ser inferior ao zero absoluto (-273.15 °C).");
        }
        if (temperaturaCidade > 100.0) {
            throw new ClimaInvalidoException("Temperatura inválida: o valor informado excede o limite físico esperado (" + temperaturaCidade + " °C).");
        }
        this.temperaturaCidade = temperaturaCidade;
    }

    public String getDescricaoClima() {
        return descricaoClima;
    }

    public void setDescricaoClima(String descricaoClima) throws ClimaInvalidoException {
        if (descricaoClima == null || descricaoClima.trim().isEmpty()) {
            throw new ClimaInvalidoException("A descrição do clima não pode ser nula ou vazia.");
        }
        this.descricaoClima = descricaoClima.trim();
    }

    public String getCategoriaClima() {
        return categoriaClima;
    }

    public void setCategoriaClima(String categoriaClima) throws ClimaInvalidoException {
        if (categoriaClima == null || categoriaClima.trim().isEmpty()) {
            throw new ClimaInvalidoException("A categoria do clima não pode ser nula ou vazia.");
        }
        this.categoriaClima = categoriaClima.trim();
    } 
    
}
