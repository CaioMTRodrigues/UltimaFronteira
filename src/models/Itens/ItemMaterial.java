package models.Itens;
public class ItemMaterial extends Item{
    private String tipo; 
    private int resistencia; 

    public ItemMaterial(String nome, double peso, int durabilidade, String tipo, int resistencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.resistencia = resistencia;
    }

    @Override
    public void usar() {
        System.out.println("🔨 Usando " + nome + " para criar ou consertar algo.");
        reduzirDurabilidade();
    }

    public ItemMaterial combinar(ItemMaterial outroMaterial) {
        System.out.println("🛠 Combinando " + nome + " com " + outroMaterial.getNome());
        return new ItemMaterial("Material Combinado", peso + outroMaterial.getPeso(), durabilidade, "Combinado", (resistencia + outroMaterial.resistencia) / 2);
    }

}
