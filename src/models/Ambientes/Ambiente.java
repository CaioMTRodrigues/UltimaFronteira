package models.Ambientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.Eventos.Evento;
import models.Itens.*;
import models.Personagens.Personagem;

/**
 * Classe abstrata que representa um ambiente no jogo.
 * Define atributos e comportamentos comuns a todos os tipos de ambientes.
 */
public abstract class Ambiente {

    private String nome;
    private String descricao;
    private double dificuldadeExploracao;
    private List<Item> recursosDisponiveis;
    private List<Evento> eventosPossiveis;
    private String condicoesClimaticas;

    /**
     * Construtor do ambiente base.
     */
    public Ambiente(String nome, String descricao, double dificuldadeExploracao, String condicoesClimaticas) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldadeExploracao = dificuldadeExploracao;
        this.condicoesClimaticas = condicoesClimaticas;
        this.recursosDisponiveis = new ArrayList<>();
        this.eventosPossiveis = new ArrayList<>();
    }

    // Getters e Setters
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }

    public double getDificuldadeExploracao() { return dificuldadeExploracao; }
    public void setDificuldadeExploracao(double dificuldadeExploracao) { this.dificuldadeExploracao = dificuldadeExploracao; }

    public String getCondicoesClimaticas() { return condicoesClimaticas; }
    public void setCondicoesClimaticas(String condicoesClimaticas) { this.condicoesClimaticas = condicoesClimaticas; }

    public List<Item> getRecursosDisponiveis() { return recursosDisponiveis; }
    public void setRecursosDisponiveis(List<Item> recursosDisponiveis) { this.recursosDisponiveis = recursosDisponiveis; }

    public List<Evento> getEventosPossiveis() { return eventosPossiveis; }
    public void setEventosPossiveis(List<Evento> eventosPossiveis) { this.eventosPossiveis = eventosPossiveis; }

    /**
     * Executa a exploração do ambiente, exibindo os recursos e sorteando um evento.
     * Também adiciona recursos essenciais aleatórios ao inventário do jogador.
     *
     * @param jogador O personagem que está explorando.
     */
    public void explorar(Personagem jogador) {
        System.out.println("Explorando o ambiente: " + nome);

        if (!recursosDisponiveis.isEmpty()) {
            System.out.println("Você encontrou alguns recursos fixos:");
            for (Item item : recursosDisponiveis) {
                System.out.println("- " + item.getNome());
            }
        } else {
            System.out.println("Este local parece estar sem recursos fixos...");
        }

        // Geração aleatória de novos recursos essenciais
        Random random = new Random();

        if (random.nextDouble() < 0.6) {
            Item alimento = new ItemAlimento("Fruta Silvestre", 0.4, 1, 10, "Fruta", 5);
            jogador.getInventario().adicionarItem(alimento);
            System.out.println("Você encontrou um alimento: " + alimento.getNome());
        }

        if (random.nextDouble() < 0.5) {
            Item agua = new ItemAgua("Garrafa de Água", 1.0, 1, true, 0.5);
            jogador.getInventario().adicionarItem(agua);
            System.out.println("Você encontrou água potável!");
        }

        if (random.nextDouble() < 0.2) {
            Item remedio = new ItemRemedios("Ervas Medicinais", 0.3, 1, "Ervas", "Alivia dores leves");
            jogador.getInventario().adicionarItem(remedio);
            System.out.println("Você encontrou ervas medicinais.");
        }

        // Evento aleatório
        Evento evento = gerarEvento();
        if (evento != null) {
            System.out.println("Um evento inesperado ocorreu: " + evento.getNome());
            evento.executar(jogador, this);
        }
    }

    /**
     * Gera um evento aleatório com base nas chances definidas para o ambiente.
     */
    public Evento gerarEvento() {
        if (eventosPossiveis.isEmpty()) return null;
        Random random = new Random();
        if (random.nextDouble() < 0.3) {
            return eventosPossiveis.get(random.nextInt(eventosPossiveis.size()));
        }
        return null;
    }

    /**
     * Modifica as condições climáticas atuais do ambiente.
     */
    public void modificarClima(String novoClima) {
        this.condicoesClimaticas = novoClima;
        System.out.println("O clima mudou para: " + novoClima);
    }

    /**
     * Adiciona um recurso ao ambiente.
     */
    public void adicionarRecurso(Item item) {
        recursosDisponiveis.add(item);
    }

    /**
     * Remove um recurso do ambiente.
     */
    public void removerRecurso(Item item) {
        recursosDisponiveis.remove(item);
    }

    /**
     * Exibe todas as informações do ambiente.
     */
    public void exibirInformacoes() {
        System.out.println("Ambiente: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Dificuldade de Exploração: " + dificuldadeExploracao);
        System.out.println("Clima: " + condicoesClimaticas);
        System.out.println("Recursos disponíveis: " + (recursosDisponiveis.isEmpty() ? "Nenhum" : recursosDisponiveis));
        System.out.println("Possíveis Eventos: " + (eventosPossiveis.isEmpty() ? "Nenhum" : eventosPossiveis));
    }
}
