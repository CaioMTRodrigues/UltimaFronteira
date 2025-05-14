package models.Itens;

/**
 * Classe abstrata que representa um item genérico no jogo.
 * Todos os itens herdam dessa classe e implementam o método usar().
 */
public abstract class Item implements Comparable<Item> {

    private String nome;
    private double peso;
    private int durabilidade;

    /**
     * Construtor do item.
     *
     * @param nome Nome do item.
     * @param peso Peso do item.
     * @param durabilidade Durabilidade do item.
     */
    public Item(String nome, double peso, int durabilidade) {
        this.nome = nome;
        this.peso = peso;
        this.durabilidade = durabilidade;
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public double getPeso() { return peso; }
    public void setPeso(double peso) { this.peso = peso; }

    public int getDurabilidade() { return durabilidade; }
    public void setDurabilidade(int durabilidade) { this.durabilidade = durabilidade; }

    /**
     * Reduz a durabilidade do item após o uso.
     */
    public void reduzirDurabilidade() {
        if (durabilidade > 0) {
            durabilidade--;
            System.out.println(nome + " agora tem durabilidade: " + durabilidade);
        } else {
            System.out.println(nome + " está quebrado e não pode ser usado.");
        }
    }

    /**
     * Método abstrato para uso do item, definido pelas subclasses.
     */
    public abstract void usar();

    /**
     * Permite ordenação de itens por nome (ignorando maiúsculas/minúsculas).
     */
    @Override
    public int compareTo(Item outro) {
        return this.nome.compareToIgnoreCase(outro.getNome());
    }
}
