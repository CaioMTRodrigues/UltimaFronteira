package models.Ambientes;

import models.Personagens.Personagem;

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
        
        // Exemplo de ações durante a exploração
        if (this.isPossibilidadePesca()) {
            System.out.println("A pesca pode ser uma boa fonte de alimento aqui.");
        } else {
            System.out.println("O terreno está lamacento, dificultando a movimentação.");
        }

        // Exemplo de impacto nos atributos do jogador
        jogador.setEnergia(jogador.getEnergia() - 10);
        jogador.setSanidade(jogador.getSanidade() - 5);
    }
}
