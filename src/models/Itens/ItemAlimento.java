package models.Itens;

import models.Personagens.Personagem;

/**
 * Representa um item de alimento, que pode restaurar pontos de fome.
 */
public class ItemAlimento extends Item {

    private int valorNutricional;
    private String tipo;
    private int prazoValidade;

    /**
     * Construtor do item Alimento.
     *
     * @param nome Nome do alimento.
     * @param peso Peso do alimento.
     * @param durabilidade Número de usos.
     * @param valorNutricional Valor nutricional que reduz a fome.
     * @param tipo Tipo do alimento (fruta, carne, etc).
     * @param prazoValidade Número de turnos antes de estragar.
     */
    public ItemAlimento(String nome, double peso, int durabilidade, int valorNutricional, String tipo, int prazoValidade) {
        super(nome, peso, durabilidade);
        this.valorNutricional = valorNutricional;
        this.tipo = tipo;
        this.prazoValidade = prazoValidade;
    }

    /**
     * Retorna o valor nutricional do alimento.
     *
     * @return Valor nutricional.
     */
    public int getValorNutricional() {
        return valorNutricional;
    }

    /**
     * Define o valor nutricional do alimento.
     *
     * @param valorNutricional Valor nutricional.
     */
    public void setValorNutricional(int valorNutricional) {
        this.valorNutricional = valorNutricional;
    }

    /**
     * Retorna o tipo do alimento.
     *
     * @return Tipo do alimento.
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Define o tipo do alimento.
     *
     * @param tipo Tipo do alimento.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Retorna o prazo de validade do alimento.
     *
     * @return Número de turnos restantes.
     */
    public int getPrazoValidade() {
        return prazoValidade;
    }

    /**
     * Define o prazo de validade do alimento.
     *
     * @param prazoValidade Número de turnos.
     */
    public void setPrazoValidade(int prazoValidade) {
        this.prazoValidade = prazoValidade;
    }

    /**
     * Usa o item alimento, reduzindo fome e aumentando a sede do personagem.
     * Pode causar penalidade se estiver vencido.
     *
     * @param personagem O personagem que está utilizando o item.
     */
    @Override
    public void usar(Personagem personagem) {
        System.out.println("Você consumiu " + getNome() + ". Restaurou " + valorNutricional + " pontos de fome.");
        
        personagem.setFome(Math.max(0, personagem.getFome() - valorNutricional));
        personagem.setSede(Math.min(100, personagem.getSede() + 5));

        if (prazoValidade <= 0) {
            System.out.println("Este alimento está vencido. Pode causar intoxicação.");
            personagem.setSanidade(Math.max(0, personagem.getSanidade() - 10));
        }

        reduzirDurabilidade();
    }
}
