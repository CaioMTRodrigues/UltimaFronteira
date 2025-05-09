package models.Ambientes;

import models.Personagens.Personagem;

/**
 * Classe abstrata base para todos os ambientes do jogo.
 * Define atributos e comportamentos comuns a todos os tipos de ambientes.
 * Implementa a interface Exploravel para ambientes que podem ser explorados.
 */
public abstract class Ambiente implements Exploravel {

    private String nome;
    private String descricao;
    private double dificuldadeExploracao;
    private String condicoesClimaticas;

    public Ambiente(String nome, String descricao, double dificuldadeExploracao, String condicoesClimaticas) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldadeExploracao = dificuldadeExploracao;
        this.condicoesClimaticas = condicoesClimaticas;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getDificuldadeExploracao() { return dificuldadeExploracao; }
    public void setDificuldadeExploracao(double dificuldadeExploracao) { this.dificuldadeExploracao = dificuldadeExploracao; }

    public String getCondicoesClimaticas() { return condicoesClimaticas; }
    public void setCondicoesClimaticas(String condicoesClimaticas) { this.condicoesClimaticas = condicoesClimaticas; }

    /**
     * Método para modificar as condições climáticas do ambiente.
     * Este método altera o estado do clima no ambiente.
     *
     * @param novoClima O novo clima que será definido no ambiente.
     */
    public void modificarClima(String novoClima) {
        this.condicoesClimaticas = novoClima;
        System.out.println("O clima mudou para: " + novoClima);
    }
}
