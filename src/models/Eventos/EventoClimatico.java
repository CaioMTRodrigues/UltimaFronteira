package models.Eventos;

public class EventoClimatico extends Evento {
    private String tipoClima;
    private int duracao;
    private String efeitoNoAmbiente;

    public EventoClimatico(String nome, String descricao, double probabilidade, String impacto, String tipoClima, int duracao, String efeitoNoAmbiente) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoClima = tipoClima;
        this.duracao = duracao;
        this.efeitoNoAmbiente = efeitoNoAmbiente;
    }

    @Override
    public void executar() {
        System.out.println("⛈ Evento Climático: " + tipoClima);
        System.out.println("Descrição: " + descricao);
        System.out.println("Duração: " + duracao + " turnos.");
        System.out.println("Impacto: " + impacto);
    }
}
