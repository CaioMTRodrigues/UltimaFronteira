package models.Personagens;

import models.Ambientes.Ambiente;
import models.Itens.ItemFerramentas;

public class Mecanico extends Personagem {

    // Construtor que inicializa o mecânico
    public Mecanico(String nome, Ambiente localizacao) {
        super(nome, localizacao);
    }

    // Implementação da habilidade especial
    @Override
    public void habilidadeEspecial() {
        System.out.println(getNome() + " usou sua habilidade de Mecânico: pode consertar ferramentas quebradas.");
    }

    // Método para consertar ferramenta
    public void consertarFerramenta(ItemFerramentas ferramenta) {
        if (getInventario().contains(ferramenta) && ferramenta.getDurabilidade() < 100) {
            ferramenta.reduzirDurabilidade();
            System.out.println(getNome() + " consertou " + ferramenta.getNome() + " e restaurou sua durabilidade.");
        } else {
            System.out.println("Ferramenta não precisa de reparo ou não está no inventário!");
        }
    }
}

