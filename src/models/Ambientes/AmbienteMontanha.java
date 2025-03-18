package models.Ambientes;

public class AmbienteMontanha extends Ambiente {

    private boolean terrenoAcidentado;
    private boolean climaInstavel;
    private boolean baixaVegetacao;

    public AmbienteMontanha() {
        super("Montanha", "Uma região alta e perigosa, com ventos fortes e clima instável.", 5, "Frio");
        this.terrenoAcidentado = true;
        this.climaInstavel = true;
        this.baixaVegetacao = true;
    }

    @Override
    public void explorar() {
        System.out.println("Você enfrenta o frio e a altitude da montanha.");
        super.explorar();
    }
}
