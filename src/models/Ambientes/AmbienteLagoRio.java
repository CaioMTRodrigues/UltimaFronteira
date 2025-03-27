package models.Ambientes;

public class AmbienteLagoRio extends Ambiente {

    private boolean aguaAbundante; // Se há água abundante no lago/rio
    private boolean possibilidadePesca; // Se há possibilidade de pesca no lago/rio
    private boolean terrenoLamacento; // Se o terreno é lamacento no lago/rio

    // Construtor que inicializa os atributos específicos do lago/rio
    public AmbienteLagoRio() {
        super("Lago e Rio", "Uma área rica em água, mas perigosa devido às criaturas aquáticas.", 2, "Úmido");
        this.aguaAbundante = true;
        this.possibilidadePesca = true;
        this.terrenoLamacento = true;
    }

    // Métodos de Acesso
    public boolean isAguaAbundante() {
        return aguaAbundante;
    }

    public void setAguaAbundante(boolean aguaAbundante) {
        this.aguaAbundante = aguaAbundante;
    }

    public boolean isPossibilidadePesca() {
        return possibilidadePesca;
    }

    public void setPossibilidadePesca(boolean possibilidadePesca) {
        this.possibilidadePesca = possibilidadePesca;
    }

    public boolean isTerrenoLamacento() {
        return terrenoLamacento;
    }

    public void setTerrenoLamacento(boolean terrenoLamacento) {
        this.terrenoLamacento = terrenoLamacento;
    }

    // Método sobrescrito para explorar o ambiente, agora inclui características específicas do lago/rio
    @Override
    public void explorar() {
        System.out.println("Você se aproxima do lago, observando as águas cristalinas.");
        super.explorar();
    }
}

