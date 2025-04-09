package models.Ambientes;

/**
 * Classe que representa o ambiente de Ruínas Abandonadas.
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

    // Getters e Setters
    public boolean isEstruturasInstaveis() { return estruturasInstaveis; }
    public void setEstruturasInstaveis(boolean estruturasInstaveis) { this.estruturasInstaveis = estruturasInstaveis; }

    public boolean isPresencaSobreviventes() { return presencaSobreviventes; }
    public void setPresencaSobreviventes(boolean presencaSobreviventes) { this.presencaSobreviventes = presencaSobreviventes; }

    public boolean isBaixoRiscoClimatico() { return baixoRiscoClimatico; }
    public void setBaixoRiscoClimatico(boolean baixoRiscoClimatico) { this.baixoRiscoClimatico = baixoRiscoClimatico; }

    /**
     * Exibe uma mensagem personalizada ao explorar as ruínas.
     */
    @Override
    public void explorar() {
        System.out.println("Você adentra as ruínas, sentindo o cheiro da poeira e do tempo.");
        super.explorar();
    }
}
