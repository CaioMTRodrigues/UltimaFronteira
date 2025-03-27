package models.Itens;

public class ItemFerramentas extends Item {

    private String tipo;
    private int eficiencia;

    // Construtor que inicializa os dados do item Ferramenta
    public ItemFerramentas(String nome, double peso, int durabilidade, String tipo, int eficiencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    // Métodos de Acesso
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }
    public int getEficiencia() { return eficiencia; }
    public void setEficiencia(int eficiencia) { this.eficiencia = eficiencia; }

    // Método sobrescrito para usar o item Ferramenta
    @Override
    public void usar() {
        System.out.println("🛠 Você usou " + getNome() + " (" + tipo + ") com eficiência de " + eficiencia + ".");
        reduzirDurabilidade();
    }
}
