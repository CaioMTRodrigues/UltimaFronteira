package models.Eventos;

import java.util.List;
import models.Ambientes.Ambiente;
import models.Itens.Item;
import models.Personagens.Personagem;
import models.exceptions.InventarioCheioException;

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
        System.out.println("Descoberta: " + tipoDescoberta);
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Condição Especial: " + condicaoEspecial);

        if (recursosEncontrados == null || recursosEncontrados.isEmpty()) {
            System.out.println("Nenhum recurso foi encontrado.");
        } else {
            System.out.println("Recursos encontrados:");
            for (Item item : recursosEncontrados) {
                try {
                    jogador.getInventario().adicionarItem(item); // Tenta adicionar o item ao inventário
                    System.out.println("Adicionado ao inventário: " + item.getNome());
                } catch (InventarioCheioException e) {
                    System.out.println("Não foi possível adicionar " + item.getNome() + " ao inventário: " + e.getMessage());
                }
            }

            // Bônus adicional baseado no tipo de descoberta
            if (tipoDescoberta.toLowerCase().contains("abrigo")) {
                jogador.setEnergia(jogador.getEnergia() + 10);
                System.out.println("Você descansou um pouco no abrigo. Energia +10.");
            } else if (tipoDescoberta.toLowerCase().contains("tesouro") || tipoDescoberta.toLowerCase().contains("baú")) {
                jogador.setSanidade(jogador.getSanidade() + 10);
                System.out.println("Encontrar um tesouro renovou sua esperança. Sanidade +10.");
            }
        }

        // Bônus padrão: encontrar algo ajuda na moral
        jogador.setSanidade(jogador.getSanidade() + 5);
    }
}


