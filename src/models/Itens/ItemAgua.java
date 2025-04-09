package models.Itens;

/**
 * Representa um item do tipo Água, que pode ser potável ou não.
 */
public class ItemAgua extends Item {

    private boolean potavel;
    private double volume;

    /**
     * Construtor do item Água.
     *
     * @param nome Nome do item.
     * @param peso Peso do item.
     * @param durabilidade Número de usos.
     * @param potavel Se é potável ou não.
     * @param volume Volume de água.
     */
    public ItemAgua(String nome, double peso, int durabilidade, boolean potavel, double volume) {
        super(nome, peso, durabilidade);
        this.potavel = potavel;
        this.volume = volume;
    }

    // Getters e Setters
    public boolean isPotavel() { return potavel; }
    public void setPotavel(boolean potavel) { this.potavel = potavel; }

    public double getVolume() { return volume; }
    public void setVolume(double volume) { this.volume = volume; }

    /**
     * Usa o item Água, restaurando sede ou alertando sobre contaminação.
     */
    @Override
    public void usar() {
        if (potavel) {
            System.out.println(" Você bebeu " + volume + "L de água potável.");
        } else {
            System.out.println(" Cuidado! Esta água pode estar contaminada.");
        }
        reduzirDurabilidade();
    }
}


