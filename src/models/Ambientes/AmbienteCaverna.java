package models.Ambientes;

public class AmbienteCaverna extends Ambiente {

    private boolean poucaLuz;
    private boolean criaturasPresentes;
    private boolean aguaDeGotejamento;

    // Construtor que inicializa os atributos específicos da caverna
    public AmbienteCaverna() {
        super("Caverna", "Uma caverna escura e úmida, cheia de mistérios.", 4, "Frio e úmido");
        this.poucaLuz = true;
        this.criaturasPresentes = true;
        this.aguaDeGotejamento = true;
    }

    // Métodos de Acesso
    public boolean isPoucaLuz() { return poucaLuz; }
    public void setPoucaLuz(boolean poucaLuz) { this.poucaLuz = poucaLuz; }
    public boolean isCriaturasPresentes() { return criaturasPresentes; }
    public void setCriaturasPresentes(boolean criaturasPresentes) { this.criaturasPresentes = criaturasPresentes; }
    public boolean isAguaDeGotejamento() { return aguaDeGotejamento; }
    public void setAguaDeGotejamento(boolean aguaDeGotejamento) { this.aguaDeGotejamento = aguaDeGotejamento; }

    // Método sobrescrito para explorar o ambiente, agora inclui características específicas da caverna
    @Override
    public void explorar() {
        System.out.println("Você entra na caverna, sua lanterna ilumina as paredes úmidas.");
        super.explorar();
    }
}