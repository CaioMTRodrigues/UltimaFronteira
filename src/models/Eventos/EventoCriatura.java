package models.Eventos;

import java.util.List;
import models.Ambientes.Ambiente;
import models.Itens.Item;
import models.Itens.ItemAlimento;
import models.Personagens.Personagem;

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

        int dano = nivelPerigo * 5;
        jogador.setVida(jogador.getVida() - dano);
        jogador.setSanidade(jogador.getSanidade() - (nivelPerigo * 2));

        System.out.println(tipoCriatura + " causou " + dano + " de dano!");

        // Efeito temático: criatura forte pode destruir um item qualquer
        if (nivelPerigo >= 7) {
            List<Item> itens = jogador.getInventario().getListaItens();
            if (!itens.isEmpty()) {
                Item perdido = itens.get(0);
                jogador.getInventario().removerItem(perdido.getNome());
                System.out.println(tipoCriatura + " destruiu um item do seu inventário: " + perdido.getNome());
            }
        }

        // Efeito extra para criaturas pequenas
        if (nivelPerigo < 4) {
            List<Item> itens = jogador.getInventario().getListaItens();
            for (Item item : itens) {
                if (item instanceof ItemAlimento) {
                    jogador.getInventario().removerItem(item.getNome());
                    System.out.println("Pequenos roedores roubaram sua comida: " + item.getNome());
                    break;
                }
            }
        }

        if (nivelPerigo > 5) {
            System.out.println("Esta criatura é extremamente perigosa! Fuja ou prepare-se para lutar!");
        }
    }
}
