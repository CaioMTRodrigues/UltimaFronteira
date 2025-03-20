package models.Ambientes;

public class AmbienteCaverna extends Ambiente {

    private boolean poucaLuz;          // Se há pouca luz na caverna
    private boolean criaturasPresentes; // Se há criaturas presentes na caverna
    private boolean aguaDeGotejamento; // Se há água de gotejamento na caverna

    // Construtor
    public AmbienteCaverna() {
        super("Caverna", "Uma caverna escura e úmida, cheia de mistérios.", 4, "Frio e úmido");
        this.poucaLuz = true;
        this.criaturasPresentes = true;
        this.aguaDeGotejamento = true;
    }

    // Métodos de Acesso (Getters e Setters)
    public boolean isPoucaLuz() {
        return poucaLuz;
    }

    public void setPoucaLuz(boolean poucaLuz) {
        this.poucaLuz = poucaLuz;
    }

    public boolean isCriaturasPresentes() {
        return criaturasPresentes;
    }

    public void setCriaturasPresentes(boolean criaturasPresentes) {
        this.criaturasPresentes = criaturasPresentes;
    }

    public boolean isAguaDeGotejamento() {
        return aguaDeGotejamento;
    }

    public void setAguaDeGotejamento(boolean aguaDeGotejamento) {
        this.aguaDeGotejamento = aguaDeGotejamento;
    }

    // Método sobrescrito para explorar o ambiente
    @Override
    public void explorar() {
        System.out.println("Você entra na caverna, sua lanterna ilumina as paredes úmidas.");
        super.explorar();
    }
}

