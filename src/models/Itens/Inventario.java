package models.Itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import models.exceptions.InventarioCheioException;

/**
 * Representa o inventário de um personagem, contendo itens com peso limitado.
 */
public class Inventario {

    private List<Item> listaItens;
    private double pesoTotal;
    private double capacidadeMaxima;

    /**
     * Construtor do inventário.
     *
     * @param capacidadeMaxima Capacidade total de peso permitida.
     */
    public Inventario(double capacidadeMaxima) {
        this.listaItens = new ArrayList<>();
        this.pesoTotal = 0;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    // Getters e Setters
    public List<Item> getListaItens() { return listaItens; }
    public void setListaItens(List<Item> listaItens) { this.listaItens = listaItens; }

    public double getPesoTotal() { return pesoTotal; }
    public void setPesoTotal(double pesoTotal) { this.pesoTotal = pesoTotal; }

    public double getCapacidadeMaxima() { return capacidadeMaxima; }
    public void setCapacidadeMaxima(double capacidadeMaxima) { this.capacidadeMaxima = capacidadeMaxima; }

    /**
     * Adiciona um item ao inventário se houver espaço.
     * Lança uma exceção se o inventário estiver cheio.
     */
    public void adicionarItem(Item item) throws InventarioCheioException {
        if (pesoTotal + item.getPeso() <= capacidadeMaxima) {
            listaItens.add(item);
            pesoTotal += item.getPeso();
            Collections.sort(listaItens); // Ordena automaticamente após adicionar
            System.out.println(item.getNome() + " adicionado ao inventário.");
        } else {
            throw new InventarioCheioException("Não há espaço suficiente para " + item.getNome() + " no inventário.");
        }
    }

    /**
     * Remove um item do inventário pelo nome.
     */
    public void removerItem(String nomeItem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                listaItens.remove(item);
                pesoTotal -= item.getPeso();
                System.out.println(nomeItem + " removido do inventário.");
                return;
            }
        }
        System.out.println("Item não encontrado no inventário.");
    }

    /**
     * Usa um item pelo nome, aplicando seu efeito e removendo se quebrar.
     */
    public void usarItem(String nomeItem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                item.usar();
                if (item.getDurabilidade() == 0) {
                    listaItens.remove(item);
                    pesoTotal -= item.getPeso();
                    System.out.println(nomeItem + " quebrou e foi removido do inventário.");
                }
                return;
            }
        }
        System.out.println("Item não encontrado para uso.");
    }

    /**
     * Exibe todos os itens do inventário.
     */
    public void exibirInventario() {
        System.out.println("Inventário: ");
        if (listaItens.isEmpty()) {
            System.out.println("Vazio.");
        } else {
            for (Item item : listaItens) {
                System.out.println("- " + item.getNome() + " (Peso: " + item.getPeso() + ", Durabilidade: " + item.getDurabilidade() + ")");
            }
        }
    }

    /**
     * Verifica quanto espaço ainda resta no inventário.
     */
    public void verificarEspaco() {
        double espacoRestante = capacidadeMaxima - pesoTotal;
        if (espacoRestante > 0) {
            System.out.println("Há " + espacoRestante + " de espaço restante no inventário.");
        } else {
            System.out.println("O inventário está cheio.");
        }
    }

    /**
     * Verifica se um item com determinado nome está presente.
     */
    public boolean verificarItem(String nomeItem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }
}