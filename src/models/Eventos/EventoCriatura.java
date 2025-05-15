package models.Eventos;

import models.Ambientes.Ambiente;
import models.Personagens.Personagem;
import models.Itens.*;
import models.exceptions.InventarioCheioException;

import java.util.Random;
import java.util.Scanner;

/**
 * Representa um evento relacionado ao encontro com uma criatura.
 */
public class EventoCriatura extends Evento {

    private String tipoCriatura;
    private int nivelPerigo;
    private String opcoesAcao;

    public EventoCriatura(String nome, String descricao, double probabilidade, String impacto, String tipoCriatura, int nivelPerigo, String opcoesAcao) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoCriatura = tipoCriatura;
        this.nivelPerigo = nivelPerigo;
        this.opcoesAcao = opcoesAcao;
    }

    public String getTipoCriatura() { return tipoCriatura; }
    public void setTipoCriatura(String tipoCriatura) { this.tipoCriatura = tipoCriatura; }

    public int getNivelPerigo() { return nivelPerigo; }
    public void setNivelPerigo(int nivelPerigo) { this.nivelPerigo = nivelPerigo; }

    public String getOpcoesAcao() { return opcoesAcao; }
    public void setOpcoesAcao(String opcoesAcao) { this.opcoesAcao = opcoesAcao; }

    @Override
    public void executar(Personagem jogador, Ambiente ambiente) {
        System.out.println("⚠ Encontro com Criatura: " + tipoCriatura);
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Nível de Perigo: " + nivelPerigo);
        System.out.println("Opções disponíveis: " + opcoesAcao);

        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Escolha uma ação: ");
            System.out.println("1 - Lutar");
            System.out.println("2 - Fugir");
            int escolha = scanner.nextInt();
            scanner.nextLine(); // limpar buffer

            if (escolha == 1) {
                lutar(jogador);
            } else if (escolha == 2) {
                fugir(jogador);
            } else {
                System.out.println("Opção inválida.");
            }
        }
    }

    private void lutar(Personagem jogador) {
        System.out.println("Você escolheu lutar contra o " + tipoCriatura);

        Random random = new Random();
        int danoJogador = nivelPerigo * 5;
        int danoCriatura = random.nextInt(15) + 5;

        jogador.setVida(jogador.getVida() - danoJogador);
        jogador.setSanidade(jogador.getSanidade() - (nivelPerigo * 2));

        System.out.println("A criatura causou " + danoCriatura + " de dano!");
        System.out.println("Você perdeu " + danoJogador + " de vida e " + (nivelPerigo * 2) + " de sanidade.");

        if (jogador.getVida() > 0) {
            System.out.println("Você venceu o combate contra o " + tipoCriatura + "!");

            // Recompensa baseada no tipo de criatura
            Item recompensa;
            switch (tipoCriatura.toLowerCase()) {
                case "lobo":
                    recompensa = new ItemAlimento("Carne de Lobo", 1.0, 1, 20, "Carne", 5);
                    break;
                case "urso":
                    recompensa = new ItemMaterial("Pele de Urso", 2.5, 1, "Couro", 70);
                    break;
                default:
                    recompensa = new ItemAlimento("Carne Misteriosa", 0.8, 1, 10, "Carne", 3);
                    break;
            }

            System.out.println("Você encontrou um item: " + recompensa.getNome());

            try {
                jogador.getInventario().adicionarItem(recompensa);
            } catch (InventarioCheioException e) {
                System.out.println("Não foi possível adicionar " + recompensa.getNome() + ": " + e.getMessage());
            }

            jogador.setSanidade(jogador.getSanidade() + 5);
            System.out.println("Sua moral aumentou com a vitória. Sanidade +5.");

        } else {
            System.out.println("Você morreu durante o combate.");
            System.exit(0);
        }
    }

    private void fugir(Personagem jogador) {
        System.out.println("Você escolheu tentar fugir...");

        Random random = new Random();
        int chanceDeFuga = random.nextInt(100);

        if (chanceDeFuga < 50) {
            System.out.println("Você conseguiu fugir com sucesso!");
        } else {
            System.out.println("Você não conseguiu fugir a tempo! A criatura atacou.");
            lutar(jogador);
        }
    }
}
