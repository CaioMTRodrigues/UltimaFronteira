package models.Personagens;

import models.Ambientes.Ambiente;

public class SobreviventeNato extends Personagem {

    public SobreviventeNato(String nome, Ambiente localizacao) {
        super(nome, localizacao);
    }

    @Override
    public void habilidadeEspecial() {
        System.out.println(nome + " usou sua habilidade de Sobrevivente Nato: menos impactado por fome e sede.");
    }

    @Override
    public void descansar() {
        energia = Math.min(energia + 70, 100);
        sanidade = Math.min(sanidade + 20, 100);
        System.out.println(nome + " descansou melhor e recuperou mais energia e sanidade.");
    }
}
