package models.Ambientes;

import java.util.Random;
import models.Itens.Item;
import models.Itens.ItemMaterial;
import models.Personagens.Personagem;
import models.exceptions.InventarioCheioException;

/**
 * Classe que representa o ambiente de Montanha.
 * Uma região de difícil acesso, com clima instável e pouca vegetação.
 */
public class AmbienteMontanha extends Ambiente {

    private boolean terrenoAcidentado;
    private boolean climaInstavel;
    private boolean baixaVegetacao;

    /**
     * Construtor da montanha, definindo suas características típicas.
     */
    public AmbienteMontanha() {
        super("Montanha", "Uma região alta e perigosa, com ventos fortes e clima instável.", 5, "Frio");
        this.terrenoAcidentado = true;
        this.climaInstavel = true;
        this.baixaVegetacao = true;
    }

    // Getters e Setters
    public boolean isTerrenoAcidentado() { return terrenoAcidentado; }
    public void setTerrenoAcidentado(boolean terrenoAcidentado) { this.terrenoAcidentado = terrenoAcidentado; }

    public boolean isClimaInstavel() { return climaInstavel; }
    public void setClimaInstavel(boolean climaInstavel) { this.climaInstavel = climaInstavel; }

    public boolean isBaixaVegetacao() { return baixaVegetacao; }
    public void setBaixaVegetacao(boolean baixaVegetacao) { this.baixaVegetacao = baixaVegetacao; }

    /**
     * Exibe uma mensagem personalizada ao explorar a montanha.
     * Este método implementa a ação definida na interface Exploravel.
     *
     * @param jogador O personagem que está explorando.
     */
    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você enfrenta o frio e a altitude da montanha.");
        System.out.println("Você encontra alguns recursos nas montanhas.");

        Random rand = new Random();

        try {
            // Chance de encontrar Pedra
            if (rand.nextDouble() < 0.6) {
                Item pedra = new ItemMaterial("Pedra", 2.0, 50, "Pedra", 40);
                jogador.getInventario().adicionarItem(pedra);
                System.out.println("Você coletou Pedra!");
            }

            // Chance de encontrar Minério
            if (rand.nextDouble() < 0.3) {
                Item minerio = new ItemMaterial("Minério", 3.0, 40, "Minério", 50);
                jogador.getInventario().adicionarItem(minerio);
                System.out.println("Você encontrou Minério raro!");
            }

            // Chance de encontrar Água de degelo (necessita purificação)
            if (rand.nextDouble() < 0.4) {
                Item aguaDegelo = new ItemMaterial("Água de Degelo", 1.0, 80, "Liquido", 80);
                jogador.getInventario().adicionarItem(aguaDegelo);
                System.out.println("Você coletou Água de degelo (pode precisar purificação).");
            }

        } catch (InventarioCheioException e) {
            System.out.println("Seu inventário está cheio! Não conseguiu carregar novos materiais.");
        }

        if (this.isClimaInstavel()) {
            System.out.println("O clima pode mudar rapidamente, tenha cuidado!");
        } else {
            System.out.println("A vegetação é rara aqui, mas você pode encontrar minérios.");
        }

        // Impacto nos atributos do jogador
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);
    }
}

