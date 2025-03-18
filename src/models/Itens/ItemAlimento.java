package models.Itens;

public class ItemAlimento extends Item{
    protected  int valorNutricional; 
    protected  String tipo; 
    protected  int prazoValidade; 

    public ItemAlimento(String nome, double peso, int durabilidade, int valorNutricional, String tipo, int prazoValidade) {
        super(nome, peso, durabilidade);
        this.valorNutricional = valorNutricional;
        this.tipo = tipo;
        this.prazoValidade = prazoValidade;
    }

    public int getValorNutricional() {
        return valorNutricional;
    }

    @Override
    public void usar() {
        System.out.println("🍏 Você consumiu " + nome + ". Restaurou " + valorNutricional + " pontos de fome.");
        reduzirDurabilidade();
    }

}