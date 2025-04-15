package models.Eventos;

import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

/**
 * Representa um evento climático que afeta o ambiente do jogo.
 */
public class EventoClimatico extends Evento {

    private String tipoClima;
    private int duracao;
    private String efeitoNoAmbiente;

    /**
     * Construtor de evento climático.
     *
     * @param nome Nome do evento.
     * @param descricao Descrição do evento.
     * @param probabilidade Probabilidade de ocorrência.
     * @param impacto Impacto causado.
     * @param tipoClima Tipo de clima (ex: chuva, neve).
     * @param duracao Duração em turnos.
     * @param efeitoNoAmbiente Efeito causado no ambiente.
     */
    public EventoClimatico(String nome, String descricao, double probabilidade, String impacto, String tipoClima, int duracao, String efeitoNoAmbiente) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoClima = tipoClima;
        this.duracao = duracao;
        this.efeitoNoAmbiente = efeitoNoAmbiente;
    }

    // Getters e Setters
    public String getTipoClima() { return tipoClima; }
    public void setTipoClima(String tipoClima) { this.tipoClima = tipoClima; }

    public int getDuracao() { return duracao; }
    public void setDuracao(int duracao) { this.duracao = duracao; }

    public String getEfeitoNoAmbiente() { return efeitoNoAmbiente; }
    public void setEfeitoNoAmbiente(String efeitoNoAmbiente) { this.efeitoNoAmbiente = efeitoNoAmbiente; }

    /**
     * Executa o efeito do evento climático, alterando o ambiente e afetando atributos do personagem.
     *
     * @param jogador O personagem afetado.
     * @param ambiente O ambiente em que o evento ocorre.
     */
    @Override
    public void executar(Personagem jogador, Ambiente ambiente) {
        System.out.println("⛈ Evento Climático: " + getTipoClima());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Duração: " + getDuracao() + " turnos.");
        System.out.println("Impacto: " + getImpacto());

        // Modifica o clima do ambiente
        ambiente.modificarClima(getTipoClima());

        // Reduz energia do personagem devido às condições climáticas
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);

        if (getDuracao() > 5) {
            System.out.println("Este evento climático pode ter efeitos prolongados.");
        }
    }
}

