package models.Eventos;

public abstract class Evento {
    protected String nome;
    protected String descricao;
    protected double probabilidadeOcorrencia;
    protected String impacto;
    protected boolean condicaoAtivacao;

    public Evento(String nome, String descricao, double probabilidadeOcorrencia, String impacto) {
        this.nome = nome;
        this.descricao = descricao;
        this.probabilidadeOcorrencia = probabilidadeOcorrencia;
        this.impacto = impacto;
        this.condicaoAtivacao = true; // Por padrão, eventos estão ativos
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getProbabilidadeOcorrencia() {
        return probabilidadeOcorrencia;
    }

    public String getImpacto() {
        return impacto;
    }

    public boolean isCondicaoAtivacao() {
        return condicaoAtivacao;
    }

    public void desativarEvento() {
        this.condicaoAtivacao = false;
    }

    // Método abstrato para ser implementado nas subclasses
    public abstract void executar();
}
