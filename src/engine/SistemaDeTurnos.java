package engine;

import java.util.Scanner;
import models.Ambientes.Ambiente;
import models.Eventos.GerenciadorDeEventos;
import models.Personagens.Personagem;

/**
 * Classe responsável por controlar o sistema de turnos do jogo.
 * Cada turno permite ao jogador realizar ações, sofrer eventos e ter seus atributos atualizados.
 */
public class SistemaDeTurnos {

    private Personagem jogador;
    private Ambiente ambienteAtual;
    private GerenciadorDeEventos gerenciadorDeEventos;
    private Scanner scanner;

    /**
     * Construtor do sistema de turnos.
     *
     * @param jogador           O personagem que está jogando.
     * @param ambienteAtual     O ambiente onde o personagem se encontra.
     * @param eventos           Gerenciador que aplica eventos aleatórios.
     */
    public SistemaDeTurnos(Personagem jogador, Ambiente ambienteAtual, GerenciadorDeEventos eventos) {
        this.jogador = jogador;
        this.ambienteAtual = ambienteAtual;
        this.gerenciadorDeEventos = eventos;
        this.scanner = new Scanner(System.in);
    }

    /**
     * Inicia um novo turno, permitindo que o jogador execute uma ação e que eventos ocorram.
     */
    public void iniciarTurno() {
        System.out.println("\n========== NOVO TURNO ==========");
        jogador.exibirStatus();

        System.out.println("\n🌍 Ambiente atual: " + ambienteAtual.getNome());
        System.out.println("🌦 Clima: " + ambienteAtual.getCondicoesClimaticas());

        System.out.println("\nEscolha uma ação:");
        System.out.println("1 - Descansar");
        System.out.println("2 - Usar habilidade especial");
        System.out.println("3 - Explorar ambiente");
        System.out.println("4 - Exibir inventário");
        System.out.println("5 - Usar item");
        System.out.print(">> ");

        int escolha = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        switch (escolha) {
            case 1:
                jogador.descansar();
                break;
            case 2:
                jogador.habilidadeEspecial();
                break;
            case 3:
                ambienteAtual.explorar(jogador);
                break;
            case 4:
                jogador.getInventario().exibirInventario();
                break;
            case 5:
                System.out.print("Digite o nome do item: ");
                String nomeItem = scanner.nextLine();
                jogador.getInventario().usarItem(nomeItem);
                break;
            default:
                System.out.println("❌ Ação inválida.");
        }

        // Evento aleatório
        gerenciadorDeEventos.aplicarEvento(jogador, ambienteAtual);

        // Ajustes básicos de atributos após o turno
        jogador.setFome(jogador.getFome() + 5);
        jogador.setSede(jogador.getSede() + 5);
        jogador.setSanidade(jogador.getSanidade() - 2);
        System.out.println("🔁 Atributos ajustados após o turno.");

        // Verificação de morte
        if (jogador.getVida() <= 0 || jogador.getSanidade() <= 0) {
            System.out.println("💀 Você morreu. Fim de jogo.");
            System.exit(0);
        }
    }
}
