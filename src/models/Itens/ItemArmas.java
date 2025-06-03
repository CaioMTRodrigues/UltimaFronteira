package models.Itens;

import models.Personagens.Personagem;

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

    /**
     * Retorna o tipo da arma.
     *
     * @return O tipo da arma.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da arma.
     *
     * @param tipo Tipo da arma.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o valor de dano da arma.
     *
     * @return Valor de dano.
     */
    public int getDano() {
        return dano;
    }

    /**
     * Define o valor de dano da arma.
     *
     * @param dano Valor de dano.
     */
    public void setDano(int dano) {
        this.dano = dano;
    }

    /**
     * Usa a arma causando dano (a mecânica de dano real pode ser definida no futuro).
     *
     * @param personagem O personagem que está usando a arma.
     */
    @Override
    public void usar(Personagem personagem) {
        System.out.println("Você atacou com " + getNome() + " (" + tipo + "), causando " + dano + " de dano.");
        reduzirDurabilidade();
    }
}
