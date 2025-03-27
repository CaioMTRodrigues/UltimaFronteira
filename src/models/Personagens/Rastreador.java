package models.Personagens;

import models.Itens.ItemAgua;
import models.Itens.ItemAlimento;
import models.Itens.Item;

public class Rastreador extends Personagem {

    public Rastreador(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    // Implementação da habilidade especial do rastreador
    @Override
    public void habilidadeEspecial() {
        System.out.println(this.getNome() + " está usando sua habilidade de rastrear recursos.");
        // Exemplo de rastreamento de recursos no inventário
        for (Item item : getInventario()) {  // Agora estamos iterando corretamente sobre a lista de Item
            if (item instanceof ItemAlimento) {
                System.out.println(this.getNome() + " encontrou alimento: " + item.getNome());
                // Restaurar fome do personagem
                this.setFome(this.getFome() - 10);
            } else if (item instanceof ItemAgua) {
                System.out.println(this.getNome() + " encontrou água: " + item.getNome());
                // Restaurar sede do personagem
                this.setSede(this.getSede() - 10);
            }
        }
    }
}





