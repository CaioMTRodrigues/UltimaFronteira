package models.Ambientes;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import models.Eventos.Evento;
import models.Itens.Item;

public abstract class Ambiente {

    private String nome; // Nome do ambiente
    private String descricao; // Descrição do ambiente
    private double dificuldadeExploracao; // Dificuldade de exploração do ambiente
    private List<Item> recursosDisponiveis; // Lista de recursos disponíveis no ambiente
    private List<Evento> eventosPossiveis; // Lista de eventos possíveis no ambiente
    private String condicoesClimaticas; // Condições climáticas do ambiente (ex: frio, úmido)

    // Construtor que inicializa o ambiente com seus dados principais
    public Ambiente(String nome, String descricao, double dificuldadeExploracao, String condicoesClimaticas) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldadeExploracao = dificuldadeExploracao;
        this.condicoesClimaticas = condicoesClimaticas;
        this.recursosDisponiveis = new ArrayList<>();
        this.eventosPossiveis = new ArrayList<>();
    }

    // Métodos de Acesso (Getters e Setters)
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getDificuldadeExploracao() {
        return dificuldadeExploracao;
    }

    public void setDificuldadeExploracao(double dificuldadeExploracao) {
        this.dificuldadeExploracao = dificuldadeExploracao;
    }

    public String getCondicoesClimaticas() {
        return condicoesClimaticas;
    }

    public void setCondicoesClimaticas(String condicoesClimaticas) {
        this.condicoesClimaticas = condicoesClimaticas;
    }

    public List<Item> getRecursosDisponiveis() {
        return recursosDisponiveis;
    }

    public void setRecursosDisponiveis(List<Item> recursosDisponiveis) {
        this.recursosDisponiveis = recursosDisponiveis;
    }

    public List<Evento> getEventosPossiveis() {
        return eventosPossiveis;
    }

    public void setEventosPossiveis(List<Evento> eventosPossiveis) {
        this.eventosPossiveis = eventosPossiveis;
    }

    // Método para explorar o ambiente e exibir recursos e eventos
    public void explorar() {
        System.out.println("Explorando o ambiente: " + nome);
        if (!recursosDisponiveis.isEmpty()) {
            System.out.println("Você encontrou alguns recursos:");
            for (Item item : recursosDisponiveis) {
                System.out.println("- " + item.getNome());
            }
        } else {
            System.out.println("Este local parece estar sem recursos.");
        }

        Evento evento = gerarEvento();
        if (evento != null) {
            System.out.println("Um evento inesperado ocorreu: " + evento.getNome());
            evento.executar();
        }
    }

    // Método para gerar um evento aleatório com base nas probabilidades do ambiente
    public Evento gerarEvento() {
        if (eventosPossiveis.isEmpty()) return null;
        Random random = new Random();
        if (random.nextDouble() < 0.3) {
            return eventosPossiveis.get(random.nextInt(eventosPossiveis.size()));
        }
        return null;
    }

    // Método para modificar as condições climáticas do ambiente
    public void modificarClima(String novoClima) {
        this.condicoesClimaticas = novoClima;
        System.out.println("O clima mudou para: " + novoClima);
    }

    // Método para adicionar um recurso ao ambiente
    public void adicionarRecurso(Item item) {
        recursosDisponiveis.add(item);
    }

    // Método para remover um recurso do ambiente após coleta
    public void removerRecurso(Item item) {
        recursosDisponiveis.remove(item);
    }

    // Método para exibir informações detalhadas do ambiente
    public void exibirInformacoes() {
        System.out.println("Ambiente: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Dificuldade de Exploração: " + dificuldadeExploracao);
        System.out.println("Clima: " + condicoesClimaticas);
        System.out.println("Recursos disponíveis: " + (recursosDisponiveis.isEmpty() ? "Nenhum" : recursosDisponiveis));
        System.out.println("Possíveis Eventos: " + (eventosPossiveis.isEmpty() ? "Nenhum" : eventosPossiveis));
    }

    // Método para atualizar os recursos do ambiente
    public void atualizarRecursos() {
        // Exemplo de como os recursos podem ser atualizados com o tempo
        System.out.println("Os recursos do ambiente estão sendo atualizados...");
    }
    
}


