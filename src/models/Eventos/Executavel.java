package models.Eventos;

import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

/**
 * Interface Executável para ações de eventos.
 * Define a assinatura do método executar() que será implementado por eventos específicos.
 */
public interface Executavel {
    /**
     * Método que será implementado por eventos específicos para definir como o evento será executado.
     *
     * @param jogador O personagem afetado pelo evento.
     * @param ambiente O ambiente onde o evento ocorre.
     */
    void executar(Personagem jogador, Ambiente ambiente);
}
