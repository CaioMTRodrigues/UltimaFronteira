package models.Personagens;

import models.Ambientes.Ambiente;
import models.Itens.ItemRemedios;

public class Medico extends Personagem {

    // Construtor que inicializa o médico
    public Medico(String nome, Ambiente localizacao) {
        super(nome, localizacao);
    }

    // Implementação da habilidade especial
    @Override
    public void habilidadeEspecial() {
        System.out.println(getNome() + " usou sua habilidade de Médico: pode curar ferimentos sem itens raros.");
    }

    // Método para curar ferimentos com remédios
    public void curar(ItemRemedios remedio) {
        if (getInventario().contains(remedio)) {
            // Utilizando o setter para modificar a vida
            setVida(Math.min(getVida() + 40, 100)); // Garantindo que a vida não ultrapasse 100
            getInventario().remove(remedio);
            System.out.println(getNome() + " usou " + remedio.getNome() + " e restaurou vida.");
        } else {
            System.out.println("Nenhum remédio disponível!");
        }
    }
}


