package models.Personagens;

import models.Ambientes.Ambiente;
import models.Itens.ItemAlimento;

public class Rastreador extends Personagem {

    public Rastreador(String nome, Ambiente localizacao) {
        super(nome, localizacao);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(nome + " usou sua habilidade de Rastreador: encontra comida e água com mais facilidade.");
    }

    public void encontrarRecursos() {
        ItemAlimento comida = new ItemAlimento("Frutas Selvagens", 0.5, 2, 20, "Natural", 5);
        adicionarItemAoInventario(comida);
        System.out.println(nome + " encontrou " + comida.getNome() + ".");
    }
}
