package models.Personagens;

import models.Itens.Item;
import models.Itens.ItemRemedios;

/**
 * Classe que representa o personagem Médico.
 * Possui a habilidade especial de curar usando remédios do inventário.
 */
public class Medico extends Personagem {

    /**
     * Construtor do Médico.
     */
    public Medico(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    /**
     * Habilidade especial do médico: usa remédios para curar e recuperar vida.
     */
    @Override
    public void habilidadeEspecial() {
        System.out.println(this.getNome() + " está usando sua habilidade de curar.");

        for (Item item : getInventario().getListaItens()) {
            if (item instanceof ItemRemedios) {
                System.out.println("💊 " + this.getNome() + " usou o remédio: " + item.getNome());
                this.setVida(this.getVida() + 20);
                item.usar();
            }
        }
    }
}

