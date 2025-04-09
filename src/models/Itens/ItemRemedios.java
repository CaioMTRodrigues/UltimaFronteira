package models.Itens;

/**
 * Representa um item do tipo remédio, utilizado para recuperar atributos.
 */
public class ItemRemedios extends Item {

    private String tipo;
    private String efeito;

    /**
     * Construtor do item remédio.
     *
     * @param nome Nome do item.
     * @param peso Peso do item.
     * @param durabilidade Número de usos.
     * @param tipo Tipo do remédio.
     * @param efeito Efeito do remédio (ex: cura, antídoto).
     */
    public ItemRemedios(String nome, double peso, int durabilidade, String tipo, String efeito) {
        super(nome, peso, durabilidade);
        this.tipo = tipo;
        this.efeito = efeito;
    }

    // Getters e Setters
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public String getEfeito() { return efeito; }
    public void setEfeito(String efeito) { this.efeito = efeito; }

    /**
     * Usa o remédio, aplicando seu efeito.
     */
    @Override
    public void usar() {
        System.out.println(" Você usou " + getNome() + ". Efeito: " + efeito);
        reduzirDurabilidade();
    }
}




