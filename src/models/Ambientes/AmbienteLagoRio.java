package models.Ambientes;

import java.util.Random;
import models.Itens.Item;
import models.Itens.ItemMaterial;
import models.Personagens.Personagem;
import models.exceptions.InventarioCheioException;

/**
 * Classe que representa o ambiente de Lago e Rio.
 * Uma área rica em água, mas com riscos naturais e criaturas aquáticas.
 */
public class AmbienteLagoRio extends Ambiente {

    private boolean aguaAbundante;
    private boolean possibilidadePesca;
    private boolean terrenoLamacento;

    /**
     * Construtor do ambiente de Lago e Rio com características definidas.
     */
    public AmbienteLagoRio() {
        super("Lago e Rio", "Uma área rica em água, mas perigosa devido às criaturas aquáticas.", 2, "Úmido");
        this.aguaAbundante = true;
        this.possibilidadePesca = true;
        this.terrenoLamacento = true;
    }

    // Getters e Setters
    public boolean isAguaAbundante() { return aguaAbundante; }
    public void setAguaAbundante(boolean aguaAbundante) { this.aguaAbundante = aguaAbundante; }

    public boolean isPossibilidadePesca() { return possibilidadePesca; }
    public void setPossibilidadePesca(boolean possibilidadePesca) { this.possibilidadePesca = possibilidadePesca; }

    public boolean isTerrenoLamacento() { return terrenoLamacento; }
    public void setTerrenoLamacento(boolean terrenoLamacento) { this.terrenoLamacento = terrenoLamacento; }

    /**
     * Exibe uma mensagem personalizada ao explorar o lago ou rio.
     * Este método implementa a ação definida na interface Exploravel.
     *
     * @param jogador O personagem que está explorando.
     */
    @Override
    public void explorar(Personagem jogador) {
        System.out.println("Você se aproxima do lago, observando as águas cristalinas.");
        System.out.println("Você encontra alguns recursos próximos à água.");

        Random rand = new Random();

        try {
            // Chance de coletar Água potável
            if (rand.nextDouble() < 0.7) {
                Item agua = new ItemMaterial("Água", 1.0, 100, "Liquido", 100);
                jogador.getInventario().adicionarItem(agua);
                System.out.println("Você coletou Água potável!");
            }

            // Chance de pescar Peixe
            if (rand.nextDouble() < 0.5 && this.possibilidadePesca) {
                Item peixe = new ItemMaterial("Peixe", 1.5, 30, "Comida", 30);
                jogador.getInventario().adicionarItem(peixe);
                System.out.println("Você pescou um Peixe!");
            }

            // Chance de coletar Vegetação Ribeirinha
            if (rand.nextDouble() < 0.4) {
                Item vegetacao = new ItemMaterial("Vegetação Ribeirinha", 0.7, 20, "Material", 20);
                jogador.getInventario().adicionarItem(vegetacao);
                System.out.println("Você coletou Vegetação Ribeirinha!");
            }

        } catch (InventarioCheioException e) {
            System.out.println("Seu inventário está cheio! Não conseguiu carregar novos materiais.");
        }

        if (this.isTerrenoLamacento()) {
            System.out.println("O terreno está lamacento, dificultando a movimentação.");
        } else {
            System.out.println("O terreno é firme e facilita seu deslocamento.");
        }

        // Impacto nos atributos do jogador
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);
    }
}

