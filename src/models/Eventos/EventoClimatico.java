package models.Eventos;

public class EventoClimatico extends Evento {

    private String tipoClima;
    private int duracao;
    private String efeitoNoAmbiente;

    // Construtor que inicializa os dados específicos do evento climático
    public EventoClimatico(String nome, String descricao, double probabilidade, String impacto, String tipoClima, int duracao, String efeitoNoAmbiente) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoClima = tipoClima;
        this.duracao = duracao;
        this.efeitoNoAmbiente = efeitoNoAmbiente;
    }

    // Métodos de Acesso
    public String getTipoClima() { return tipoClima; }
    public void setTipoClima(String tipoClima) { this.tipoClima = tipoClima; }
    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }
    public String getEfeitoNoAmbiente() { return efeitoNoAmbiente; }
    public void setEfeitoNoAmbiente(String efeitoNoAmbiente) { this.efeitoNoAmbiente = efeitoNoAmbiente; }

    // Método sobrescrito para executar o evento climático
    @Override
    public void executar() {
        System.out.println("⛈ Evento Climático: " + getTipoClima());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Duração: " + getDuracao() + " turnos.");
        System.out.println("Impacto: " + getImpacto());
        if (getDuracao() > 5) {
            System.out.println("Este evento climático pode ter efeitos prolongados.");
        }
    }
}
