package models.Personagens;

/**
 * Classe que representa o personagem Sobrevivente Nato.
 * Possui resistência natural à fome e sede.
 */
public class SobreviventeNato extends Personagem {

    /**
     * Construtor do Sobrevivente Nato.
     */
    public SobreviventeNato(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    /**
     * Habilidade especial: reduz impacto da fome e sede.
     */
    @Override
    public void habilidadeEspecial() {
        System.out.println(this.getNome() + " resiste melhor à fome e sede.");
        this.setFome(this.getFome() - 5);
        this.setSede(this.getSede() - 5);
    }
}





