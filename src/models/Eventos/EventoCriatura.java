package models.Eventos;

import models.Ambientes.Ambiente;
import models.Personagens.Personagem;
import models.Itens.*;
import models.exceptions.InventarioCheioException;

import java.util.Random;
import java.util.Scanner;

/**
 * Representa um evento relacionado ao encontro com uma criatura.
 * O evento pode resultar em uma luta ou fuga, com impactos na vida e sanidade do personagem.
 */
public class EventoCriatura extends Evento {

    private String tipoCriatura;
    private int nivelPerigo;
    private String opcoesAcao;

    /**
     * Construtor do evento de encontro com uma criatura.
     * 
     * @param nome Nome do evento.
     * @param descricao Descrição do evento.
     * @param probabilidade Probabilidade de ocorrência do evento.
     * @param impacto Impacto causado no jogo.
     * @param tipoCriatura Tipo de criatura encontrada.
     * @param nivelPerigo Nível de perigo da criatura.
     * @param opcoesAcao Opções de ação do jogador (ex: fugir ou lutar).
     */
    public EventoCriatura(String nome, String descricao, double probabilidade, String impacto, String tipoCriatura, int nivelPerigo, String opcoesAcao) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoCriatura = tipoCriatura;
        this.nivelPerigo = nivelPerigo;
        this.opcoesAcao = opcoesAcao;
    }

    /**
     * Retorna o tipo de criatura encontrada.
     * 
     * @return O tipo da criatura.
     */
    public String getTipoCriatura() {
        return tipoCriatura;
    }

    /**
     * Define o tipo de criatura encontrada.
     * 
     * @param tipoCriatura O tipo da criatura.
     */
    public void setTipoCriatura(String tipoCriatura) {
        this.tipoCriatura = tipoCriatura;
    }

    /**
     * Retorna o nível de perigo associado à criatura.
     * 
     * @return O nível de perigo da criatura.
     */
    public int getNivelPerigo() {
        return nivelPerigo;
    }

    /**
     * Define o nível de perigo da criatura.
     * 
     * @param nivelPerigo O nível de perigo a ser atribuído à criatura.
     */
    public void setNivelPerigo(int nivelPerigo) {
        this.nivelPerigo = nivelPerigo;
    }

    /**
     * Retorna as opções de ação disponíveis para o jogador durante o encontro.
     * 
     * @return As opções de ação como uma string.
     */
    public String getOpcoesAcao() {
        return opcoesAcao;
    }

    /**
     * Define as opções de ação disponíveis para o jogador durante o encontro.
     * 
     * @param opcoesAcao As opções de ação.
     */
    public void setOpcoesAcao(String opcoesAcao) {
        this.opcoesAcao = opcoesAcao;
    }

    /**
     * Executa o evento de encontro com a criatura, oferecendo ao jogador opções de ação.
     * O jogador pode lutar ou fugir, o que impacta seus atributos.
     * 
     * @param jogador O personagem afetado pelo evento.
     * @param ambiente O ambiente onde o evento ocorre.
     */
    @Override
    public void executar(Personagem jogador, Ambiente ambiente) {
        System.out.println("⚠ Encontro com Criatura: " + tipoCriatura);
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Nível de Perigo: " + nivelPerigo);
        System.out.println("Opções disponíveis: " + opcoesAcao);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Escolha uma ação: ");
        System.out.println("1 - Lutar");
        System.out.println("2 - Fugir");
        int escolha = scanner.nextInt();
        scanner.nextLine(); // Limpar buffer

        if (escolha == 1) {
            lutar(jogador);
        } else if (escolha == 2) {
            fugir(jogador);
        } else {
            System.out.println("Opção inválida.");
        }
    }

    /**
     * Realiza a luta entre o jogador e a criatura. 
     * Aplica dano ao jogador e, se o jogador vencer, oferece uma recompensa.
     * 
     * @param jogador O personagem afetado pelo evento.
     */
    private void lutar(Personagem jogador) {
        System.out.println("Você escolheu lutar contra o " + tipoCriatura);

        Random random = new Random();
        int danoCriatura = nivelPerigo * 5;
        int danoJogador = random.nextInt(15) + 5;

        // Aplica dano usando o método que já trata vida <= 0
        jogador.aplicarDano(danoCriatura);
        jogador.setSanidade(jogador.getSanidade() - (nivelPerigo * 2));

        System.out.println("A criatura causou " + danoCriatura + " de dano!");
        System.out.println("Você perdeu " + danoCriatura + " de vida e " + (nivelPerigo * 2) + " de sanidade.");

        if (jogador.getVida() > 0) {
            System.out.println("Você venceu o combate contra o " + tipoCriatura + "!");

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

    /**
     * Tenta fugir do encontro com a criatura. A chance de sucesso é aleatória.
     * Se a fuga falhar, o jogador deve lutar contra a criatura.
     * 
     * @param jogador O personagem afetado pelo evento.
     */
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
