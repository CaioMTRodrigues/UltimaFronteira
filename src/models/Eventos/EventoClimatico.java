package models.Eventos;

public class EventoClimatico extends Evento {
    private String tipoClima;      // Tipo de clima (ex: "nevasca", "chuva forte")
    private int duracao;           // Duração do evento (em turnos)
    private String efeitoNoAmbiente; // Efeito do evento no ambiente (ex: "reduz a visibilidade", "aumenta o consumo de água")

    // Construtor
    public EventoClimatico(String nome, String descricao, double probabilidade, String impacto, String tipoClima, int duracao, String efeitoNoAmbiente) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoClima = tipoClima;
        this.duracao = duracao;
        this.efeitoNoAmbiente = efeitoNoAmbiente;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getTipoClima() {
        return tipoClima;
    }

    public void setTipoClima(String tipoClima) {
        this.tipoClima = tipoClima;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public String getEfeitoNoAmbiente() {
        return efeitoNoAmbiente;
    }

    public void setEfeitoNoAmbiente(String efeitoNoAmbiente) {
        this.efeitoNoAmbiente = efeitoNoAmbiente;
    }

    // Método sobrescrito de executar
    @Override
    public void executar() {
        System.out.println("⛈ Evento Climático: " + getTipoClima());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Duração: " + getDuracao() + " turnos.");
        System.out.println("Impacto: " + getImpacto());
    }
}

