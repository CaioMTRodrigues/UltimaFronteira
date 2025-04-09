package models.Eventos;

import java.util.List;
import java.util.Random;
import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

/**
 * Classe responsável por gerenciar os eventos aleatórios no jogo.
 */
public class GerenciadorDeEventos {

    private List<Evento> eventosDisponiveis;
    private Random random;

    /**
     * Construtor do gerenciador de eventos.
     *
     * @param eventosDisponiveis Lista de eventos possíveis.
     */
    public GerenciadorDeEventos(List<Evento> eventosDisponiveis) {
        this.eventosDisponiveis = eventosDisponiveis;
        this.random = new Random();
    }

    // Getters e Setters
    public List<Evento> getEventosDisponiveis() { return eventosDisponiveis; }
    public void setEventosDisponiveis(List<Evento> eventosDisponiveis) { this.eventosDisponiveis = eventosDisponiveis; }

    public Random getRandom() { return random; }
    public void setRandom(Random random) { this.random = random; }

    /**
     * Sorteia um evento com base na probabilidade.
     *
     * @param local Ambiente atual.
     * @return Evento sorteado ou null.
     */
    public Evento sortearEvento(Ambiente local) {
        if (eventosDisponiveis.isEmpty()) return null;
        if (random.nextDouble() < 0.3) {
            Evento eventoSelecionado = eventosDisponiveis.get(random.nextInt(eventosDisponiveis.size()));
            System.out.println(" Um evento inesperado aconteceu: " + eventoSelecionado.getNome());
            return eventoSelecionado;
        }
        System.out.println("Nada de incomum aconteceu neste turno.");
        return null;
    }

    /**
     * Aplica o evento sorteado ao personagem e ambiente.
     *
     * @param jogador O personagem afetado.
     * @param local O ambiente onde o evento ocorre.
     */
    public void aplicarEvento(Personagem jogador, Ambiente local) {
        Evento evento = sortearEvento(local);
        if (evento != null) {
            System.out.println("===== Detalhes do Evento =====");
            evento.executar();
            System.out.println("=================================");
        }
    }

    /**
     * Remove um evento da lista de eventos disponíveis.
     *
     * @param evento Evento a ser removido.
     */
    public void removerEvento(Evento evento) {
        if (eventosDisponiveis.contains(evento)) {
            eventosDisponiveis.remove(evento);
            System.out.println(" O evento '" + evento.getNome() + "' foi removido.");
        } else {
            System.out.println(" O evento '" + evento.getNome() + "' não está na lista.");
        }
    }
}

