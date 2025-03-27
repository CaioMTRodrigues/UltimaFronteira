package models.Eventos;

import java.util.List;
import java.util.Random;
import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

public class GerenciadorDeEventos {

    private List<Evento> eventosDisponiveis;
    private Random random;

    // Construtor que inicializa a lista de eventos disponíveis
    public GerenciadorDeEventos(List<Evento> eventosDisponiveis) {
        this.eventosDisponiveis = eventosDisponiveis;
        this.random = new Random();
    }

    // Métodos de Acesso
    public List<Evento> getEventosDisponiveis() {
        return eventosDisponiveis;
    }

    public void setEventosDisponiveis(List<Evento> eventosDisponiveis) {
        this.eventosDisponiveis = eventosDisponiveis;
    }

    public Random getRandom() {
        return random;
    }

    public void setRandom(Random random) {
        this.random = random;
    }

    // Método para sortear um evento baseado na probabilidade
    public Evento sortearEvento(Ambiente local) {
        if (eventosDisponiveis.isEmpty()) {
            return null;
        }

        if (random.nextDouble() < 0.3) { // 30% de chance de um evento ocorrer
            Evento eventoSelecionado = eventosDisponiveis.get(random.nextInt(eventosDisponiveis.size()));
            System.out.println("🔥 Um evento inesperado aconteceu: " + eventoSelecionado.getNome());
            return eventoSelecionado;
        }

        System.out.println("Nada de incomum aconteceu neste turno.");
        return null;
    }

    // Método para aplicar um evento sorteado ao personagem e ao ambiente
    public void aplicarEvento(Personagem jogador, Ambiente local) {
        Evento evento = sortearEvento(local);
        if (evento != null) {
            System.out.println("===== Detalhes do Evento =====");
            evento.executar(); // Executa o evento, afetando o personagem e o ambiente
            System.out.println("=================================");
        }
    }

    // Método para remover um evento da lista de eventos disponíveis
    public void removerEvento(Evento evento) {
        if (eventosDisponiveis.contains(evento)) {
            eventosDisponiveis.remove(evento);
            System.out.println("🚫 O evento '" + evento.getNome() + "' foi removido.");
        } else {
            System.out.println("⚠ O evento '" + evento.getNome() + "' não está na lista.");
        }
    }
}

