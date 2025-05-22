package models.Ambientes;

import java.util.Random;
import models.Itens.Item;
import models.Itens.ItemMaterial;
import models.Personagens.Personagem;
import models.exceptions.InventarioCheioException;

/**
 * Classe que representa o ambiente de Floresta.
 * Rica em vegetação e fauna, mas pode ser perigosa.
 */
public class AmbienteFloresta extends Ambiente {

    private boolean vegetacaoDensa;
    private boolean faunaAbundante;
    private boolean climaUmido;

    /**
     * Construtor da floresta, inicializando com atributos típicos.
     */
    public AmbienteFloresta() {
        super("Floresta", "Uma densa floresta cheia de vida e perigos.", 3, "Úmido");
        this.vegetacaoDensa = true;
        this.faunaAbundante = true;
        this.climaUmido = true;
    }

    // Getters e Setters
    public boolean isVegetacaoDensa() { return vegetacaoDensa; }
    public void setVegetacaoDensa(boolean vegetacaoDensa) { this.vegetacaoDensa = vegetacaoDensa; }

    public boolean isFaunaAbundante() { return faunaAbundante; }
    public void setFaunaAbundante(boolean faunaAbundante) { this.faunaAbundante = faunaAbundante; }

    public boolean isClimaUmido() { return climaUmido; }
    public void setClimaUmido(boolean climaUmido) { this.climaUmido = climaUmido; }

    /**
     * Exibe uma mensagem personalizada ao explorar a floresta.
     * Este método implementa a ação definida na interface Exploravel.
     *
     * @param jogador O personagem que está explorando.
     */
    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você se aventura na floresta. O som dos animais ecoa ao redor.");
        System.out.println("Você encontra alguns recursos na floresta.");

        Random rand = new Random();

        try {
            // Chance de encontrar Madeira
            if (rand.nextDouble() < 0.6) {
                Item madeira = new ItemMaterial("Madeira", 1.0, 50, "Madeira", 40);
                jogador.getInventario().adicionarItem(madeira);
                System.out.println("Você coletou Madeira!");
            }

            // Chance de encontrar Algodão
            if (rand.nextDouble() < 0.3) {
                Item algodao = new ItemMaterial("Algodão", 0.3, 20, "Fibra", 20);
                jogador.getInventario().adicionarItem(algodao);
                System.out.println("Você encontrou Algodão!");
            }

            // Chance de encontrar Frutas
            if (rand.nextDouble() < 0.4) {
                Item frutas = new ItemMaterial("Frutas", 0.5, 10, "Comida", 10);
                jogador.getInventario().adicionarItem(frutas);
                System.out.println("Você colheu algumas Frutas!");
            }

        } catch (InventarioCheioException e) {
            System.out.println("Seu inventário está cheio! Não conseguiu carregar novos materiais.");
        }

        if (this.isFaunaAbundante()) {
            System.out.println("A fauna na floresta é abundante, talvez você possa caçar.");
        } else {
            System.out.println("A floresta está tranquila, mas não há muita fauna por perto.");
        }

        // Impacto nos atributos do jogador
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);
    }
}

