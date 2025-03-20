package models.Personagens;

import models.Ambientes.Ambiente;
import models.Itens.ItemAlimento;

public class Rastreador extends Personagem {

    // Construtor
    public Rastreador(String nome, Ambiente localizacao) {
        super(nome, localizacao);
    }

    // Implementação da habilidade especial
    @Override
    public void habilidadeEspecial() {
        System.out.println(getNome() + " usou sua habilidade de Rastreador: encontra comida e água com mais facilidade.");
    }

    // Método para encontrar recursos (alimentos) no ambiente
    public void encontrarRecursos() {
        // Criando o item de alimento
        ItemAlimento comida = new ItemAlimento("Frutas Selvagens", 0.5, 2, 20, "Natural", 5);
        
        // Adicionando o item ao inventário
        adicionarItemAoInventario(comida);
        
        // Exibindo a mensagem
        System.out.println(getNome() + " encontrou " + comida.getNome() + ".");
    }
}

