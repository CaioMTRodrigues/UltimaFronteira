package models.Personagens;

import java.util.ArrayList;
import java.util.List;

import models.Ambientes.Ambiente;
import models.Itens.Item;
import models.Itens.ItemAgua;
import models.Itens.ItemAlimento;
import models.Itens.ItemArmas;

public abstract class Personagem {
    
    // Atributos Principais
    protected String nome; // Nome do personagem
    protected int vida; // Vida do personagem (100 é o máximo)
    protected int fome; // Nível de fome (100 é o máximo)
    protected int sede; // Nível de sede (100 é o máximo)
    protected int energia; // Nível de energia (100 é o máximo)
    protected int sanidade; // Nível de sanidade (100 é o máximo)
    protected List<Item> inventario; // Lista de itens do personagem
    protected Ambiente localizacao; // Localização atual do personagem (ambiente)

    // Construtor
    public Personagem(String nome, Ambiente localizacao) {
        this.nome = nome;
        this.vida = 100;
        this.fome = 100;
        this.sede = 100;
        this.energia = 100;
        this.sanidade = 100;
        this.inventario = new ArrayList<>();
        this.localizacao = localizacao;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public int getVida() { return vida; }
    public void setVida(int vida) { this.vida = vida; }

    public int getFome() { return fome; }
    public void setFome(int fome) { this.fome = fome; }

    public int getSede() { return sede; }
    public void setSede(int sede) { this.sede = sede; }

    public int getEnergia() { return energia; }
    public void setEnergia(int energia) { this.energia = energia; }

    public int getSanidade() { return sanidade; }
    public void setSanidade(int sanidade) { this.sanidade = sanidade; }

    public List<Item> getInventario() { return inventario; }
    public void setInventario(List<Item> inventario) { this.inventario = inventario; }

    public Ambiente getLocalizacao() { return localizacao; }
    public void setLocalizacao(Ambiente localizacao) { this.localizacao = localizacao; }

    // Métodos de Ação
    public void moverPara(Ambiente novoAmbiente) {
        this.localizacao = novoAmbiente;
        System.out.println(nome + " se moveu para " + novoAmbiente.getNome());
    }

    public void comer(ItemAlimento alimento) {
        if (inventario.contains(alimento)) {
            fome = Math.min(fome + alimento.getValorNutricional(), 100);
            inventario.remove(alimento);
            System.out.println(nome + " comeu " + alimento.getNome() + " e restaurou fome.");
        } else {
            System.out.println("Item não encontrado no inventário!");
        }
    }

    public void beber(ItemAgua agua) {
        if (inventario.contains(agua)) {
            sede = Math.min(sede + 30, 100);
            inventario.remove(agua);
            System.out.println(nome + " bebeu " + agua.getNome() + " e restaurou sede.");
        } else {
            System.out.println("Água não encontrada no inventário!");
        }
    }

    public void descansar() {
        energia = Math.min(energia + 50, 100);
        sanidade = Math.min(sanidade + 10, 100);
        System.out.println(nome + " descansou e recuperou energia e sanidade.");
    }

    public void atacar(ItemArmas arma) {
        if (inventario.contains(arma)) {
            System.out.println(nome + " atacou com " + arma.getNome() + " causando " + arma.getDano() + " de dano!");
            arma.atacar();
        } else {
            System.out.println("⚠ Nenhuma arma disponível no inventário!");
        }
    }

    public void adicionarItemAoInventario(Item item) {
        inventario.add(item);
        System.out.println(nome + " pegou " + item.getNome() + ".");
    }

    public void removerItemDoInventario(Item item) {
        inventario.remove(item);
        System.out.println(nome + " descartou " + item.getNome() + ".");
    }

    public void exibirStatus() {
        System.out.println("=== Status de " + nome + " ===");
        System.out.println("Vida: " + vida);
        System.out.println("Fome: " + fome);
        System.out.println("Sede: " + sede);
        System.out.println("Energia: " + energia);
        System.out.println("Sanidade: " + sanidade);
        System.out.println("Localização: " + localizacao.getNome());
        System.out.println("==============================");
    }

    // Método abstrato para habilidade especial da subclasse
    public abstract void habilidadeEspecial();
}
