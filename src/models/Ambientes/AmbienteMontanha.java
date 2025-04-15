package models.Ambientes;

import models.Personagens.Personagem;

/**
 * Classe que representa o ambiente de Montanha.
 * Um local de difícil acesso, com clima instável e pouca vegetação.
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
     *
     * @param jogador O personagem que está explorando.
     */
    @Override
    public void explorar(Personagem jogador) {
        System.out.println("🧗 Você enfrenta o frio e a altitude da montanha.");
        super.explorar(jogador);
    }
}
