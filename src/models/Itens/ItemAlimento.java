package models.Itens;

/**
 * Representa um item de alimento, que pode restaurar pontos de fome.
 */
public class ItemAlimento extends Item {

    private int valorNutricional;
    private String tipo;
    private int prazoValidade;

    /**
     * Construtor do item Alimento.
     *
     * @param nome Nome do alimento.
     * @param peso Peso do alimento.
     * @param durabilidade Número de usos.
     * @param valorNutricional Valor nutricional que reduz a fome.
     * @param tipo Tipo do alimento (fruta, carne, etc).
     * @param prazoValidade Número de turnos antes de estragar.
     */
    public ItemAlimento(String nome, double peso, int durabilidade, int valorNutricional, String tipo, int prazoValidade) {
        super(nome, peso, durabilidade);
        this.valorNutricional = valorNutricional;
        this.tipo = tipo;
        this.prazoValidade = prazoValidade;
    }

    // Getters e Setters
    public int getValorNutricional() { return valorNutricional; }
    public void setValorNutricional(int valorNutricional) { this.valorNutricional = valorNutricional; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getPrazoValidade() { return prazoValidade; }
    public void setPrazoValidade(int prazoValidade) { this.prazoValidade = prazoValidade; }

    /**
     * Usa o item alimento, restaurando fome e verificando validade.
     */
    @Override
    public void usar() {
        System.out.println(" Você consumiu " + getNome() + ". Restaurou " + valorNutricional + " pontos de fome.");
        if (prazoValidade <= 0) {
            System.out.println(" Este alimento está vencido, pode causar intoxicação.");
        }
        reduzirDurabilidade();
    }
}


