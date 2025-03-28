package models.Itens;

import java.util.ArrayList;
import java.util.List;

public class Inventario {

    private List<Item> listaItens; // Lista de itens no inventário
    private double pesoTotal; // Peso total dos itens no inventário
    private double capacidadeMaxima; // Capacidade máxima do inventário

    // Construtor que inicializa o inventário com capacidade máxima
    public Inventario(double capacidadeMaxima) {
        this.listaItens = new ArrayList<>();
        this.pesoTotal = 0;
        this.capacidadeMaxima = capacidadeMaxima;
    }

    // Métodos de Acesso (Getters e Setters)
    public List<Item> getListaItens() {
        return listaItens;
    }

    public void setListaItens(List<Item> listaItens) {
        this.listaItens = listaItens;
    }

    public double getPesoTotal() {
        return pesoTotal;
    }

    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    public void setCapacidadeMaxima(double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    // Método para adicionar um item ao inventário
    public void adicionarItem(Item item) {
        if (pesoTotal + item.getPeso() <= capacidadeMaxima) {
            listaItens.add(item);
            pesoTotal += item.getPeso();
            System.out.println("✅ " + item.getNome() + " adicionado ao inventário.");
        } else {
            System.out.println("❌ Não há espaço suficiente para " + item.getNome() + " no inventário.");
        }
    }

    // Método para remover um item do inventário
    public void removerItem(String nomeItem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                listaItens.remove(item);
                pesoTotal -= item.getPeso();
                System.out.println("❌ " + nomeItem + " removido do inventário.");
                return;
            }
        }
        System.out.println("⚠ Item não encontrado no inventário.");
    }

    // Método para usar um item do inventário
    public void usarItem(String nomeItem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                item.usar();  // Chama o método sobrescrito de uso específico do item
                if (item.getDurabilidade() == 0) {
                    listaItens.remove(item);
                    pesoTotal -= item.getPeso();
                    System.out.println("❌ " + nomeItem + " quebrou e foi removido do inventário.");
                }
                return;
            }
        }
        System.out.println("⚠ Item não encontrado para uso.");
    }

    // Método para exibir todos os itens no inventário
    public void exibirInventario() {
        System.out.println("🎒 Inventário: ");
        if (listaItens.isEmpty()) {
            System.out.println("Vazio.");
        } else {
            for (Item item : listaItens) {
                System.out.println("- " + item.getNome() + " (Peso: " + item.getPeso() + ", Durabilidade: " + item.getDurabilidade() + ")");
            }
        }
    }

    // Método para verificar a capacidade restante no inventário
    public void verificarEspaco() {
        double espacoRestante = capacidadeMaxima - pesoTotal;
        if (espacoRestante > 0) {
            System.out.println("Há " + espacoRestante + " de espaço restante no inventário.");
        } else {
            System.out.println("O inventário está cheio.");
        }
    }

    // Método para verificar se um item específico está no inventário
    public boolean verificarItem(String nomeItem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }
}
