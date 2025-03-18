package models.Itens;
public class ItemFerramentas extends Item{
    private String tipo; 
    private int eficiencia; 

    public ItemFerramentas(String nome, double peso, int durabilidade, String tipo, int eficiencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    @Override
    public void usar() {
        System.out.println("🛠 Você usou " + nome + " (" + tipo + ") com eficiência de " + eficiencia + ".");
        reduzirDurabilidade();
    }

}
