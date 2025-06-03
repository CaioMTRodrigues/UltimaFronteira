package models.Itens;

import models.Personagens.Personagem;

/**
 * Representa um item do tipo ferramenta, como machado ou isqueiro.
 */
public class ItemFerramentas extends Item {

    private String tipo;
    private int eficiencia;

    /**
     * Construtor do item ferramenta.
     *
     * @param nome Nome da ferramenta.
     * @param peso Peso da ferramenta.
     * @param durabilidade Número de usos.
     * @param tipo Tipo da ferramenta.
     * @param eficiencia Nível de eficiência (impacta coleta, por exemplo).
     */
    public ItemFerramentas(String nome, double peso, int durabilidade, String tipo, int eficiencia) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.eficiencia = eficiencia;
    }

    /**
     * Retorna o tipo da ferramenta.
     *
     * @return Tipo da ferramenta.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo da ferramenta.
     *
     * @param tipo Tipo da ferramenta.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna a eficiência da ferramenta.
     *
     * @return Eficiência da ferramenta.
     */
    public int getEficiencia() {
        return eficiencia;
    }

    /**
     * Define a eficiência da ferramenta.
     *
     * @param eficiencia Valor da eficiência.
     */
    public void setEficiencia(int eficiencia) {
        this.eficiencia = eficiencia;
    }

    /**
     * Usa a ferramenta, exibindo informações e reduzindo a durabilidade.
     *
     * @param personagem O personagem que está utilizando a ferramenta.
     */
    @Override
    public void usar(Personagem personagem) {
        System.out.println("Você usou " + getNome() + " (" + tipo + ") com eficiência de " + eficiencia + ".");
        reduzirDurabilidade();
    }
}