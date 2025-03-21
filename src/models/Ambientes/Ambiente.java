package models.Ambientes;

import models.Eventos.Evento;
import models.Itens.Item;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Ambiente {

    protected String nome;
    protected String descricao;
    protected double dificuldadeExploracao;
    protected List<Item> recursosDisponiveis;
    protected List<Evento> eventosPossiveis;
    protected String condicoesClimaticas;

    public Ambiente(String nome, String descricao, double dificuldadeExploracao, String condicoesClimaticas) {
        this.nome = nome;
        this.descricao = descricao;
        this.dificuldadeExploracao = dificuldadeExploracao;
        this.condicoesClimaticas = condicoesClimaticas;
        this.recursosDisponiveis = new ArrayList<>();
        this.eventosPossiveis = new ArrayList<>();
    }

    // Método para explorar o ambiente
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
            evento.executar(); // Método a ser implementado nos eventos
        }
    }

    // Método para gerar um evento aleatório baseado nas probabilidades do ambiente
    public Evento gerarEvento() {
        if (eventosPossiveis.isEmpty()) return null;
        Random random = new Random();
        if (random.nextDouble() < 0.3) { // 30% de chance de evento ocorrer
            return eventosPossiveis.get(random.nextInt(eventosPossiveis.size()));
        }
        return null;
    }

    // Método para modificar o clima do ambiente
    public void modificarClima(String novoClima) {
        this.condicoesClimaticas = novoClima;
        System.out.println("O clima mudou para: " + novoClima);
    }

    // Método para adicionar um recurso ao ambiente
    public void adicionarRecurso(Item item) {
        recursosDisponiveis.add(item);
    }

    // Método para remover um recurso após coleta
    public void removerRecurso(Item item) {
        recursosDisponiveis.remove(item);
    }

    // Método para exibir detalhes do ambiente
    public void exibirInformacoes() {
        System.out.println("Ambiente: " + nome);
        System.out.println("Descrição: " + descricao);
        System.out.println("Dificuldade de Exploração: " + dificuldadeExploracao);
        System.out.println("Clima: " + condicoesClimaticas);
        System.out.println("Recursos disponíveis: " + (recursosDisponiveis.isEmpty() ? "Nenhum" : recursosDisponiveis));
        System.out.println("Possíveis Eventos: " + (eventosPossiveis.isEmpty() ? "Nenhum" : eventosPossiveis));
    }

    // Getters e Setters
    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getDificuldadeExploracao() {
        return dificuldadeExploracao;
    }

    public String getCondicoesClimaticas() {
        return condicoesClimaticas;
    }
}
