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

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        // Escolha do nome
        System.out.print("Digite o nome do seu personagem: ");
        String nome = scanner.nextLine();

        // Escolha da classe
        System.out.println("Escolha sua classe:");
        System.out.println("1 - Médico");
        System.out.println("2 - Mecânico");
        System.out.println("3 - Rastreador");
        System.out.println("4 - Sobrevivente Nato");
        System.out.print(">> ");
        int classeEscolhida = scanner.nextInt();
        scanner.nextLine(); // limpar buffer

        Personagem jogador;
        switch (classeEscolhida) {
            case 1:
                jogador = new Medico(nome, 100, 30, 30, 60, 80, "Indefinido");
                break;
            case 2:
                jogador = new Mecanico(nome, 100, 30, 30, 60, 80, "Indefinido");
                break;
            case 3:
                jogador = new Rastreador(nome, 100, 30, 30, 60, 80, "Indefinido");
                break;
            case 4:
                jogador = new SobreviventeNato(nome, 100, 30, 30, 60, 80, "Indefinido");
                break;
            default:
                System.out.println("Classe inválida! Um médico será atribuído por padrão.");
                jogador = new Medico(nome, 100, 30, 30, 60, 80, "Indefinido");
        }

        // Itens iniciais
        jogador.getInventario().adicionarItem(new ItemAlimento("Fruta Silvestre", 1.2, 2, 15, "Fruta", 5));
        jogador.getInventario().adicionarItem(new ItemAgua("Cantil de Água", 1.0, 1, true, 0.5));
        jogador.getInventario().adicionarItem(new ItemRemedios("Kit de Primeiros Socorros", 2.0, 3, "Bandagem", "Cura ferimentos leves"));

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

        System.out.println("\n Ambiente inicial sorteado: " + ambiente.getNome());

        // Eventos dinâmicos
        List<Evento> eventos = new ArrayList<>();
        eventos.add(new EventoClimatico("Chuva Intensa", "Uma tempestade tropical atinge a região.", 0.3, "Redução de energia", "Chuva", 2, "Movimentação dificultada"));
        eventos.add(new EventoClimatico("Chuva Nutriente", "Chuva suave estimula frutas a brotarem nas árvores próximas.", 0.25, "Geração de alimento", "Chuva leve", 2, "Frutas frescas aparecem na vegetação"));
        eventos.add(new EventoCriatura("Ataque de Lobo", "Um lobo aparece entre os arbustos pronto para atacar.", 0.2, "Redução de vida", "Lobo", 6, "Fugir ou lutar"));
        eventos.add(new EventoCriatura("Infestação de Ratos", "Ratos invadem seus suprimentos e roubam comida.", 0.2, "Perda de alimentos", "Ratos", 3, "Espantar ou ignorar"));

        List<Item> itensDescobertos = new ArrayList<>();
        itensDescobertos.add(new ItemRemedios("Erva Calmante", 0.2, 1, "Natural", "Reduz dor e estresse"));

        eventos.add(new EventoDescoberta("Ervas Medicinais", "Você encontra ervas naturais em meio à vegetação.", 0.3, "Recuperação de sanidade", "Ervas escondidas", itensDescobertos, "Usar como infusão ou pomada"));

        // Sistema de eventos e turnos
        GerenciadorDeEventos gerenciador = new GerenciadorDeEventos(eventos);
        SistemaDeTurnos sistema = new SistemaDeTurnos(jogador, ambiente, gerenciador);

        // Início da simulação
        for (int i = 1; i <= 3; i++) {
            System.out.println("\n Turno " + i);
            sistema.iniciarTurno();
        }

        System.out.println("\n Fim da simulação de turnos.");
        scanner.close();
    }
}

