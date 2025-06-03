package models.Itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import models.Personagens.Personagem;
import models.exceptions.InventarioCheioException;

/**
 * Representa o inventário de um personagem, contendo itens com peso limitado.
 * O inventário controla a adição e remoção de itens, além de verificar espaço e capacidade.
 */
public class Inventario {

    private List<Item> listaItens;
    private double pesoTotal;
    private double capacidadeMaxima;

    /**
     * Construtor do inventário.
     * 
     * @param capacidadeMaxima Capacidade total de peso permitida para o inventário.
     */
    public Inventario(double capacidadeMaxima) {
        this.listaItens = new ArrayList<>();
        this.pesoTotal = 0;
        this.capacidadeMaxima = capacidadeMaxima;
    }

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

    public void adicionarItem(Item item) throws InventarioCheioException {
        if (pesoTotal + item.getPeso() <= capacidadeMaxima) {
            listaItens.add(item);
            pesoTotal += item.getPeso();
            Collections.sort(listaItens);
            System.out.println(item.getNome() + " adicionado ao inventário.");
        } else {
            throw new InventarioCheioException("Não há espaço suficiente para " + item.getNome() + " no inventário.");
        }
    }

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
     * Usa um item do inventário e aplica efeitos ao personagem.
     * 
     * @param nomeItem Nome do item.
     * @param personagem O personagem que utilizará o item.
     */
    public void usarItem(String nomeItem, Personagem personagem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                item.usar(personagem);
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

    public void verificarEspaco() {
        double espacoRestante = capacidadeMaxima - pesoTotal;
        if (espacoRestante > 0) {
            System.out.println("Há " + espacoRestante + " de espaço restante no inventário.");
        } else {
            System.out.println("O inventário está cheio.");
        }
    }

    public boolean verificarItem(String nomeItem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    public boolean craft(String nomeNovoItem, List<String> nomesMateriais) throws InventarioCheioException {
        List<Item> materiaisParaRemover = new ArrayList<>();

        for (String nomeMaterial : nomesMateriais) {
            boolean achou = false;
            for (Item item : listaItens) {
                if (item.getNome().equalsIgnoreCase(nomeMaterial) && !materiaisParaRemover.contains(item)) {
                    materiaisParaRemover.add(item);
                    achou = true;
                    break;
                }
            }
            if (!achou) {
                System.out.println("Material faltando: " + nomeMaterial);
                return false;
            }
        }

        for (Item item : materiaisParaRemover) {
            listaItens.remove(item);
            pesoTotal -= item.getPeso();
            System.out.println("Material removido: " + item.getNome());
        }

        Item novoItem = FabricaDeItens.criarItem(nomeNovoItem);
        if (novoItem == null) {
            System.out.println("Falha ao criar o item: " + nomeNovoItem);
            return false;
        }

        adicionarItem(novoItem);
        System.out.println("Item criado e adicionado: " + novoItem.getNome());
        return true;
    }

    public boolean podeConstruirAbrigo() {
        int madeiraCount = 0;
        int pedraCount = 0;

        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase("Madeira")) {
                madeiraCount++;
            } else if (item.getNome().equalsIgnoreCase("Pedra")) {
                pedraCount++;
            }
        }

        return madeiraCount >= 5 && pedraCount >= 3;
    }

    public void usarMateriaisParaAbrigo() {
        int madeiraRemovida = 0;
        int pedraRemovida = 0;

        List<Item> itensParaRemover = new ArrayList<>();

        for (Item item : listaItens) {
            if (madeiraRemovida < 5 && item.getNome().equalsIgnoreCase("Madeira")) {
                itensParaRemover.add(item);
                madeiraRemovida++;
            } else if (pedraRemovida < 3 && item.getNome().equalsIgnoreCase("Pedra")) {
                itensParaRemover.add(item);
                pedraRemovida++;
            }
            if (madeiraRemovida >= 5 && pedraRemovida >= 3) {
                break;
            }
        }

        for (Item item : itensParaRemover) {
            listaItens.remove(item);
            pesoTotal -= item.getPeso();
            System.out.println("Material removido para construção do abrigo: " + item.getNome());
        }
    }
}
