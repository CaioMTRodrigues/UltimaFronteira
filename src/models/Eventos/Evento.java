package models.Eventos;

import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

/**
 * Classe abstrata base para todos os eventos do jogo.
 * Define os atributos e comportamentos genéricos de qualquer evento.
 */
public abstract class Evento {

    private String nome;
    private String descricao;
    private double probabilidadeOcorrencia;
    private String impacto;
    private boolean condicaoAtivacao;

    /**
     * Construtor padrão de evento.
     *
     * @param nome Nome do evento.
     * @param descricao Descrição explicativa.
     * @param probabilidadeOcorrencia Probabilidade de ocorrência do evento.
     * @param impacto Impacto causado no jogo.
     */
    public Evento(String nome, String descricao, double probabilidadeOcorrencia, String impacto) {
        this.nome = nome;
        this.descricao = descricao;
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
        this.impacto = impacto;
        this.condicaoAtivacao = true;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getProbabilidadeOcorrencia() { return probabilidadeOcorrencia; }
    public void setProbabilidadeOcorrencia(double probabilidadeOcorrencia) { this.probabilidadeOcorrencia = probabilidadeOcorrencia; }

    public String getImpacto() { return impacto; }
    public void setImpacto(String impacto) { this.impacto = impacto; }

    public boolean isCondicaoAtivacao() { return condicaoAtivacao; }
    public void setCondicaoAtivacao(boolean condicaoAtivacao) { this.condicaoAtivacao = condicaoAtivacao; }

    /**
     * Desativa o evento (por exemplo, se ele não puder mais ocorrer).
     */
    public void desativarEvento() {
        this.condicaoAtivacao = false;
    }

    /**
     * Executa o comportamento específico do evento, modificando o personagem e o ambiente.
     * Esse método será implementado nas subclasses.
     *
     * @param jogador Personagem afetado pelo evento.
     * @param ambiente Ambiente onde o evento ocorre.
     */
    public abstract void executar(Personagem jogador, Ambiente ambiente);
}