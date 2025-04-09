package models.Ambientes;

/**
 * Classe que representa o ambiente de Caverna.
 * Um ambiente escuro, úmido e potencialmente perigoso.
 */
public class AmbienteCaverna extends Ambiente {

    private boolean poucaLuz;
    private boolean criaturasPresentes;
    private boolean aguaDeGotejamento;

    /**
     * Construtor da caverna, definindo suas características padrão.
     */
    public AmbienteCaverna() {
        super("Caverna", "Uma caverna escura e úmida, cheia de mistérios.", 4, "Frio e úmido");
        this.poucaLuz = true;
        this.criaturasPresentes = true;
        this.aguaDeGotejamento = true;
    }

    // Getters e Setters
    public boolean isPoucaLuz() { return poucaLuz; }
    public void setPoucaLuz(boolean poucaLuz) { this.poucaLuz = poucaLuz; }

    public boolean isCriaturasPresentes() { return criaturasPresentes; }
    public void setCriaturasPresentes(boolean criaturasPresentes) { this.criaturasPresentes = criaturasPresentes; }

    public boolean isAguaDeGotejamento() { return aguaDeGotejamento; }
    public void setAguaDeGotejamento(boolean aguaDeGotejamento) { this.aguaDeGotejamento = aguaDeGotejamento; }

    /**
     * Exibe uma mensagem personalizada ao explorar a caverna.
     */
    @Override
    public void explorar() {
        System.out.println("Você entra na caverna, sua lanterna ilumina as paredes úmidas.");
        super.explorar();
    }
}
