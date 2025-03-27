package models.Ambientes;

public class AmbienteFloresta extends Ambiente {

    private boolean vegetacaoDensa; // Se a vegetação é densa na floresta
    private boolean faunaAbundante; // Se há fauna abundante na floresta
    private boolean climaUmido;     // Se o clima é úmido na floresta

    // Construtor que inicializa os atributos específicos da floresta
    public AmbienteFloresta() {
        super("Floresta", "Uma densa floresta cheia de vida e perigos.", 3, "Úmido");
        this.vegetacaoDensa = true;
        this.faunaAbundante = true;
        this.climaUmido = true;
    }

    // Métodos de Acesso
    public boolean isVegetacaoDensa() {
        return vegetacaoDensa;
    }

    public void setVegetacaoDensa(boolean vegetacaoDensa) {
        this.vegetacaoDensa = vegetacaoDensa;
    }

    public boolean isFaunaAbundante() {
        return faunaAbundante;
    }

    public void setFaunaAbundante(boolean faunaAbundante) {
        this.faunaAbundante = faunaAbundante;
    }

    public boolean isClimaUmido() {
        return climaUmido;
    }

    public void setClimaUmido(boolean climaUmido) {
        this.climaUmido = climaUmido;
    }

    // Método sobrescrito para explorar o ambiente, agora inclui características específicas da floresta
    @Override
    public void explorar() {
        System.out.println("Você se aventura na floresta. O som dos animais ecoa ao redor.");
        super.explorar();
    }
}


