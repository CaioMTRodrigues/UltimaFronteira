package models.Itens;

/**
 * Representa um item do tipo arma, utilizado para ataque.
 */
public class ItemArmas extends Item {

    private String tipo;
    private int dano;

    /**
     * Construtor do item arma.
     *
     * @param nome Nome da arma.
     * @param peso Peso da arma.
     * @param durabilidade Número de usos.
     * @param tipo Tipo da arma (corpo-a-corpo, distância).
     * @param dano Valor de dano causado.
     */
    public ItemArmas(String nome, double peso, int durabilidade, String tipo, int dano) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.dano = dano;
    }

    // Getters e Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getDano() { return dano; }
    public void setDano(int dano) { this.dano = dano; }

    /**
     * Executa o ataque com a arma.
     */
    public void atacar() {
        System.out.println(getNome() + " foi usado para atacar, causando " + dano + " de dano!");
        reduzirDurabilidade();
    }

    /**
     * Usa a arma como item genérico.
     */
    @Override
    public void usar() {
        System.out.println(" Você atacou com " + getNome() + " (" + tipo + "), causando " + dano + " de dano.");
        reduzirDurabilidade();
    }
}


