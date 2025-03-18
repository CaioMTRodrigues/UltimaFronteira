package models.Itens;
public class ItemAgua extends Item {
    private boolean potavel; 
    private double volume; 

    public ItemAgua(String nome, double peso, int durabilidade, boolean potavel, double volume) {
        super(nome, peso, durabilidade);
        this.potavel = potavel;
        this.volume = volume;
    }

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