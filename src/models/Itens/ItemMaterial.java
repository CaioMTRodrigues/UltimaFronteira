package models.Itens;

public class ItemMaterial extends Item {
    private String tipo;        // Tipo de material (ex: "madeira", "pedra", "metal")
    private int resistencia;    // Resistência do material (impacta na durabilidade de ferramentas)

    // Construtor
    public ItemMaterial(String nome, double peso, int durabilidade, String tipo, int resistencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getResistencia() {
        return resistencia;
    }

    public void setResistencia(int resistencia) {
        this.resistencia = resistencia;
    }

    // Método sobrescrito de usar
    @Override
    public void usar() {
        System.out.println("🔨 Usando " + getNome() + " para criar ou consertar algo.");
        reduzirDurabilidade();
    }

    // Método para combinar dois materiais e criar um novo material
    public ItemMaterial combinar(ItemMaterial outroMaterial) {
        System.out.println("🛠 Combinando " + getNome() + " com " + outroMaterial.getNome());
        return new ItemMaterial("Material Combinado", getPeso() + outroMaterial.getPeso(), getDurabilidade(), "Combinado", (getResistencia() + outroMaterial.getResistencia()) / 2);
    }
}
