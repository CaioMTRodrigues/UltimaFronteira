package models.Itens;

import models.Personagens.Personagem;

/**
 * Representa um item de material, utilizado para fabricar ou combinar.
 */
public class ItemMaterial extends Item {

    private String tipo;
    private int resistencia;

    /**
     * Construtor do item material.
     *
     * @param nome Nome do item.
     * @param peso Peso do item.
     * @param durabilidade Número de usos.
     * @param tipo Tipo do material (madeira, pedra, etc).
     * @param resistencia Nível de resistência do material.
     */
    public ItemMaterial(String nome, double peso, int durabilidade, String tipo, int resistencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    /**
     * Retorna o tipo do material.
     *
     * @return Tipo do material.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do material.
     *
     * @param tipo Tipo a ser definido.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o nível de resistência do material.
     *
     * @return Resistência do material.
     */
    public int getResistencia() {
        return resistencia;
    }

    /**
     * Define a resistência do material.
     *
     * @param resistencia Nível de resistência.
     */
    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    /**
     * Usa o material para fins de criação ou conserto.
     *
     * @param personagem O personagem que está utilizando o material.
     */
    @Override
    public void usar(Personagem personagem) {
        System.out.println("Você usou " + getNome() + " para criar ou consertar algo.");
        reduzirDurabilidade();
    }

    /**
     * Combina este material com outro e gera um novo item material.
     *
     * @param outroMaterial Outro material a ser combinado.
     * @return Novo item material resultante da combinação.
     */
    public ItemMaterial combinar(ItemMaterial outroMaterial) {
        System.out.println("Combinando " + getNome() + " com " + outroMaterial.getNome());
        return new ItemMaterial(
            "Material Combinado",
            getPeso() + outroMaterial.getPeso(),
            getDurabilidade(),
            "Combinado",
            (getResistencia() + outroMaterial.getResistencia()) / 2
        );
    }
}
