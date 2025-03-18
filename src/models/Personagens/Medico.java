package models.Personagens;

import models.Ambientes.Ambiente;
import models.Itens.ItemRemedios;

public class Medico extends Personagem {

    public Medico(String nome, Ambiente localizacao) {
        super(nome, localizacao);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(nome + " usou sua habilidade de Médico: pode curar ferimentos sem itens raros.");
    }

    public void curar(ItemRemedios remedio) {
        if (inventario.contains(remedio)) {
            vida = Math.min(vida + 40, 100);
            inventario.remove(remedio);
            System.out.println(nome + " usou " + remedio.getNome() + " e restaurou vida.");
        } else {
            System.out.println("Nenhum remédio disponível!");
        }
    }
}

