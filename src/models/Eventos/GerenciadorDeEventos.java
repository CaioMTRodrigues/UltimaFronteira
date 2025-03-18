package models.Eventos;

import java.util.List;
import java.util.Random;
import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

public class GerenciadorDeEventos {
    private List<Evento> eventosDisponiveis;
    private Random random;

    public GerenciadorDeEventos(List<Evento> eventosDisponiveis) {
        this.eventosDisponiveis = eventosDisponiveis;
        this.random = new Random();
    }

    public Evento sortearEvento(Ambiente local) {
        if (eventosDisponiveis.isEmpty()) {
            return null;
        }


        if (random.nextDouble() < 0.3) {
            Evento eventoSelecionado = eventosDisponiveis.get(random.nextInt(eventosDisponiveis.size()));
            System.out.println("🔥 Um evento inesperado aconteceu: " + eventoSelecionado.getNome());
            return eventoSelecionado;
        }
        
        System.out.println("Nada de incomum aconteceu neste turno.");
        return null;
    }

    public void aplicarEvento(Personagem jogador, Ambiente local) {
        Evento evento = sortearEvento(local);
        if (evento != null) {
            evento.executar();
        }
    }

    public void removerEvento(Evento evento) {
        if (eventosDisponiveis.contains(evento)) {
            eventosDisponiveis.remove(evento);
            System.out.println("🚫 O evento '" + evento.getNome() + "' foi removido.");
        } else {
            System.out.println("⚠ O evento '" + evento.getNome() + "' não está na lista.");
        }
    }
}
