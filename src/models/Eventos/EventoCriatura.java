package models.Eventos;

import java.util.List;
import models.Ambientes.Ambiente;
import models.Itens.Item;
import models.Itens.ItemArmas;
import models.Personagens.Personagem;
import java.util.Random;
import java.util.Scanner;

/**
 * Representa um evento relacionado ao encontro com uma criatura.
 */
public class EventoCriatura extends Evento {

    private String tipoCriatura;
    private int nivelPerigo;
    private String opcoesAcao;

    /**
     * Construtor do evento de criatura.
     *
     * @param nome Nome do evento.
     * @param descricao Descrição do evento.
     * @param probabilidade Probabilidade de ocorrência.
     * @param impacto Impacto causado.
     * @param tipoCriatura Tipo da criatura (ex: lobo, urso).
     * @param nivelPerigo Nível de perigo.
     * @param opcoesAcao Ações possíveis do jogador.
     */
    public EventoCriatura(String nome, String descricao, double probabilidade, String impacto, String tipoCriatura, int nivelPerigo, String opcoesAcao) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoCriatura = tipoCriatura;
        this.nivelPerigo = nivelPerigo;
        this.opcoesAcao = opcoesAcao;
    }

    // Getters e Setters
    public String getTipoCriatura() { return tipoCriatura; }
    public void setTipoCriatura(String tipoCriatura) { this.tipoCriatura = tipoCriatura; }

    public int getNivelPerigo() { return nivelPerigo; }
    public void setNivelPerigo(int nivelPerigo) { this.nivelPerigo = nivelPerigo; }

    public String getOpcoesAcao() { return opcoesAcao; }
    public void setOpcoesAcao(String opcoesAcao) { this.opcoesAcao = opcoesAcao; }

    /**
     * Executa o evento de encontro com criatura, afetando o personagem de forma dinâmica.
     *
     * @param jogador O personagem afetado.
     * @param ambiente O ambiente onde o encontro ocorre.
     */
    @Override
    public void executar(Personagem jogador, Ambiente ambiente) {
        System.out.println("⚠ Encontro com Criatura: " + tipoCriatura);
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Nível de Perigo: " + nivelPerigo);
        System.out.println("Opções disponíveis: " + opcoesAcao);

        // Escolha de ação (lutar ou fugir)
        Scanner scanner = new Scanner(System.in);
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

    // Método para lutar contra a criatura
    private void lutar(Personagem jogador) {
        System.out.println("Você escolheu lutar contra o " + tipoCriatura);

        // Calculando dano ao jogador e à criatura
        Random random = new Random();
        int danoJogador = nivelPerigo * 5;
        int danoCriatura = random.nextInt(15) + 5; // Dano aleatório da criatura

        // Reduzindo vida do jogador
        jogador.setVida(jogador.getVida() - danoJogador);
        jogador.setSanidade(jogador.getSanidade() - (nivelPerigo * 2)); // Afeta a sanidade

        System.out.println("A criatura causou " + danoCriatura + " de dano!");
        System.out.println("Você perdeu " + danoJogador + " de vida e " + (nivelPerigo * 2) + " de sanidade.");

        // Se o jogador sobreviver, o combate continua e a criatura pode ser derrotada
        if (jogador.getVida() > 0) {
            System.out.println("Você venceu o combate contra o " + tipoCriatura);
            // O jogador pode ganhar itens após derrotar a criatura
        } else {
            System.out.println("Você morreu durante o combate.");
            System.exit(0);
        }
    }

    // Método para fugir do combate
    private void fugir(Personagem jogador) {
        System.out.println("Você escolheu tentar fugir...");

        Random random = new Random();
        int chanceDeFuga = random.nextInt(100);

        if (chanceDeFuga < 50) { // 50% de chance de fuga
            System.out.println("Você conseguiu fugir com sucesso!");
        } else {
            System.out.println("Você não conseguiu fugir a tempo! A criatura atacou.");
            lutar(jogador); // Se falhar na fuga, começa o combate
        }
    }
}
