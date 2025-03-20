package models.Itens;

public class ItemAgua extends Item {
    private boolean potavel; // Se a água é potável ou não
    private double volume;   // Volume de água disponível

    // Construtor
    public ItemAgua(String nome, double peso, int durabilidade, boolean potavel, double volume) {
        super(nome, peso, durabilidade);
        this.potavel = potavel;
        this.volume = volume;
    }

    // Métodos de Acesso (Getters e Setters)
    public boolean isPotavel() {
        return potavel;
    }

    public void setPotavel(boolean potavel) {
        this.potavel = potavel;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    // Método sobrescrito de usar
    @Override
    public void usar() {
        if (potavel) {
            System.out.println("💧 Você bebeu " + volume + "L de água potável.");
        } else {
            System.out.println("⚠ Cuidado! Esta água pode estar contaminada.");
        }
        reduzirDurabilidade();
    }
}
