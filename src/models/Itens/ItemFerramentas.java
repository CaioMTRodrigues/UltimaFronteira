package models.Itens;

public class ItemFerramentas extends Item {

    private String tipo;        // Tipo de ferramenta (ex: "machado", "ferramenta de construção")
    private int eficiencia;     // Eficiência da ferramenta (quanto mais alta, mais eficaz)

    // Construtor que inicializa os dados do item Ferramenta
    public ItemFerramentas(String nome, double peso, int durabilidade, String tipo, int eficiencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEficiencia() {
        return eficiencia;
    }

    public void setEficiencia(int eficiencia) {
        this.eficiencia = eficiencia;
    }

    // Método sobrescrito para usar o item Ferramenta
    @Override
    public void usar() {
        System.out.println("🛠 Você usou " + getNome() + " (" + tipo + ") com eficiência de " + eficiencia + ".");
        reduzirDurabilidade();
    }
}


