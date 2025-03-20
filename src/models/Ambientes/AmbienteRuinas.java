package models.Ambientes;

public class AmbienteRuinas extends Ambiente {

    private boolean estruturasInstaveis;    // Se as estruturas nas ruínas são instáveis
    private boolean presencaSobreviventes;  // Se há sobreviventes nas ruínas
    private boolean baixoRiscoClimatico;   // Se há baixo risco climático nas ruínas

    // Construtor
    public AmbienteRuinas() {
        super("Ruínas Abandonadas", "Vestígios de uma civilização antiga, cheios de segredos.", 3, "Neutro");
        this.estruturasInstaveis = true;
        this.presencaSobreviventes = true;
        this.baixoRiscoClimatico = true;
    }

    // Métodos de Acesso (Getters e Setters)
    public boolean isEstruturasInstaveis() {
        return estruturasInstaveis;
    }

    public void setEstruturasInstaveis(boolean estruturasInstaveis) {
        this.estruturasInstaveis = estruturasInstaveis;
    }

    public boolean isPresencaSobreviventes() {
        return presencaSobreviventes;
    }

    public void setPresencaSobreviventes(boolean presencaSobreviventes) {
        this.presencaSobreviventes = presencaSobreviventes;
    }

    public boolean isBaixoRiscoClimatico() {
        return baixoRiscoClimatico;
    }

    public void setBaixoRiscoClimatico(boolean baixoRiscoClimatico) {
        this.baixoRiscoClimatico = baixoRiscoClimatico;
    }

    // Método sobrescrito para explorar o ambiente
    @Override
    public void explorar() {
        System.out.println("Você adentra as ruínas, sentindo o cheiro da poeira e do tempo.");
        super.explorar();
    }
}
