package models.Ambientes;

public class AmbienteMontanha extends Ambiente {

    private boolean terrenoAcidentado;
    private boolean climaInstavel;
    private boolean baixaVegetacao;

    // Construtor que inicializa os atributos específicos da montanha
    public AmbienteMontanha() {
        super("Montanha", "Uma região alta e perigosa, com ventos fortes e clima instável.", 5, "Frio");
        this.terrenoAcidentado = true;
        this.climaInstavel = true;
        this.baixaVegetacao = true;
    }

    // Métodos de Acesso
    public boolean isTerrenoAcidentado() { return terrenoAcidentado; }
    public void setTerrenoAcidentado(boolean terrenoAcidentado) { this.terrenoAcidentado = terrenoAcidentado; }
    public boolean isClimaInstavel() { return climaInstavel; }
    public void setClimaInstavel(boolean climaInstavel) { this.climaInstavel = climaInstavel; }
    public boolean isBaixaVegetacao() { return baixaVegetacao; }
    public void setBaixaVegetacao(boolean baixaVegetacao) { this.baixaVegetacao = baixaVegetacao; }

    // Método sobrescrito para explorar o ambiente, agora inclui características específicas da montanha
    @Override
    public void explorar() {
        System.out.println("Você enfrenta o frio e a altitude da montanha.");
        super.explorar();
    }
}

