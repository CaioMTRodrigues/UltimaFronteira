package models.Ambientes;

public class AmbienteRuinas extends Ambiente {

    private boolean estruturasInstaveis;
    private boolean presencaSobreviventes;
    private boolean baixoRiscoClimatico;

    // Construtor que inicializa os atributos específicos das ruínas
    public AmbienteRuinas() {
        super("Ruínas Abandonadas", "Vestígios de uma civilização antiga, cheios de segredos.", 3, "Neutro");
        this.estruturasInstaveis = true;
        this.presencaSobreviventes = true;
        this.baixoRiscoClimatico = true;
    }

    // Métodos de Acesso
    public boolean isEstruturasInstaveis() { return estruturasInstaveis; }
    public void setEstruturasInstaveis(boolean estruturasInstaveis) { this.estruturasInstaveis = estruturasInstaveis; }
    public boolean isPresencaSobreviventes() { return presencaSobreviventes; }
    public void setPresencaSobreviventes(boolean presencaSobreviventes) { this.presencaSobreviventes = presencaSobreviventes; }
    public boolean isBaixoRiscoClimatico() { return baixoRiscoClimatico; }
    public void setBaixoRiscoClimatico(boolean baixoRiscoClimatico) { this.baixoRiscoClimatico = baixoRiscoClimatico; }

    // Método sobrescrito para explorar o ambiente, agora inclui características específicas das ruínas
    @Override
    public void explorar() {
        System.out.println("Você adentra as ruínas, sentindo o cheiro da poeira e do tempo.");
        super.explorar();
    }
}



