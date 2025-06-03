package models.Personagens;

import models.Itens.Item;
import models.Itens.ItemRemedios;

/**
 * Classe que representa o personagem Médico.
 * Possui a habilidade especial de curar usando remédios do inventário.
 */
public class Medico extends Personagem {

    /**
     * Construtor da classe Medico.
     *
     * @param nome Nome do personagem.
     * @param vida Vida inicial.
     * @param fome Fome inicial.
     * @param sede Sede inicial.
     * @param energia Energia inicial.
     * @param sanidade Sanidade inicial.
     * @param localizacao Localização inicial.
     */
    public Medico(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    /**
     * Habilidade especial do Médico.
     * Usa remédios do inventário para curar e recuperar vida.
     */
    @Override
    public void habilidadeEspecial() {
        System.out.println(getNome() + " está usando sua habilidade de curar.");

        for (Item item : getInventario().getListaItens()) {
            if (item instanceof ItemRemedios) {
                System.out.println(getNome() + " usou o remédio: " + item.getNome());
                setVida(getVida() + 20);
                item.usar(this); 
            }
        }
    }
}
