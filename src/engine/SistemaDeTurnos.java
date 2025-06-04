package engine;

import java.util.ArrayList;
import java.util.Arrays;
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
import models.Itens.Item;
import models.Personagens.Personagem;
import models.exceptions.InventarioCheioException;
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

    // Controle de turnos para condição de vitória
    private int turnosPassados;
    private final int turnosParaVitoria;
    private final int turnosParaResgate;

    /**
     * Construtor do sistema de turnos.
     * 
     * @param jogador O personagem que está jogando.
     * @param ambienteAtual O ambiente onde o personagem se encontra.
     * @param eventos Gerenciador que aplica eventos aleatórios.
     * @param turnosParaVitoria Número de turnos que o jogador deve sobreviver para vencer.
     */
    public SistemaDeTurnos(Personagem jogador, Ambiente ambienteAtual, GerenciadorDeEventos eventos, int turnosParaVitoria) {
        this.jogador = jogador;
        this.ambienteAtual = ambienteAtual;
        this.gerenciadorDeEventos = eventos;
        this.scanner = new Scanner(System.in);
        this.turnosPassados = 0;
        this.turnosParaVitoria = turnosParaVitoria;
        this.turnosParaResgate = 3;
    }

    /**
     * Inicia um novo turno, permitindo que o jogador execute uma ação e que eventos ocorram.
     * 
     * @throws MortePorFomeOuSedeException Se o jogador morrer devido a fome ou sede.
     */
    public void iniciarTurno() throws MortePorFomeOuSedeException {
        System.out.println("\n========== NOVO TURNO ==========");
        System.out.println("Turno atual: " + turnosPassados + "/" + turnosParaVitoria);
        jogador.exibirStatus();

        // Condições de vitória
        if (jogador.isRefugioSeguroEncontrado()) {
            System.out.println("Parabéns! Você encontrou um refúgio seguro e venceu o jogo!");
            System.exit(0);
        }
        if (jogador.isAbrigoConstruido()) {
            System.out.println("Parabéns! Você construiu um abrigo permanente e venceu o jogo!");
            System.exit(0);
        }
        if (verificarVitoriaPorTempo()) {
            System.out.println("Parabéns! Você sobreviveu por " + turnosParaVitoria + " turnos e venceu o jogo!");
            System.exit(0);
        }
        if (jogador.isPedidoResgateAtivado()) {
            jogador.setTurnosDesdePedidoResgate(jogador.getTurnosDesdePedidoResgate() + 1);
            System.out.println("Turnos desde o pedido de resgate: " + jogador.getTurnosDesdePedidoResgate() + "/" + turnosParaResgate);
            if (jogador.getTurnosDesdePedidoResgate() >= turnosParaResgate) {
                System.out.println("Parabéns! Seu resgate chegou com sucesso e você venceu o jogo!");
                System.exit(0);
            }
        }

        // Condições de derrota
        if (jogador.getVida() <= 0) {
            System.out.println("Você morreu devido a ferimentos graves. Fim de jogo.");
            System.exit(0);
        }
        if (jogador.getFome() >= 100 || jogador.getSede() >= 100) {
            throw new MortePorFomeOuSedeException("Você morreu de fome ou sede.");
        }
        if (jogador.getSanidade() <= 0) {
            System.out.println("Sua sanidade chegou a zero. Você teve uma alucinação fatal. Fim de jogo.");
            System.exit(0);
        }
        if (verificarEsgotamentoRecursos()) {
            System.out.println("Você ficou sem recursos essenciais (comida, água e ferramentas). A sobrevivência é impossível. Fim de jogo.");
            System.exit(0);
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
        System.out.println("7 - Criar item (Craft)");
        System.out.println("8 - Construir abrigo permanente");
        System.out.println("9 - Pedir resgate");
        System.out.print(">> ");
        int escolha;

        try {
            String entrada = scanner.nextLine().trim();
            escolha = Integer.parseInt(entrada);

            if (escolha < 1 || escolha > 9) {
                System.out.println("Entrada inválida. Por favor, digite um número de 1 a 9.");
                return; // Encerra o turno sem executar ação
            }
        } catch (NumberFormatException e) {
            System.out.println("Entrada inválida. Por favor, digite um número de 1 a 9.");
            return;
        }

        boolean acaoExecutada = false;

        switch (escolha) {
            case 1:
                jogador.descansar();
                acaoExecutada = true;
                break;
            case 2:
                jogador.habilidadeEspecial();
                acaoExecutada = true;
                break;
            case 3:
                ambienteAtual.explorar(jogador);
                acaoExecutada = true;
                break;
            case 4:
                jogador.getInventario().exibirInventario();
                acaoExecutada = true;
                break;
            case 5:
                acaoExecutada = usarItem();
                break;
            case 6:
                trocarAmbiente(jogador);
                acaoExecutada = true;
                break;
            case 7:
                acaoExecutada = menuCraft();
                break;
            case 8:
                construirAbrigo();
                acaoExecutada = true;
                break;
            case 9:
                pedirResgate();
                acaoExecutada = true;
                break;
        }

        if (acaoExecutada) {
            turnosPassados++;
            gerenciadorDeEventos.aplicarEvento(jogador, ambienteAtual);
            jogador.setFome(jogador.getFome() + 5);
            jogador.setSede(jogador.getSede() + 5);
            jogador.setSanidade(jogador.getSanidade() - 2);
            System.out.println("Atributos ajustados após o turno.");
        }
    }

    /**
     * Verifica se a condição de vitória por tempo determinado foi alcançada.
     * 
     * @return true se o número de turnos jogados for maior ou igual ao limite.
     */
    private boolean verificarVitoriaPorTempo() {
        return turnosPassados >= turnosParaVitoria;
    }

        /**
     * Verifica se o jogador ficou completamente sem recursos essenciais (comida, água e ferramentas).
     * A derrota só ocorre se o jogador não tiver absolutamente nenhum dos três.
     * 
     * @return true se faltar todos os recursos essenciais, false se ainda tiver ao menos um.
     */
    private boolean verificarEsgotamentoRecursos() {
        boolean temComida = false;
        boolean temAgua = false;
        boolean temFerramenta = false;

        for (Item item : jogador.getInventario().getListaItens()) {
            String nome = item.getNome().toLowerCase();
            if (nome.contains("comida") || nome.contains("carne") || nome.contains("fruta") || nome.contains("alimento") || nome.contains("enlatado")) {
                temComida = true;
            }
            if (nome.contains("água") || nome.contains("cantil") || nome.contains("agua")) {
                temAgua = true;
            }
            if (nome.contains("ferramenta") || nome.contains("machado") || nome.contains("faca") || nome.contains("tools")) {
                temFerramenta = true;
            }
        }

        // O jogo só termina se o jogador não tiver nenhum dos três
        return !(temComida || temAgua || temFerramenta);
    }


    /**
     * Permite ao jogador construir um abrigo permanente se tiver os materiais necessários.
     */
    private void construirAbrigo() {
        if (jogador.getInventario().podeConstruirAbrigo()) {
            System.out.println("Você tem os materiais necessários para construir o abrigo.");
            System.out.print("Deseja usar os materiais para construir o abrigo? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("s") || resposta.equals("sim")) {
                jogador.getInventario().usarMateriaisParaAbrigo();
                jogador.setAbrigoConstruido(true);
                System.out.println("Parabéns! Você construiu um abrigo permanente.");
            } else {
                System.out.println("Construção do abrigo cancelada.");
            }
        } else {
            System.out.println("Você não possui materiais suficientes para construir o abrigo.");
            System.out.println("São necessárias 5 unidades de Madeira e 3 unidades de Pedra.");

        }
    }

    /**
     * Ativa o pedido de resgate, o jogador terá que aguardar um número de turnos antes de ser resgatado.
     * O pedido só pode ser feito se o jogador tiver sobrevivido por pelo menos 12 turnos e com fome, sede e sanidade em níveis "saudáveis".
     */
    private void pedirResgate() {
        if (jogador.isPedidoResgateAtivado()) {
            System.out.println("Você já ativou o pedido de resgate.");
            return;
        }
        if (turnosPassados < 12) {
            System.out.println("Você deve sobreviver por pelo menos 12 turnos antes de poder pedir resgate.");
            return;
        }

        // Verifica as condições de saúde do jogador
        if (jogador.getFome() > 50 && jogador.getSede() > 50 && jogador.getSanidade() > 50) {
            System.out.println("Você está em condições boas para pedir resgate.");
            System.out.println("Deseja continuar? (s/n): ");
            String resposta = scanner.nextLine().trim().toLowerCase();
            if (resposta.equals("s") || resposta.equals("sim")) {
                jogador.setPedidoResgateAtivado(true);
                jogador.setTurnosDesdePedidoResgate(0);
                System.out.println("Pedido de resgate ativado! Aguarde a chegada do resgate.");
            } else {
                System.out.println("Pedido de resgate cancelado.");
            }
        } else {
            System.out.println("Você não está em condições saudáveis o suficiente para pedir resgate.");
        }
    }

    /**
     * Exibe o menu de crafting de itens e permite que o jogador crie novos itens.
     */
    private boolean menuCraft() {
    System.out.println("\n-- Menu de Craft --");
    System.out.println("Escolha o item para criar:");
    System.out.println("1 - Machado (Madeira + Pedra)");
    System.out.println("2 - Faca (Madeira + Pedra)");
    System.out.println("3 - Bandagem (Algodão + Álcool)");
    System.out.println("0 - Voltar");

    int opcao;
    try {
        String entrada = scanner.nextLine().trim();
        opcao = Integer.parseInt(entrada);

        if (opcao < 0 || opcao > 3) {
            System.out.println("Opção inválida. Digite um número entre 0 e 3.");
            return false;
        }
    } catch (NumberFormatException e) {
        System.out.println("Opção inválida. Digite um número entre 0 e 3.");
        return false;
    }

    List<String> materiaisNecessarios;

    switch (opcao) {
        case 1:
            materiaisNecessarios = Arrays.asList("Madeira", "Pedra");
            craftItem("Machado", materiaisNecessarios);
            return true;
        case 2:
            materiaisNecessarios = Arrays.asList("Madeira", "Pedra");
            craftItem("Faca", materiaisNecessarios);
            return true;
        case 3:
            materiaisNecessarios = Arrays.asList("Algodão", "Álcool");
            craftItem("Bandagem", materiaisNecessarios);
            return true;
        case 0:
            System.out.println("Voltando ao menu principal.");
            return false;
    }
    return false;
}


    /**
     * Tenta criar um item no inventário a partir dos materiais necessários.
     * 
     * @param nomeItem Nome do item a ser criado.
     * @param materiaisNecessarios Lista de materiais necessários para a criação.
     */
    private void craftItem(String nomeItem, List<String> materiaisNecessarios) {
        try {
            boolean sucesso = jogador.getInventario().craft(nomeItem, materiaisNecessarios);
            if (sucesso) {
                System.out.println("Item '" + nomeItem + "' criado com sucesso!");
            } else {
                System.out.println("Falha ao criar item. Verifique se possui todos os materiais necessários.");
            }
        } catch (InventarioCheioException e) {
            System.out.println("Inventário cheio. Não foi possível adicionar o item.");
        }
        jogador.getInventario().exibirInventario();
    }

    /**
     * Permite trocar o ambiente atual do jogador.
     * O ambiente é escolhido aleatoriamente de uma lista de ambientes disponíveis.
     * 
     * @param jogador O personagem que irá mudar de ambiente.
     */
    public void trocarAmbiente(Personagem jogador) {
        List<Ambiente> ambientes = new ArrayList<>();
        ambientes.add(new AmbienteFloresta());
        ambientes.add(new AmbienteCaverna());
        ambientes.add(new AmbienteLagoRio());
        ambientes.add(new AmbienteMontanha());
        ambientes.add(new AmbienteRuinas());

        Random random = new Random();
        Ambiente novoAmbiente = ambientes.get(random.nextInt(ambientes.size()));

        jogador.setLocalizacao(novoAmbiente.getNome());
        System.out.println("Você se mudou para o novo ambiente: " + novoAmbiente.getNome());

        this.ambienteAtual = novoAmbiente;
    }

    /**
     * Permite ao jogador usar um item do inventário.
     */
    public boolean usarItem() {
    List<Item> listaItens = jogador.getInventario().getListaItens();

    if (listaItens.isEmpty()) {
        System.out.println("Seu inventário está vazio.");
        return false;
    }

    System.out.println("Escolha um item para usar:");
    for (int i = 0; i < listaItens.size(); i++) {
        System.out.println((i + 1) + " - " + listaItens.get(i).getNome());
    }
    System.out.print("Digite o número do item: ");

    int escolhaItem;
    try {
        String entrada = scanner.nextLine().trim();
        escolhaItem = Integer.parseInt(entrada);

        if (escolhaItem < 1 || escolhaItem > listaItens.size()) {
            System.out.println("Escolha inválida. Digite um número válido da lista.");
            return false;
        }
    } catch (NumberFormatException e) {
        System.out.println("Escolha inválida. Por favor, digite um número válido.");
        return false;
    }

    Item itemEscolhido = listaItens.get(escolhaItem - 1);
    itemEscolhido.usar(jogador);

    if (itemEscolhido.getDurabilidade() == 0) {
        jogador.getInventario().removerItem(itemEscolhido.getNome());
    }

    atualizarStatus(jogador);
    return true;
}


    /**
     * Atualiza o status atual do personagem.
     * Exibe informações como vida, fome, sede, energia e sanidade.
     * 
     * @param jogador O personagem cujo status será atualizado.
     */
    private void atualizarStatus(Personagem jogador) {
        System.out.println("\nStatus Atualizado de " + jogador.getNome() + ":");
        System.out.println("Vida: " + jogador.getVida());
        System.out.println("Fome: " + jogador.getFome());
        System.out.println("Sede: " + jogador.getSede());
        System.out.println("Energia: " + jogador.getEnergia());
        System.out.println("Sanidade: " + jogador.getSanidade());
    }

    /**
     * Permite ao jogador criar um item a partir de materiais presentes no inventário.
     */
    private void criarItem() {
        System.out.print("Digite o nome do item que deseja criar: ");
        String nomeItem = scanner.nextLine().trim().toLowerCase();

        List<String> materiaisNecessarios;

        switch (nomeItem) {
            case "machado":
                materiaisNecessarios = Arrays.asList("madeira", "pedra");
                break;
            case "faca":
                materiaisNecessarios = Arrays.asList("madeira", "pedra");
                break;
            case "bandagem":
                materiaisNecessarios = Arrays.asList("algodao", "alcool");
                break;
            default:
                System.out.println("Item não suportado para criação.");
                return;
        }

        try {
            boolean sucesso = jogador.getInventario().craft(nomeItem, materiaisNecessarios);
            if (sucesso) {
                System.out.println("Item '" + nomeItem + "' criado com sucesso!");
            } else {
                System.out.println("Falha ao criar item. Verifique os materiais.");
            }
        } catch (InventarioCheioException e) {
            System.out.println("Inventário cheio. Não foi possível adicionar o item.");
        }

        jogador.getInventario().exibirInventario();
    }
}
