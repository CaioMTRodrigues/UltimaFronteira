package models.Personagens;

import models.Itens.ItemRemedios;
import models.Itens.Item;

public class Medico extends Personagem {

    public Medico(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    // Implementação da habilidade especial do médico
    @Override
    public void habilidadeEspecial() {
        System.out.println(this.getNome() + " está usando sua habilidade de curar.");

        // Exemplo de uso de remédios no inventário
        for (Item item : getInventario()) {
            if (item instanceof ItemRemedios) {
                System.out.println(this.getNome() + " usou o remédio: " + item.getNome());
                // Recupera vida ou sanidade do personagem
                this.setVida(this.getVida() + 20);  // Exemplo de cura
            }
        }
    }
}