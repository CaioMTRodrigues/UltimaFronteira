package models.Itens;

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

    // Getters e Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getEficiencia() { return eficiencia; }
    public void setEficiencia(int eficiencia) { this.eficiencia = eficiencia; }

    /**
     * Usa a ferramenta, reduzindo sua durabilidade.
     */
    @Override
    public void usar() {
        System.out.println(" Você usou " + getNome() + " (" + tipo + ") com eficiência de " + eficiencia + ".");
        reduzirDurabilidade();
    }
}
