package models.Ambientes;

public class AmbienteCaverna extends Ambiente {

    private boolean poucaLuz;
    private boolean criaturasPresentes;
    private boolean aguaDeGotejamento;

    public AmbienteCaverna() {
        super("Caverna", "Uma caverna escura e úmida, cheia de mistérios.", 4, "Frio e úmido");
        this.poucaLuz = true;
        this.criaturasPresentes = true;
        this.aguaDeGotejamento = true;
    }

    @Override
    public void explorar() {
        System.out.println("Você entra na caverna, sua lanterna ilumina as paredes úmidas.");
        super.explorar();
    }
}
