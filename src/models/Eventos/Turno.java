package models.Eventos;

import models.Personagens.Personagem;
import models.Ambientes.Ambiente;

public class Turno {
    private Personagem jogador;
    private Ambiente ambiente;
    private GerenciadorDeEventos gerenciadorDeEventos;
    private int numeroTurno;

    public Turno(Personagem jogador, Ambiente ambiente, GerenciadorDeEventos gerenciadorDeEventos) {
        this.jogador = jogador;
        this.ambiente = ambiente;
        this.gerenciadorDeEventos = gerenciadorDeEventos;
        this.numeroTurno = 1;
    }

    // Fase 1: Exibir status do jogador
    private void faseDeInicio() {
        System.out.println("Status do jogador: " + jogador.getStatus());
        System.out.println("Ambiente atual: " + ambiente.getDescricao());
    }

    // Fase 2: Ação do jogador (movimentação, uso de itens, etc.)
    private void faseDeAcao() {
        jogador.realizarAcao();  // O jogador escolhe uma ação
    }

    // Fase 3: Executar evento aleatório
    private void faseDeEvento() {
        // Chama o gerenciador de eventos para aplicar um evento aleatório
        gerenciadorDeEventos.aplicarEvento(jogador, ambiente);
    }

    // Fase 4: Atualizar atributos de jogador e ambiente
    private void faseDeManutencao() {
        jogador.atualizarAtributos();
        ambiente.atualizarRecursos();
    }

    public void iniciarTurno() {
        faseDeInicio();
        faseDeAcao();
        faseDeEvento();
        faseDeManutencao();
        numeroTurno++;
    }
}