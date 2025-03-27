package models.Itens;

public abstract class Item {

    private String nome; // Nome do item
    private double peso; // Peso do item
    private int durabilidade; // Durabilidade do item

    // Construtor que inicializa os dados principais do item
    public Item(String nome, double peso, int durabilidade) {
        this.nome = nome;
        this.peso = peso;
        this.durabilidade = durabilidade;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public int getDurabilidade() {
        return durabilidade;
    }

    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }

    // Método para reduzir a durabilidade do item
    public void reduzirDurabilidade() {
        if (durabilidade > 0) {
            durabilidade--;
            System.out.println(nome + " agora tem durabilidade: " + durabilidade);
        } else {
            System.out.println(nome + " está quebrado e não pode ser usado.");
        }
    }

    // Método abstrato que será implementado nas subclasses
    public abstract void usar();
}
