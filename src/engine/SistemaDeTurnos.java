package engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import models.Ambientes.Ambiente;
import models.Ambientes.AmbienteCaverna;
import models.Ambientes.AmbienteFloresta;
import models.Ambientes.AmbienteLagoRio;
import models.Ambientes.AmbienteMontanha;
import models.Ambientes.AmbienteRuinas;
import models.Eventos.GerenciadorDeEventos;
import models.Personagens.Personagem;
import models.Itens.Item;
import models.exceptions.MortePorFomeOuSedeException;

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
    public void iniciarTurno() throws MortePorFomeOuSedeException {
        System.out.println("\n========== NOVO TURNO ==========");
        jogador.exibirStatus();

        // Verifica se o jogador morreu de fome ou sede
        if (jogador.getFome() >= 100 || jogador.getSede() >= 100) {
            throw new MortePorFomeOuSedeException("Você morreu de fome ou sede.");
        }

        System.out.println("\nAmbiente atual: " + ambienteAtual.getNome());
        System.out.println("Clima: " + ambienteAtual.getCondicoesClimaticas());

        System.out.println("\nEscolha uma ação:");
        System.out.println("1 - Descansar");
        System.out.println("2 - Usar habilidade especial");
        System.out.println("3 - Explorar ambiente");
        System.out.println("4 - Exibir inventário");
        System.out.println("5 - Usar item");
        System.out.println("6 - Ir para outro ambiente");
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
                usarItem();
                break;
            case 6:
                // Trocar ambiente
                trocarAmbiente(jogador);
                break;
            default:
                System.out.println("Ação inválida.");
        }

        // Evento aleatório
        gerenciadorDeEventos.aplicarEvento(jogador, ambienteAtual);

        // Ajustes básicos de atributos após o turno
        jogador.setFome(jogador.getFome() + 5);
        jogador.setSede(jogador.getSede() + 5);
        jogador.setSanidade(jogador.getSanidade() - 2);
        System.out.println("Atributos ajustados após o turno.");

        // Verificação de morte
        if (jogador.getVida() <= 0 || jogador.getSanidade() <= 0) {
            System.out.println("Você morreu. Fim de jogo.");
            System.exit(0);
        }
    }

    // Método para trocar de ambiente
    public void trocarAmbiente(Personagem jogador) {
        // Lista de ambientes disponíveis
        List<Ambiente> ambientes = new ArrayList<>();
        ambientes.add(new AmbienteFloresta());
        ambientes.add(new AmbienteCaverna());
        ambientes.add(new AmbienteLagoRio());
        ambientes.add(new AmbienteMontanha());
        ambientes.add(new AmbienteRuinas());

        // Sorteia um novo ambiente
        Random random = new Random();
        Ambiente novoAmbiente = ambientes.get(random.nextInt(ambientes.size()));

        // Atualiza a localização do jogador para o novo ambiente
        jogador.setLocalizacao(novoAmbiente.getNome());
        System.out.println("Você se mudou para o novo ambiente: " + novoAmbiente.getNome());

        // Atualiza o ambiente atual
        this.ambienteAtual = novoAmbiente;
    }

    // Método para usar item do inventário
    public void usarItem() {
        // Exibir o inventário numerado
        System.out.println("Escolha um item para usar:");
        List<Item> listaItens = jogador.getInventario().getListaItens();
        for (int i = 0; i < listaItens.size(); i++) {
            System.out.println((i + 1) + " - " + listaItens.get(i).getNome());
        }
        System.out.print("Digite o número do item: ");
        int escolhaItem = scanner.nextInt();
        scanner.nextLine(); // limpar o buffer

        if (escolhaItem >= 1 && escolhaItem <= listaItens.size()) {
            Item itemEscolhido = listaItens.get(escolhaItem - 1);
            itemEscolhido.usar(); // Usar o item escolhido
            
            // Verificar se o item deve ser removido
            if (itemEscolhido.getDurabilidade() == 0) {
                jogador.getInventario().removerItem(itemEscolhido.getNome()); // Remover do inventário
            }

            // Atualizar o status do personagem
            atualizarStatus(jogador);
        } else {
            System.out.println("Escolha inválida.");
        }
    }

    // Método para atualizar o status do personagem
    private void atualizarStatus(Personagem jogador) {
        System.out.println("\nStatus Atualizado de " + jogador.getNome() + ":");
        System.out.println("Vida: " + jogador.getVida());
        System.out.println("Fome: " + jogador.getFome());
        System.out.println("Sede: " + jogador.getSede());
        System.out.println("Energia: " + jogador.getEnergia());
        System.out.println("Sanidade: " + jogador.getSanidade());
    }
}
