package models.Ambientes;

public class AmbienteFloresta extends Ambiente {

    private boolean vegetacaoDensa; 
    private boolean faunaAbundante; 
    private boolean climaUmido; 
    
    public AmbienteFloresta() {
        super("Floresta", "Uma densa floresta cheia de vida e perigos.", 3, "Úmido");
        this.vegetacaoDensa = true;
        this.faunaAbundante = true;
        this.climaUmido = true;
    }

    @Override
    public void explorar() {
        System.out.println("Você se aventura na floresta. O som dos animais ecoa ao redor.");
        super.explorar();
    }
}
