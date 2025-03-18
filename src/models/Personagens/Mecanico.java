package models.Personagens;

import models.Ambientes.Ambiente;
import models.Itens.ItemFerramentas;

public class Mecanico extends Personagem {

    public Mecanico(String nome, Ambiente localizacao) {
        super(nome, localizacao);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(nome + " usou sua habilidade de Mecânico: pode consertar ferramentas quebradas.");
    }

    public void consertarFerramenta(ItemFerramentas ferramenta) {
        if (inventario.contains(ferramenta) && ferramenta.getDurabilidade() < 100) {
            ferramenta.reduzirDurabilidade();
            System.out.println(nome + " consertou " + ferramenta.getNome() + " e restaurou sua durabilidade.");
        } else {
            System.out.println("Ferramenta não precisa de reparo ou não está no inventário!");
        }
    }
}
