package models.Personagens;

import models.Itens.ItemFerramentas;
import models.Itens.Item;

public class Mecanico extends Personagem {

    public Mecanico(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    // Implementação da habilidade especial do mecânico
    @Override
    public void habilidadeEspecial() {
        System.out.println(this.getNome() + " está usando sua habilidade de consertar ferramentas.");

        // Exemplo de interação com o inventário para consertar uma ferramenta
        for (Item item : getInventario()) {  // Agora iteramos corretamente sobre a lista de Item
            if (item instanceof ItemFerramentas) {
                System.out.println(this.getNome() + " consertou a ferramenta: " + item.getNome());
                // Você pode adicionar mais lógica para melhorar a durabilidade ou efeito do item, por exemplo.
            }
        }
    }
}


