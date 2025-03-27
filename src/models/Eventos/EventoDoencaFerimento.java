package models.Eventos;

public class EventoDoencaFerimento extends Evento {

    private String tipoCondicao; // Tipo da condição (ex: "infecção", "fratura")
    private String impacto; // Impacto do evento (ex: "redução de vida", "aumento de sanidade")
    private String curaDisponivel; // Cura disponível para a condição (ex: "antibiótico", "gesso")

    // Construtor que inicializa os dados específicos da condição ou ferimento
    public EventoDoencaFerimento(String nome, String descricao, double probabilidade, String impacto, String tipoCondicao, String curaDisponivel) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoCondicao = tipoCondicao;
        this.impacto = impacto;
        this.curaDisponivel = curaDisponivel;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getTipoCondicao() {
        return tipoCondicao;
    }

    public void setTipoCondicao(String tipoCondicao) {
        this.tipoCondicao = tipoCondicao;
    }

    public String getImpacto() {
        return impacto;
    }

    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    public String getCuraDisponivel() {
        return curaDisponivel;
    }

    public void setCuraDisponivel(String curaDisponivel) {
        this.curaDisponivel = curaDisponivel;
    }

    // Método sobrescrito para executar o evento de doença ou ferimento
    @Override
    public void executar() {
        System.out.println("🚑 Evento de Doença/Ferimento: " + getTipoCondicao());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Impacto: " + getImpacto());
        System.out.println("Cura disponível: " + getCuraDisponivel());
    }
}


