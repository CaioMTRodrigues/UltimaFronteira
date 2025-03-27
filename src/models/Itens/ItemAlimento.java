package models.Itens;

public class ItemAlimento extends Item {

    private int valorNutricional;
    private String tipo;
    private int prazoValidade;

    // Construtor que inicializa os dados do item Alimento
    public ItemAlimento(String nome, double peso, int durabilidade, int valorNutricional, String tipo, int prazoValidade) {
        super(nome, peso, durabilidade);
        this.valorNutricional = valorNutricional;
        this.tipo = tipo;
        this.prazoValidade = prazoValidade;
    }

    // Métodos de Acesso
    public int getValorNutricional() { return valorNutricional; }
    public void setValorNutricional(int valorNutricional) { this.valorNutricional = valorNutricional; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getPrazoValidade() { return prazoValidade; }
    public void setPrazoValidade(int prazoValidade) { this.prazoValidade = prazoValidade; }

    // Método sobrescrito para usar o item Alimento
    @Override
    public void usar() {
        System.out.println("🍏 Você consumiu " + getNome() + ". Restaurou " + valorNutricional + " pontos de fome.");
        if (prazoValidade <= 0) {
            System.out.println("⚠ Este alimento está vencido, pode causar intoxicação.");
        }
        reduzirDurabilidade();
    }
}

