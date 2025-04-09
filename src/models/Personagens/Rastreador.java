package models.Personagens;

import models.Itens.Item;
import models.Itens.ItemAgua;
import models.Itens.ItemAlimento;

/**
 * Classe que representa o personagem Rastreador.
 * Tem facilidade em encontrar água e alimentos no inventário.
 */
public class Rastreador extends Personagem {

    /**
     * Construtor do Rastreador.
     */
    public Rastreador(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    /**
     * Habilidade especial: localiza alimentos e água no inventário e reduz fome/sede.
     */
    @Override
    public void habilidadeEspecial() {
        System.out.println(this.getNome() + " está rastreando alimentos e água...");

        for (Item item : getInventario().getListaItens()) {
            if (item instanceof ItemAlimento) {
                System.out.println("🍏 Encontrado alimento: " + item.getNome());
                this.setFome(this.getFome() - 10);
            } else if (item instanceof ItemAgua) {
                System.out.println("💧 Encontrado água: " + item.getNome());
                this.setSede(this.getSede() - 10);
            }
        }
    }
}







