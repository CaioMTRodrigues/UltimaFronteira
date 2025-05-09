package models.Ambientes;

import models.Personagens.Personagem;

/**
 * Interface Explorável para ambientes que podem ser explorados.
 * Define a assinatura do método explorar() que será implementado por diferentes tipos de ambiente.
 */
public interface Exploravel {
    /**
     * Método que será implementado por ambientes específicos para definir como o ambiente será explorado.
     *
     * @param jogador O personagem que está explorando o ambiente.
     */
    void explorar(Personagem jogador);
}
