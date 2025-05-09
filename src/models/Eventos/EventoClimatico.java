package models.Eventos;

import models.Ambientes.Ambiente;
import models.Itens.*;
import models.Personagens.Personagem;

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
        System.out.println("Evento Climático: " + getTipoClima());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Duração: " + getDuracao() + " turnos.");
        System.out.println("Impacto: " + getImpacto());

        // Modifica o clima do ambiente
        ambiente.modificarClima(getTipoClima());

        // Efeitos gerais no personagem
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);

        // Efeitos específicos por tipo de clima
        switch (tipoClima.toLowerCase()) {
            case "chuva":
            case "chuva leve":
            case "chuva nutriente":
                Item fruta = new ItemAlimento("Fruta Fresca", 0.4, 1, 10, "Fruta", 8);
                jogador.getInventario().adicionarItem(fruta);
                System.out.println("A chuva fez brotar frutas frescas. Você coletou: " + fruta.getNome());
                break;

            case "calor seco":
            case "seca":
                System.out.println("O calor excessivo secou fontes de água próximas.");
                jogador.setSede(jogador.getSede() + 5);
                break;

            case "neblina":
                System.out.println("A visibilidade está baixa. Você se sente desorientado.");
                jogador.setSanidade(jogador.getSanidade() - 10);
                break;

            case "neve":
                System.out.println("Você sente o frio cortante dificultando a movimentação.");
                jogador.setEnergia(jogador.getEnergia() - 15);
                break;
        }

        if (getDuracao() > 5) {
            System.out.println("Este evento climático pode ter efeitos prolongados.");
        }
    }
}