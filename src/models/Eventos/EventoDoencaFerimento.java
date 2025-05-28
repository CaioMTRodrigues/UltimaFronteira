package models.Eventos;

import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

/**
 * Representa um evento de doença ou ferimento.
 * Esse evento pode reduzir os atributos de vida, energia e sanidade do personagem.
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
     * @param probabilidade Probabilidade de ocorrência do evento.
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

    /**
     * Retorna o tipo da condição (ex: febre, fratura).
     * 
     * @return O tipo da condição.
     */
    public String getTipoCondicao() {
        return tipoCondicao;
    }

    /**
     * Define o tipo da condição (ex: febre, fratura).
     * 
     * @param tipoCondicao O tipo da condição a ser definido.
     */
    public void setTipoCondicao(String tipoCondicao) {
        this.tipoCondicao = tipoCondicao;
    }

    /**
     * Retorna o impacto do evento no personagem.
     * 
     * @return O impacto do evento.
     */
    public String getImpacto() {
        return impacto;
    }

    /**
     * Define o impacto do evento no personagem.
     * 
     * @param impacto O impacto a ser atribuído ao evento.
     */
    public void setImpacto(String impacto) {
        this.impacto = impacto;
    }

    /**
     * Retorna o item disponível para cura.
     * 
     * @return O item de cura disponível.
     */
    public String getCuraDisponivel() {
        return curaDisponivel;
    }

    /**
     * Define o item disponível para cura.
     * 
     * @param curaDisponivel O item de cura a ser atribuído.
     */
    public void setCuraDisponivel(String curaDisponivel) {
        this.curaDisponivel = curaDisponivel;
    }

    /**
     * Executa o evento de doença ou ferimento, afetando os atributos do personagem.
     * 
     * @param jogador O personagem afetado pelo evento.
     * @param ambiente O ambiente onde o evento ocorre (não utilizado diretamente aqui, mas disponível).
     */
    @Override
    public void executar(Personagem jogador, Ambiente ambiente) {
        System.out.println("Evento de Doença/Ferimento: " + getTipoCondicao());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Impacto: " + getImpacto());
        System.out.println("Cura disponível: " + getCuraDisponivel());

        // Aplica dano na vida com o método seguro
        jogador.aplicarDano(15);
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);

        System.out.println("⚠ Vida, energia e sanidade foram reduzidas devido à condição.");
    }
}
