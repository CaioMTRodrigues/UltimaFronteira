package models.Itens;

public class ItemArmas extends Item {
    private String tipo;  // Tipo de arma (ex: "corpo a corpo", "à distância")
    private int dano;     // Dano causado pela arma

    // Construtor
    public ItemArmas(String nome, double peso, int durabilidade, String tipo, int dano) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.dano = dano;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getDano() {
        return dano;
    }

    public void setDano(int dano) {
        this.dano = dano;
    }

    // Método para atacar
    public void atacar() {
        System.out.println("⚔ " + getNome() + " foi usado para atacar, causando " + dano + " de dano!");
        reduzirDurabilidade();
    }

    // Sobrescrita do método usar
    @Override
    public void usar() {
        System.out.println("⚔ Você atacou com " + getNome() + ", causando " + dano + " de dano.");
        reduzirDurabilidade();
    }
}
