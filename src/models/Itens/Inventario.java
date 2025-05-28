package models.Itens;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
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

    /**
     * Retorna a lista de itens presentes no inventário.
     * 
     * @return A lista de itens do inventário.
     */
    public List<Item> getListaItens() {
        return listaItens;
    }

    /**
     * Define a lista de itens do inventário.
     * 
     * @param listaItens A lista de itens a ser atribuída ao inventário.
     */
    public void setListaItens(List<Item> listaItens) {
        this.listaItens = listaItens;
    }

    /**
     * Retorna o peso total atual dos itens no inventário.
     * 
     * @return O peso total dos itens no inventário.
     */
    public double getPesoTotal() {
        return pesoTotal;
    }

    /**
     * Define o peso total dos itens no inventário.
     * 
     * @param pesoTotal O peso total a ser atribuído.
     */
    public void setPesoTotal(double pesoTotal) {
        this.pesoTotal = pesoTotal;
    }

    /**
     * Retorna a capacidade máxima permitida para o inventário.
     * 
     * @return A capacidade máxima do inventário.
     */
    public double getCapacidadeMaxima() {
        return capacidadeMaxima;
    }

    /**
     * Define a capacidade máxima do inventário.
     * 
     * @param capacidadeMaxima A capacidade máxima a ser atribuída.
     */
    public void setCapacidadeMaxima(double capacidadeMaxima) {
        this.capacidadeMaxima = capacidadeMaxima;
    }

    /**
     * Adiciona um item ao inventário se houver espaço disponível.
     * Lança uma exceção caso o inventário esteja cheio.
     * 
     * @param item O item a ser adicionado ao inventário.
     * @throws InventarioCheioException Se não houver espaço suficiente no inventário.
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
     * 
     * @param nomeItem Nome do item a ser removido.
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
     * Usa um item do inventário, aplicando seu efeito e removendo-o se sua durabilidade chegar a zero.
     * 
     * @param nomeItem Nome do item a ser usado.
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
     * Exibe todos os itens presentes no inventário.
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
     * Verifica se um item específico está presente no inventário.
     * 
     * @param nomeItem Nome do item a ser verificado.
     * @return true se o item estiver presente, caso contrário false.
     */
    public boolean verificarItem(String nomeItem) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nomeItem)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Tenta criar um novo item a partir dos materiais necessários.
     * Remove os materiais do inventário se existirem, cria e adiciona o novo item.
     * 
     * @param nomeNovoItem Nome do item a ser criado.
     * @param nomesMateriais Lista de nomes dos materiais necessários para a criação.
     * @return true se o item foi criado com sucesso, false caso contrário.
     * @throws InventarioCheioException Se não houver espaço para o novo item.
     */
    public boolean craft(String nomeNovoItem, List<String> nomesMateriais) throws InventarioCheioException {
        List<Item> materiaisParaRemover = new ArrayList<>();

        // Verifica se todos os materiais necessários existem no inventário
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

        // Remove os materiais do inventário
        for (Item item : materiaisParaRemover) {
            listaItens.remove(item);
            pesoTotal -= item.getPeso();
            System.out.println("Material removido: " + item.getNome());
        }

        // Cria o novo item
        Item novoItem = FabricaDeItens.criarItem(nomeNovoItem);
        if (novoItem == null) {
            System.out.println("Falha ao criar o item: " + nomeNovoItem);
            return false;
        }

        // Tenta adicionar o novo item ao inventário
        adicionarItem(novoItem);
        System.out.println("Item criado e adicionado: " + novoItem.getNome());

        return true;
    }

    /**
     * Verifica se o jogador possui os materiais necessários para construir um abrigo permanente.
     * Exemplo: 5 Madeiras e 3 Pedras são necessários.
     * 
     * @return true se o jogador possui todos os materiais necessários, false caso contrário.
     */
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

    /**
     * Remove os materiais necessários para construir um abrigo permanente (5 Madeiras e 3 Pedras).
     */
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
