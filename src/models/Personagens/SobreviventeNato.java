package models.Personagens;

public class SobreviventeNato extends Personagem {

    public SobreviventeNato(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        super(nome, vida, fome, sede, energia, sanidade, localizacao);
    }

    // Implementação da habilidade especial do sobrevivente nato
    @Override
    public void habilidadeEspecial() {
        System.out.println(this.getNome() + " está usando sua habilidade de resistência.");
        // O sobrevivente nato tem uma resistência maior a fome e sede
        this.setFome(this.getFome() - 5);  // Menor impacto da fome
        this.setSede(this.getSede() - 5);  // Menor impacto da sede
    }
}



