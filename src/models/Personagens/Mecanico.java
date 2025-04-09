package models.Personagens;

import models.Itens.Item;
import models.Itens.ItemFerramentas;

/**
 * Classe que representa o personagem Mecânico.
 * Sua habilidade especial permite consertar ferramentas no inventário.
 */
public class Mecanico extends Personagem {

    /**
     * Construtor do Mecânico.
     */
    public Mecanico(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    /**
     * Habilidade especial: conserta ferramentas, aumentando sua durabilidade.
     */
    @Override
    public void habilidadeEspecial() {
        System.out.println(this.getNome() + " está consertando ferramentas.");

        for (Item item : getInventario().getListaItens()) {
            if (item instanceof ItemFerramentas) {
                System.out.println("🔧 " + this.getNome() + " consertou: " + item.getNome());
                item.setDurabilidade(item.getDurabilidade() + 10);
            }
        }
    }
}




