package models.Ambientes;

public class AmbienteLagoRio extends Ambiente {

    private boolean aguaAbundante;
    private boolean possibilidadePesca;
    private boolean terrenoLamacento;

    public AmbienteLagoRio() {
        super("Lago e Rio", "Uma área rica em água, mas perigosa devido às criaturas aquáticas.", 2, "Úmido");
        this.aguaAbundante = true;
        this.possibilidadePesca = true;
        this.terrenoLamacento = true;
    }

    @Override
    public void explorar() {
        System.out.println("Você se aproxima do lago, observando as águas cristalinas.");
        super.explorar();
    }
}

