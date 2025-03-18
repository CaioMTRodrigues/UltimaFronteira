package models.Itens;
public class ItemArmas extends Item{
    private String tipo; 
    private int dano; 

    public ItemArmas(String nome, double peso, int durabilidade, String tipo, int dano) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.dano = dano;
    }

    public void atacar() {
    System.out.println("⚔ " + nome + " foi usado para atacar, causando " + dano + " de dano!");
    reduzirDurabilidade();
    }
    
    public int getDano() {
        return dano;
    }
    

    @Override
    public void usar() {
        System.out.println("⚔ Você atacou com " + nome + ", causando " + dano + " de dano.");
        reduzirDurabilidade();
    }

}