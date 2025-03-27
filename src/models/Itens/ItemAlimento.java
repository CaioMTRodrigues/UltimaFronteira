package models.Itens;

public class ItemAlimento extends Item {

    private int valorNutricional; // Valor nutricional (quantidade de fome restaurada)
    private String tipo;         // Tipo de alimento (ex: "fruta", "carne", etc.)
    private int prazoValidade;   // Prazo de validade do alimento

    // Construtor que inicializa os dados do item Alimento
    public ItemAlimento(String nome, double peso, int durabilidade, int valorNutricional, String tipo, int prazoValidade) {
        super(nome, peso, durabilidade);
        this.valorNutricional = valorNutricional;
        this.tipo = tipo;
        this.prazoValidade = prazoValidade;
    }

    // Métodos de Acesso (Getters e Setters)
    public int getValorNutricional() {
        return valorNutricional;
    }

    public void setValorNutricional(int valorNutricional) {
        this.valorNutricional = valorNutricional;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getPrazoValidade() {
        return prazoValidade;
    }

    public void setPrazoValidade(int prazoValidade) {
        this.prazoValidade = prazoValidade;
    }

    // Método sobrescrito para usar o item Alimento
    @Override
    public void usar() {
        System.out.println("🍏 Você consumiu " + getNome() + ". Restaurou " + valorNutricional + " pontos de fome.");
        reduzirDurabilidade();
    }
}
