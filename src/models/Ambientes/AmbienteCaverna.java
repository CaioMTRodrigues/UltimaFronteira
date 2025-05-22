package models.Ambientes;

import java.util.Random;
import models.Itens.Item;
import models.Itens.ItemMaterial;
import models.Personagens.Personagem;
import models.exceptions.InventarioCheioException;

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

        Random rand = new Random();

        try {
            // Chance de encontrar Pedra
            if (rand.nextDouble() < 0.5) {
                Item pedra = new ItemMaterial("Pedra", 2.0, 50, "Pedra", 40);
                jogador.getInventario().adicionarItem(pedra);
                System.out.println("Você encontrou Pedra!");
            }

            // Chance de encontrar Álcool
            if (rand.nextDouble() < 0.2) {
                Item alcool = new ItemMaterial("Álcool", 0.5, 10, "Liquido", 10);
                jogador.getInventario().adicionarItem(alcool);
                System.out.println("Você encontrou Álcool!");
            }


        } catch (InventarioCheioException e) {
            System.out.println("Seu inventário está cheio! Não conseguiu carregar novos materiais.");
        }

        if (this.isCriaturasPresentes()) {
            System.out.println("Cuidado! Há criaturas na caverna.");
        } else {
            System.out.println("A caverna parece tranquila por enquanto.");
        }

        // Impacto nos atributos do jogador
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);
        }
}

