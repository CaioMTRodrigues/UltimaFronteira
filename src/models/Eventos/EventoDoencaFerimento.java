package models.Eventos;

public class EventoDoencaFerimento extends Evento {
    private String tipoCondicao;
    private String impacto;
    private String curaDisponivel;

    public EventoDoencaFerimento(String nome, String descricao, double probabilidade, String impacto, String tipoCondicao, String curaDisponivel) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoCondicao = tipoCondicao;
        this.impacto = impacto;
        this.curaDisponivel = curaDisponivel;
    }

    @Override
    public void executar() {
        System.out.println("🚑 Evento de Doença/Ferimento: " + tipoCondicao);
        System.out.println("Descrição: " + descricao);
        System.out.println("Impacto: " + impacto);
        System.out.println("Cura disponível: " + curaDisponivel);
    }
}
