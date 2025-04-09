package models.Personagens;

import java.util.List;
import models.Itens.Item;

public abstract class Personagem {

    private String nome;
    private double vida;
    private double fome;
    private double sede;
    private double energia;
    private double sanidade;
    private List<Item> inventario;  // Lista de itens no inventário
    private String localizacao;

    // Construtor que inicializa os dados principais do personagem
    public Personagem(String nome, double vida, double fome, double sede, double energia, double sanidade, String localizacao) {
        this.nome = nome;
        this.vida = vida;
        this.fome = fome;
        this.sede = sede;
        this.energia = energia;
        this.sanidade = sanidade;
        this.localizacao = localizacao;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
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
    public List<Item> getInventario() { return inventario; }  // Agora retorna uma lista de Item
    public void setInventario(List<Item> inventario) { this.inventario = inventario; }
    public String getLocalizacao() { return localizacao; }
    public void setLocalizacao(String localizacao) { this.localizacao = localizacao; }

    // Métodos de ação do personagem
    public void comer(Item alimento) {
        System.out.println(this.nome + " está comendo " + alimento.getNome());
        this.fome -= 10; // Exemplo de como comer pode afetar a fome
    }

    public void beber(Item agua) {
        System.out.println(this.nome + " está bebendo " + agua.getNome());
        this.sede -= 10; // Exemplo de como beber pode afetar a sede
    }

    public void descansar() {
        System.out.println(this.nome + " está descansando.");
        this.energia += 20; // Recupera energia durante o descanso
    }

    // Método abstrato que será implementado nas subclasses para habilidade especial
    public abstract void habilidadeEspecial();

    // Método abstrato para realizar a ação no turno
    public abstract void realizarAcao();

    // Método para atualizar os atributos do personagem
    public void atualizarAtributos() {
        // Exemplo de atualizações que podem ocorrer em cada turno
        this.fome += 5;    // A fome aumenta com o tempo
        this.sede += 5;    // A sede aumenta com o tempo
        this.energia -= 5; // A energia diminui com o tempo
        this.sanidade -= 2; // A sanidade pode diminuir conforme eventos ou fadiga
        System.out.println(this.nome + " teve seus atributos atualizados.");
    }

    // Método para exibir o status do personagem
    public String getStatus() {
        return "Status de " + nome + ":\n" +
               "Vida: " + vida + "\n" +
               "Fome: " + fome + "\n" +
               "Sede: " + sede + "\n" +
               "Energia: " + energia + "\n" +
               "Sanidade: " + sanidade + "\n" +
               "Localização: " + localizacao;
    }

}

