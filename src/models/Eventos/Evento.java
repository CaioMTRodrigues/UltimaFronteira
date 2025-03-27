package models.Eventos;

public abstract class Evento {

    private String nome; // Nome do evento
    private String descricao; // Descrição do evento
    private double probabilidadeOcorrencia; // Probabilidade de ocorrência do evento
    private String impacto; // Impacto do evento (ex: "redução de vida", "aumento de sanidade")
    private boolean condicaoAtivacao; // Condição de ativação do evento (se está ativo ou não)

    // Construtor que inicializa os dados principais do evento
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

    // Método abstrato que será implementado nas subclasses
    public abstract void executar();
}
