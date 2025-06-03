package models.Itens;

import models.Personagens.Personagem;

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

    /**
     * Retorna o nome do item.
     *
     * @return O nome do item.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Define o nome do item.
     *
     * @param nome O nome a ser atribuído ao item.
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Retorna o peso do item.
     *
     * @return O peso do item.
     */
    public double getPeso() {
        return peso;
    }

    /**
     * Define o peso do item.
     *
     * @param peso O peso a ser atribuído ao item.
     */
    public void setPeso(double peso) {
        this.peso = peso;
    }

    /**
     * Retorna a durabilidade do item.
     *
     * @return A durabilidade do item.
     */
    public int getDurabilidade() {
        return durabilidade;
    }

    /**
     * Define a durabilidade do item.
     *
     * @param durabilidade A durabilidade a ser atribuída ao item.
     */
    public void setDurabilidade(int durabilidade) {
        this.durabilidade = durabilidade;
    }

    /**
     * Reduz a durabilidade do item após o uso.
     * Caso a durabilidade seja zero, o item não pode ser utilizado.
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
     * Deve receber o personagem para alterar seus atributos.
     *
     * @param personagem O personagem que utilizará o item.
     */
    public abstract void usar(Personagem personagem);

    /**
     * Permite ordenação de itens por nome (ignorando maiúsculas/minúsculas).
     *
     * @param outro O outro item a ser comparado.
     * @return Um valor inteiro indicando a ordem relativa dos itens.
     */
    @Override
    public int compareTo(Item outro) {
        return this.nome.compareToIgnoreCase(outro.getNome());
    }

    /**
     * Compara o nome do item com outro nome, ignorando maiúsculas e minúsculas.
     *
     * @param outroNome O nome a ser comparado com o nome do item.
     * @return true se os nomes forem iguais, false caso contrário.
     */
    public boolean nomeEquals(String outroNome) {
        return this.nome.equalsIgnoreCase(outroNome);
    }
}
