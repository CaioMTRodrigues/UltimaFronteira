package models.Eventos;

import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

/**
 * Classe abstrata base para todos os eventos do jogo.
 * Define os atributos e comportamentos genéricos de qualquer evento.
 * Implementa a interface Executavel para garantir que todos os eventos possam ser executados.
 */
public abstract class Evento implements Executavel {

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

    /**
     * Retorna o nome do evento.
     * 
     * @return O nome do evento.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do evento.
     * 
     * @param nome O nome a ser atribuído ao evento.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna a descrição do evento.
     * 
     * @return A descrição do evento.
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Define a descrição do evento.
     * 
     * @param descricao A descrição a ser atribuída ao evento.
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    /**
     * Retorna a probabilidade de ocorrência do evento.
     * 
     * @return A probabilidade de ocorrência.
     */
    public double getProbabilidadeOcorrencia() {
        return probabilidadeOcorrencia;
    }

    /**
     * Define a probabilidade de ocorrência do evento.
     * 
     * @param probabilidadeOcorrencia A probabilidade de ocorrência.
     */
    public void setProbabilidadeOcorrencia(double probabilidadeOcorrencia) {
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
    }

    /**
     * Retorna o impacto do evento no jogo.
     * 
     * @return O impacto do evento.
     */
    public String getImpacto() {
        return impacto;
    }

    /**
     * Define o impacto do evento no jogo.
     * 
     * @param impacto O impacto a ser atribuído ao evento.
     */
    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    /**
     * Retorna o estado de ativação do evento.
     * 
     * @return true se o evento pode ocorrer, caso contrário false.
     */
    public boolean isCondicaoAtivacao() {
        return condicaoAtivacao;
    }

    /**
     * Define o estado de ativação do evento.
     * 
     * @param condicaoAtivacao A condição de ativação do evento.
     */
    public void setCondicaoAtivacao(boolean condicaoAtivacao) {
        this.condicaoAtivacao = condicaoAtivacao;
    }

    /**
     * Desativa o evento (por exemplo, se ele não puder mais ocorrer).
     */
    public void desativarEvento() {
        this.condicaoAtivacao = false;
    }

    /**
     * Método abstrato que define a execução do evento.
     * Este método deve ser implementado pelas subclasses específicas de evento.
     * 
     * @param jogador O personagem afetado pelo evento.
     * @param ambiente O ambiente onde o evento ocorre.
     */
    public abstract void executar(Personagem jogador, Ambiente ambiente);
}