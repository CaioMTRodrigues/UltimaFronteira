package models.Itens;

public class ItemArmas extends Item {

    private String tipo;
    private int dano;

    // Construtor que inicializa os dados do item Arma
    public ItemArmas(String nome, double peso, int durabilidade, String tipo, int dano) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.dano = dano;
    }

    // Métodos de Acesso
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getDano() { return dano; }
    public void setDano(int dano) { this.dano = dano; }

    // Método para atacar com a arma
    public void atacar() {
        System.out.println("⚔ " + getNome() + " foi usado para atacar, causando " + dano + " de dano!");
        reduzirDurabilidade();
    }

    // Sobrescrita do método usar para armas
    @Override
    public void usar() {
        System.out.println("⚔ Você atacou com " + getNome() + " (" + tipo + "), causando " + dano + " de dano.");
        reduzirDurabilidade();
    }
}

