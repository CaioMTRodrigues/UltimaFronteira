package controller;

import engine.SistemaDeTurnos;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import models.Ambientes.*;
import models.Eventos.*;
import models.Itens.*;
import models.Personagens.*;
import models.exceptions.InventarioCheioException;
import models.exceptions.MortePorFomeOuSedeException;

/**
 * Classe principal que inicia o jogo e controla a execução do sistema de turnos.
 */
public class Main {

    /**
     * Método principal que inicia o jogo e controla a interação do jogador.
     * Permite escolher o nome do personagem, sua classe, os itens iniciais e o ambiente.
     * 
     * @param args Argumentos de linha de comando (não utilizados neste jogo).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Escolha do nome do personagem
        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        // Escolha da classe do personagem
        System.out.println("Escolha sua classe:");
        System.out.println("1 - Médico");
        System.out.println("2 - Mecânico");
        System.out.println("3 - Rastreador");
        System.out.println("4 - Sobrevivente Nato");
        System.out.print(">> ");
        int classeEscolhida = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        // Criação do personagem baseado na classe escolhida
        Personagem jogador;
        switch (classeEscolhida) {
            case 1:
                jogador = new Medico(nome, 100, 30, 30, 60, 80, "Indefinido");
                System.out.println("Classe selecionada: Médico");
                System.out.println("Habilidade Especial: Pode usar remédios para recuperar vida diretamente.");
                break;
            case 2:
                jogador = new Mecanico(nome, 100, 30, 30, 60, 80, "Indefinido");
                System.out.println("Classe selecionada: Mecânico");
                System.out.println("Habilidade Especial: Conserta ferramentas e aumenta sua durabilidade.");
                break;
            case 3:
                jogador = new Rastreador(nome, 100, 30, 30, 60, 80, "Indefinido");
                System.out.println("Classe selecionada: Rastreador");
                System.out.println("Habilidade Especial: Encontra água e comida com mais facilidade no inventário.");
                break;
            case 4:
                jogador = new SobreviventeNato(nome, 100, 30, 30, 60, 80, "Indefinido");
                System.out.println("Classe selecionada: Sobrevivente Nato");
                System.out.println("Habilidade Especial: Sofre menos com fome e sede ao longo do tempo.");
                break;
            default:
                System.out.println("Classe inválida! Um médico será atribuído por padrão.");
                jogador = new Medico(nome, 100, 30, 30, 60, 80, "Indefinido");
                System.out.println("Classe selecionada: Médico");
                System.out.println("Habilidade Especial: Pode usar remédios para recuperar vida diretamente.");
        }

        // Adicionando itens iniciais ao inventário
        try {
            jogador.getInventario().adicionarItem(new ItemAlimento("Fruta Silvestre", 1.2, 2, 15, "Fruta", 5));
            jogador.getInventario().adicionarItem(new ItemAgua("Cantil de Água", 1.0, 1, true, 0.5));
            jogador.getInventario().adicionarItem(new ItemRemedios("Kit de Primeiros Socorros", 2.0, 3, "Bandagem", "Cura ferimentos leves"));
        } catch (InventarioCheioException e) {
            System.out.println("Erro ao adicionar item ao inventário: " + e.getMessage());
        }

        // Sorteio de ambiente inicial
        List<Ambiente> ambientes = new ArrayList<>();
        ambientes.add(new AmbienteFloresta());
        ambientes.add(new AmbienteCaverna());
        ambientes.add(new AmbienteLagoRio());
        ambientes.add(new AmbienteMontanha());
        ambientes.add(new AmbienteRuinas());

        Random random = new Random();
        Ambiente ambiente = ambientes.get(random.nextInt(ambientes.size()));

        jogador.setLocalizacao(ambiente.getNome());

        System.out.println("\nAmbiente inicial sorteado: " + ambiente.getNome());

        // Adicionando eventos dinâmicos ao jogo
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new EventoClimatico("Chuva Intensa", "Uma tempestade tropical atinge a região.", 0.3, "Redução de energia", "Chuva", 2, "Movimentação dificultada"));
        eventos.add(new EventoClimatico("Chuva Nutriente", "Chuva suave estimula frutas a brotarem nas árvores próximas.", 0.25, "Geração de alimento", "Chuva leve", 2, "Frutas frescas aparecem na vegetação"));
        eventos.add(new EventoCriatura("Ataque de Lobo", "Um lobo aparece entre os arbustos pronto para atacar.", 0.2, "Redução de vida", "Lobo", 6, "Fugir ou lutar"));
        eventos.add(new EventoCriatura("Infestação de Ratos", "Ratos invadem seus suprimentos e roubam comida.", 0.2, "Perda de alimentos", "Ratos", 3, "Espantar ou ignorar"));
        eventos.add(new EventoCriatura("Encontro com Urso", "Um urso enorme bloqueia seu caminho, rosnando ferozmente.", 0.15, "Ferimentos graves", "Urso", 9, "Fugir ou lutar"));

        List<Item> itensDescobertos = new ArrayList<>();
        itensDescobertos.add(new ItemRemedios("Erva Calmante", 0.2, 1, "Natural", "Reduz dor e estresse"));

        eventos.add(new EventoDescoberta("Ervas Medicinais", "Você encontra ervas naturais em meio à vegetação.", 0.3, "Recuperação de sanidade", "Ervas escondidas", itensDescobertos, "Usar como infusão ou pomada"));

        // Inicializando o gerenciador de eventos
        GerenciadorDeEventos gerenciador = new GerenciadorDeEventos(eventos);

        // Número de turnos para vitória configurável
        int turnosParaVitoria = 20;

        SistemaDeTurnos sistema = new SistemaDeTurnos(jogador, ambiente, gerenciador, turnosParaVitoria);

        // Loop principal do jogo: continua enquanto o jogo estiver ativo
        boolean continuarJogando = true;
        while (continuarJogando) {
            try {
                sistema.iniciarTurno();
            } catch (MortePorFomeOuSedeException e) {
                System.out.println(e.getMessage());
                continuarJogando = false;
                break;
            }
        }

        System.out.println("\nFim da simulação de turnos.");
        scanner.close();
    }
}