package models.Eventos;

public abstract class Evento {
    protected String nome;                 // Nome do evento
    protected String descricao;            // Descrição do evento
    protected double probabilidadeOcorrencia; // Probabilidade de ocorrência do evento
    protected String impacto;              // Impacto do evento
    protected boolean condicaoAtivacao;   // Condição de ativação do evento (se está ativo ou não)

    // Construtor
    public Evento(String nome, String descricao, double probabilidadeOcorrencia, String impacto) {
        this.nome = nome;
        this.descricao = descricao;
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
        this.impacto = impacto;
        this.condicaoAtivacao = true; // Por padrão, eventos estão ativos
    }

    // Métodos de Acesso (Getters e Setters)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getProbabilidadeOcorrencia() {
        return probabilidadeOcorrencia;
    }

    public void setProbabilidadeOcorrencia(double probabilidadeOcorrencia) {
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public boolean isCondicaoAtivacao() {
        return condicaoAtivacao;
    }

    public void setCondicaoAtivacao(boolean condicaoAtivacao) {
        this.condicaoAtivacao = condicaoAtivacao;
    }

    // Método para desativar o evento
    public void desativarEvento() {
        this.condicaoAtivacao = false;
    }

    // Método abstrato para ser implementado nas subclasses
    public abstract void executar();
}

