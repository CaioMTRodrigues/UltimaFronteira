package models.Eventos;

import java.util.List;
import java.util.Random;

public class GerenciadorDeEventos {
    private List<Evento> eventosDisponiveis;
    private Random random;

    public GerenciadorDeEventos(List<Evento> eventosDisponiveis) {
        this.eventosDisponiveis = eventosDisponiveis;
        this.random = new Random();
    }

    public void ativarEventoAleatorio() {
        if (eventosDisponiveis.isEmpty()) {
            System.out.println("Nenhum evento disponível no momento.");
            return;
        }

        // Probabilidade de um evento ocorrer (30%)
        if (random.nextDouble() < 0.3) {
            Evento eventoSelecionado = eventosDisponiveis.get(random.nextInt(eventosDisponiveis.size()));
            System.out.println("🔥 Um evento inesperado aconteceu!");
            eventoSelecionado.executar();
        } else {
            System.out.println("Nada de incomum aconteceu neste turno.");
        }
    }
}

