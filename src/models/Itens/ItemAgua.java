package models.Itens;

import models.Personagens.Personagem;

/**
 * Representa um item do tipo Água, que pode ser potável ou não.
 */
public class ItemAgua extends Item {

    private boolean potavel;
    private double volume;

    /**
     * Construtor do item Água.
     *
     * @param nome Nome do item.
     * @param peso Peso do item.
     * @param durabilidade Número de usos.
     * @param potavel Indica se a água é potável.
     * @param volume Volume de água em litros.
     */
    public ItemAgua(String nome, double peso, int durabilidade, boolean potavel, double volume) {
        super(nome, peso, durabilidade);
        this.potavel = potavel;
        this.volume = volume;
    }

    /**
     * Retorna se a água é potável.
     *
     * @return true se for potável, false caso contrário.
     */
    public boolean isPotavel() {
        return potavel;
    }

    /**
     * Define se a água é potável.
     *
     * @param potavel true para potável, false caso contrário.
     */
    public void setPotavel(boolean potavel) {
        this.potavel = potavel;
    }

    /**
     * Retorna o volume da água.
     *
     * @return Volume em litros.
     */
    public double getVolume() {
        return volume;
    }

    /**
     * Define o volume da água.
     *
     * @param volume Volume em litros.
     */
    public void setVolume(double volume) {
        this.volume = volume;
    }

    /**
     * Usa o item Água. Se for potável, reduz a sede e aumenta levemente a fome do personagem.
     * 
     * @param personagem O personagem que está utilizando o item.
     */
    @Override
    public void usar(Personagem personagem) {
        if (potavel) {
            System.out.println("Você bebeu " + volume + "L de água potável.");
            personagem.setSede(Math.max(0, personagem.getSede() - 25));
            personagem.setFome(Math.min(100, personagem.getFome() + 5));
        } else {
            System.out.println("Cuidado! Esta água pode estar contaminada.");
            personagem.setSede(Math.max(0, personagem.getSede() - 10));
            personagem.setSanidade(Math.max(0, personagem.getSanidade() - 10));
        }
        reduzirDurabilidade();
    }
}



