package models.Ambientes;

import models.Personagens.Personagem;

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
        
        // Exemplo de ações adicionais durante a exploração
        if (this.isFaunaAbundante()) {
            System.out.println("A fauna na floresta é abundante, talvez você possa caçar.");
        } else {
            System.out.println("A floresta está tranquila, mas não há muita fauna por perto.");
        }

        // Exemplo de impacto nos atributos do jogador
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);
    }
}
