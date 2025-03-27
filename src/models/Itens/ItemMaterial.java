package models.Itens;

public class ItemMaterial extends Item {

    private String tipo;
    private int resistencia;

    // Construtor que inicializa os dados do item Material
    public ItemMaterial(String nome, double peso, int durabilidade, String tipo, int resistencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    // Métodos de Acesso
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getResistencia() { return resistencia; }
    public void setResistencia(int resistencia) { this.resistencia = resistencia; }

    // Método sobrescrito para usar o item Material
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

