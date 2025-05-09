package models.Ambientes;

import models.Personagens.Personagem;

/**
 * Classe que representa o ambiente de Caverna.
 * Um ambiente escuro, úmido e potencialmente perigoso.
 */
public class AmbienteCaverna extends Ambiente {

    private boolean poucaLuz;
    private boolean criaturasPresentes;
    private boolean aguaDeGotejamento;

    /**
     * Construtor da caverna, definindo suas características padrão.
     */
    public AmbienteCaverna() {
        super("Caverna", "Uma caverna escura e úmida, cheia de mistérios.", 4, "Frio e úmido");
        this.poucaLuz = true;
        this.criaturasPresentes = true;
        this.aguaDeGotejamento = true;
    }

    // Getters e Setters
    public boolean isPoucaLuz() { return poucaLuz; }
    public void setPoucaLuz(boolean poucaLuz) { this.poucaLuz = poucaLuz; }

    public boolean isCriaturasPresentes() { return criaturasPresentes; }
    public void setCriaturasPresentes(boolean criaturasPresentes) { this.criaturasPresentes = criaturasPresentes; }

    public boolean isAguaDeGotejamento() { return aguaDeGotejamento; }
    public void setAguaDeGotejamento(boolean aguaDeGotejamento) { this.aguaDeGotejamento = aguaDeGotejamento; }

    /**
     * Exibe uma mensagem personalizada ao explorar a caverna.
     * Este método implementa a ação definida na interface Exploravel.
     *
     * @param jogador O personagem que está explorando.
     */
    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você entra na caverna, sua lanterna ilumina as paredes úmidas.");
        System.out.println("Você encontra alguns recursos na caverna.");
        
        // Exemplo de ações adicionais durante a exploração
        // Você pode adicionar mais interações ou recursos encontrados aqui
        if (this.isCriaturasPresentes()) {
            System.out.println("Cuidado! Há criaturas na caverna.");
        } else {
            System.out.println("A caverna parece tranquila por enquanto.");
        }

        // Exemplo de impacto nos atributos do jogador
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);
    }
}
