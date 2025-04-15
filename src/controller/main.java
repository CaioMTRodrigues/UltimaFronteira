package controller;

import engine.SistemaDeTurnos;
import models.Personagens.Medico;
import models.Personagens.Personagem;
import models.Ambientes.Ambiente;
import models.Ambientes.AmbienteFloresta;
import models.Eventos.*;
import models.Itens.*;

import java.util.ArrayList;
import java.util.List;

/**
 * Classe principal de execução do jogo.
 * Simula um cenário com personagem, ambiente, itens e eventos.
 */
public class Main {

    /**
     * Método principal que inicializa o jogo e executa os turnos.
     *
     * @param args Argumentos de linha de comando (não utilizados).
     */
    public static void main(String[] args) {

        // Criação do personagem
        Personagem jogador = new Medico("Pedro", 100, 30, 30, 60, 80, "Floresta");

        // Adicionando itens ao inventário
        jogador.getInventario().adicionarItem(new ItemAlimento("Fruta Silvestre", 1.2, 2, 15, "Fruta", 5));
        jogador.getInventario().adicionarItem(new ItemAgua("Cantil de Água", 1.0, 1, true, 0.5));
        jogador.getInventario().adicionarItem(new ItemRemedios("Kit de Primeiros Socorros", 2.0, 3, "Bandagem", "Cura ferimentos leves"));

        // Definindo o ambiente inicial
        Ambiente ambiente = new AmbienteFloresta();

        // Criando lista de eventos disponíveis
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new EventoClimatico("Chuva Intensa", "Uma tempestade tropical atinge a floresta.", 0.3, "Redução de energia", "Chuva", 2, "Movimentação dificultada"));
        eventos.add(new EventoCriatura("Ataque de Lobo", "Um lobo aparece de repente entre os arbustos.", 0.2, "Redução de vida", "Lobo", 6, "Fugir ou lutar"));

        // Inicializando o sistema de eventos e turnos
        GerenciadorDeEventos gerenciador = new GerenciadorDeEventos(eventos);
        SistemaDeTurnos sistema = new SistemaDeTurnos(jogador, ambiente, gerenciador);

        // Executando 3 turnos
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n🔁 Turno " + i);
            sistema.iniciarTurno();
        }

        System.out.println("\n🏁 Fim da simulação de turnos.");
    }
}
