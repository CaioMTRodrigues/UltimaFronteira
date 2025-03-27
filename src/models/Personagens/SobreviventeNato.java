package models.Personagens;

import models.Ambientes.Ambiente;

public class SobreviventeNato extends Personagem {

    // Construtor que inicializa o sobrevivente nato
    public SobreviventeNato(String nome, Ambiente localizacao) {
        super(nome, localizacao);
    }

    // Implementação da habilidade especial
    @Override
    public void habilidadeEspecial() {
        System.out.println(getNome() + " usou sua habilidade de Sobrevivente Nato: menos impactado por fome e sede.");
    }

    // Método para descansar e recuperar mais energia e sanidade
    @Override
    public void descansar() {
        setEnergia(Math.min(getEnergia() + 70, 100));  // Usando o setter para energia
        setSanidade(Math.min(getSanidade() + 20, 100));  // Usando o setter para sanidade
        System.out.println(getNome() + " descansou melhor e recuperou mais energia e sanidade.");
    }
}


