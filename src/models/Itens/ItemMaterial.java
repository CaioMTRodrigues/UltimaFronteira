package models.Itens;

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

    // Getters e Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getResistencia() { return resistencia; }
    public void setResistencia(int resistencia) { this.resistencia = resistencia; }

    /**
     * Usa o material para fins de construção ou conserto.
     */
    @Override
    public void usar() {
        System.out.println(" Usando " + getNome() + " para criar ou consertar algo.");
        reduzirDurabilidade();
    }

    /**
     * Combina dois materiais e retorna um novo material.
     *
     * @param outroMaterial Outro material a combinar.
     * @return Novo item combinado.
     */
    public ItemMaterial combinar(ItemMaterial outroMaterial) {
        System.out.println(" Combinando " + getNome() + " com " + outroMaterial.getNome());
        return new ItemMaterial(
            "Material Combinado",
            getPeso() + outroMaterial.getPeso(),
            getDurabilidade(),
            "Combinado",
            (getResistencia() + outroMaterial.getResistencia()) / 2
        );
    }
}

