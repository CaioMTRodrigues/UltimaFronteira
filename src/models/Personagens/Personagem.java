package models.Personagens;

import models.Itens.Inventario;

/**
 * Classe abstrata base para todos os personagens do jogo.
 */
public abstract class Personagem {

    protected String nome;
    protected double vida;
    protected double fome;
    protected double sede;
    protected double energia;
    protected double sanidade;
    protected String localizacao;
    protected Inventario inventario;

    /**
     * Construtor do personagem.
     */
    public Personagem(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.energia = energia;
        this.sanidade = sanidade;
        this.localizacao = localizacao;
        this.inventario = new Inventario(30.0);
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public double getVida() { return vida; }
    public void setVida(double vida) { this.vida = vida; }
    public double getFome() { return fome; }
    public void setFome(double fome) { this.fome = fome; }
    public double getSede() { return sede; }
    public void setSede(double sede) { this.sede = sede; }
    public double getEnergia() { return energia; }
    public void setEnergia(double energia) { this.energia = energia; }
    public double getSanidade() { return sanidade; }
    public void setSanidade(double sanidade) { this.sanidade = sanidade; }
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }
    public Inventario getInventario() { return inventario; }
    public void setInventario(Inventario inventario) { this.inventario = inventario; }

    /**
     * Exibe os atributos atuais do personagem.
     */
    public void exibirStatus() {
        System.out.println("\n Status de " + nome + ":");
        System.out.println("Vida: " + vida);
        System.out.println("Fome: " + fome);
        System.out.println("Sede: " + sede);
        System.out.println("Energia: " + energia);
        System.out.println("Sanidade: " + sanidade);
        System.out.println("Localização: " + localizacao);
    }

    /**
     * Permite o personagem descansar, recuperando energia e sanidade.
     */
    public void descansar() {
        energia += 15;
        sanidade += 10;
        System.out.println(" Você descansou. Energia e sanidade recuperadas.");
        if (energia > 100) energia = 100;
        if (sanidade > 100) sanidade = 100;
    }

    /**
     * Habilidade especial única de cada personagem.
     */
    public abstract void habilidadeEspecial();
}



