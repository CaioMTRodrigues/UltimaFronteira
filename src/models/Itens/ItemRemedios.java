package models.Itens;

import models.Personagens.Personagem;

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

    /**
     * Retorna o tipo do remédio.
     *
     * @return Tipo do remédio.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do remédio.
     *
     * @param tipo Tipo do remédio.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o efeito do remédio.
     *
     * @return Efeito do remédio.
     */
    public String getEfeito() {
        return efeito;
    }

    /**
     * Define o efeito do remédio.
     *
     * @param efeito Efeito a ser definido.
     */
    public void setEfeito(String efeito) {
        this.efeito = efeito;
    }

    /**
     * Usa o remédio, aplicando seu efeito ao personagem.
     *
     * @param personagem O personagem que utilizará o remédio.
     */
    @Override
    public void usar(Personagem personagem) {
        System.out.println("Você usou " + getNome() + ". Efeito: " + efeito);
        reduzirDurabilidade();
    }
}
