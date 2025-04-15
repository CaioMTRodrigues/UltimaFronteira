package models.Eventos;

import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

/**
 * Representa um evento de doença ou ferimento.
 */
public class EventoDoencaFerimento extends Evento {

    private String tipoCondicao;
    private String impacto;
    private String curaDisponivel;

    /**
     * Construtor do evento de doença ou ferimento.
     *
     * @param nome Nome do evento.
     * @param descricao Descrição do evento.
     * @param probabilidade Probabilidade de ocorrência.
     * @param impacto Impacto causado ao personagem.
     * @param tipoCondicao Tipo da condição (ex: febre, fratura).
     * @param curaDisponivel Item necessário para cura.
     */
    public EventoDoencaFerimento(String nome, String descricao, double probabilidade, String impacto, String tipoCondicao, String curaDisponivel) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoCondicao = tipoCondicao;
        this.impacto = impacto;
        this.curaDisponivel = curaDisponivel;
    }

    // Getters e Setters
    public String getTipoCondicao() { return tipoCondicao; }
    public void setTipoCondicao(String tipoCondicao) { this.tipoCondicao = tipoCondicao; }

    public String getImpacto() { return impacto; }
    public void setImpacto(String impacto) { this.impacto = impacto; }

    public String getCuraDisponivel() { return curaDisponivel; }
    public void setCuraDisponivel(String curaDisponivel) { this.curaDisponivel = curaDisponivel; }

    /**
     * Executa o evento de doença ou ferimento, afetando os atributos do personagem.
     *
     * @param jogador Personagem afetado.
     * @param ambiente Ambiente atual (não utilizado diretamente aqui, mas disponível).
     */
    @Override
    public void executar(Personagem jogador, Ambiente ambiente) {
        System.out.println("🚑 Evento de Doença/Ferimento: " + getTipoCondicao());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Impacto: " + getImpacto());
        System.out.println("Cura disponível: " + getCuraDisponivel());

        // Afeta diretamente os atributos do personagem
        jogador.setVida(jogador.getVida() - 15);
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);

        System.out.println("⚠ Vida, energia e sanidade foram reduzidas devido à condição.");
    }
}





