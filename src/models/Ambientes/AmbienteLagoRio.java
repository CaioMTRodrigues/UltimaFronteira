package models.Ambientes;

/**
 * Classe que representa o ambiente de Lago e Rio.
 * Uma área rica em água, mas com riscos naturais e criaturas aquáticas.
 */
public class AmbienteLagoRio extends Ambiente {

    private boolean aguaAbundante;
    private boolean possibilidadePesca;
    private boolean terrenoLamacento;

    /**
     * Construtor do ambiente de Lago e Rio com características definidas.
     */
    public AmbienteLagoRio() {
        super("Lago e Rio", "Uma área rica em água, mas perigosa devido às criaturas aquáticas.", 2, "Úmido");
        this.aguaAbundante = true;
        this.possibilidadePesca = true;
        this.terrenoLamacento = true;
    }

    // Getters e Setters
    public boolean isAguaAbundante() { return aguaAbundante; }
    public void setAguaAbundante(boolean aguaAbundante) { this.aguaAbundante = aguaAbundante; }

    public boolean isPossibilidadePesca() { return possibilidadePesca; }
    public void setPossibilidadePesca(boolean possibilidadePesca) { this.possibilidadePesca = possibilidadePesca; }

    public boolean isTerrenoLamacento() { return terrenoLamacento; }
    public void setTerrenoLamacento(boolean terrenoLamacento) { this.terrenoLamacento = terrenoLamacento; }

    /**
     * Exibe uma mensagem personalizada ao explorar o lago ou rio.
     */
    @Override
    public void explorar() {
        System.out.println("Você se aproxima do lago, observando as águas cristalinas.");
        super.explorar();
    }
}