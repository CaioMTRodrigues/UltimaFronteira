package models.Ambientes;

import java.util.Random;
import models.Itens.Item;
import models.Itens.ItemMaterial;
import models.Personagens.Personagem;
import models.exceptions.InventarioCheioException;

/**
 * Representa o ambiente de Ruínas Abandonadas.
 * Estruturas antigas que podem conter recursos valiosos ou perigos escondidos.
 */
public class AmbienteRuinas extends Ambiente {

    private boolean estruturasInstaveis;
    private boolean presencaSobreviventes;
    private boolean baixoRiscoClimatico;

    /**
     * Construtor das ruínas, definindo suas características padrão.
     */
    public AmbienteRuinas() {
        super("Ruínas Abandonadas", "Vestígios de uma civilização antiga, cheios de segredos.", 3, "Neutro");
        this.estruturasInstaveis = true;
        this.presencaSobreviventes = true;
        this.baixoRiscoClimatico = true;
    }

    /**
     * Retorna se o ambiente tem estruturas instáveis.
     * 
     * @return true se as estruturas são instáveis, caso contrário, false.
     */
    public boolean isEstruturasInstaveis() {
        return estruturasInstaveis;
    }

    /**
     * Define se o ambiente possui estruturas instáveis.
     * 
     * @param estruturasInstaveis Valor a ser configurado.
     */
    public void setEstruturasInstaveis(boolean estruturasInstaveis) {
        this.estruturasInstaveis = estruturasInstaveis;
    }

    /**
     * Retorna se há sobreviventes no ambiente.
     * 
     * @return true se há sobreviventes, caso contrário, false.
     */
    public boolean isPresencaSobreviventes() {
        return presencaSobreviventes;
    }

    /**
     * Define se há sobreviventes no ambiente.
     * 
     * @param presencaSobreviventes Valor a ser configurado.
     */
    public void setPresencaSobreviventes(boolean presencaSobreviventes) {
        this.presencaSobreviventes = presencaSobreviventes;
    }

    /**
     * Retorna se o ambiente possui baixo risco climático.
     * 
     * @return true se o risco climático for baixo, caso contrário, false.
     */
    public boolean isBaixoRiscoClimatico() {
        return baixoRiscoClimatico;
    }

    /**
     * Define se o ambiente tem baixo risco climático.
     * 
     * @param baixoRiscoClimatico Valor a ser configurado.
     */
    public void setBaixoRiscoClimatico(boolean baixoRiscoClimatico) {
        this.baixoRiscoClimatico = baixoRiscoClimatico;
    }

    /**
     * Exibe uma mensagem personalizada ao explorar as ruínas.
     * Este método implementa a ação definida na interface Exploravel.
     * 
     * @param jogador O personagem que está explorando o ambiente.
     */
    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você adentra as ruínas, sentindo o cheiro da poeira e do tempo.");
        System.out.println("Você encontra alguns recursos nas ruínas.");

        Random rand = new Random();

        try {
            // Chance de encontrar Ferramenta antiga
            if (rand.nextDouble() < 0.5) {
                Item ferramenta = new ItemMaterial("Ferramenta Antiga", 2.5, 60, "Ferramenta", 50);
                jogador.getInventario().adicionarItem(ferramenta);
                System.out.println("Você encontrou uma Ferramenta Antiga!");
            }

            // Chance de encontrar Alimento enlatado
            if (rand.nextDouble() < 0.4) {
                Item alimento = new ItemMaterial("Alimento Enlatado", 1.0, 40, "Comida", 40);
                jogador.getInventario().adicionarItem(alimento);
                System.out.println("Você achou um Alimento Enlatado!");
            }

            // Chance de encontrar Munição
            if (rand.nextDouble() < 0.3) {
                Item municao = new ItemMaterial("Munição", 1.2, 50, "Material", 50);
                jogador.getInventario().adicionarItem(municao);
                System.out.println("Você coletou Munição!");
            }

        } catch (InventarioCheioException e) {
            System.out.println("Seu inventário está cheio! Não conseguiu carregar novos materiais.");
        }

        if (this.isPresencaSobreviventes()) {
            System.out.println("Há outros sobreviventes nas ruínas, tome cuidado!");
        } else {
            System.out.println("As ruínas estão desertas, mas há muitos segredos a serem desvendados.");
        }

        // Marca o jogador como tendo encontrado um refúgio seguro
        if (!jogador.isRefugioSeguroEncontrado()) {
            jogador.setRefugioSeguroEncontrado(true);
            System.out.println("Você encontrou um refúgio seguro nas ruínas!");
        }

        // Impacto nos atributos do jogador
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);
    }
}