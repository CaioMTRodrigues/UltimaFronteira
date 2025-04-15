package models.Eventos;

import java.util.List;
import models.Itens.Item;
import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

/**
 * Representa um evento de descoberta no ambiente.
 */
public class EventoDescoberta extends Evento {

    private String tipoDescoberta;
    private List<Item> recursosEncontrados;
    private String condicaoEspecial;

    /**
     * Construtor do evento de descoberta.
     *
     * @param nome Nome do evento.
     * @param descricao Descrição do evento.
     * @param probabilidade Probabilidade de ocorrência.
     * @param impacto Impacto causado.
     * @param tipoDescoberta Tipo da descoberta (ex: abrigo, ruínas).
     * @param recursosEncontrados Itens descobertos.
     * @param condicaoEspecial Condição especial para acesso ou uso.
     */
    public EventoDescoberta(String nome, String descricao, double probabilidade, String impacto, String tipoDescoberta, List<Item> recursosEncontrados, String condicaoEspecial) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoDescoberta = tipoDescoberta;
        this.recursosEncontrados = recursosEncontrados;
        this.condicaoEspecial = condicaoEspecial;
    }

    // Getters e Setters
    public String getTipoDescoberta() { return tipoDescoberta; }
    public void setTipoDescoberta(String tipoDescoberta) { this.tipoDescoberta = tipoDescoberta; }

    public List<Item> getRecursosEncontrados() { return recursosEncontrados; }
    public void setRecursosEncontrados(List<Item> recursosEncontrados) { this.recursosEncontrados = recursosEncontrados; }

    public String getCondicaoEspecial() { return condicaoEspecial; }
    public void setCondicaoEspecial(String condicaoEspecial) { this.condicaoEspecial = condicaoEspecial; }

    /**
     * Executa o evento de descoberta, adicionando itens ao inventário
     * e afetando atributos do personagem de forma positiva.
     *
     * @param jogador O personagem que encontrou os recursos.
     * @param ambiente O ambiente onde a descoberta ocorreu.
     */
    @Override
    public void executar(Personagem jogador, Ambiente ambiente) {
        System.out.println("🔍 Descoberta: " + getTipoDescoberta());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Condição Especial: " + getCondicaoEspecial());

        if (recursosEncontrados == null || recursosEncontrados.isEmpty()) {
            System.out.println("Nenhum recurso foi encontrado.");
        } else {
            System.out.println("Recursos encontrados:");
            for (Item item : recursosEncontrados) {
                jogador.getInventario().adicionarItem(item);
            }
        }

        // Recupera um pouco de sanidade ao encontrar recursos úteis
        jogador.setSanidade(jogador.getSanidade() + 5);
    }
}

