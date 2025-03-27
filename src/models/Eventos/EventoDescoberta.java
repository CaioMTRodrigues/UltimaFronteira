package models.Eventos;

import java.util.List;
import models.Itens.Item;

public class EventoDescoberta extends Evento {

    private String tipoDescoberta;
    private List<Item> recursosEncontrados;
    private String condicaoEspecial;

    // Construtor que inicializa os dados específicos da descoberta
    public EventoDescoberta(String nome, String descricao, double probabilidade, String impacto, String tipoDescoberta, List<Item> recursosEncontrados, String condicaoEspecial) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoDescoberta = tipoDescoberta;
        this.recursosEncontrados = recursosEncontrados;
        this.condicaoEspecial = condicaoEspecial;
    }

    // Métodos de Acesso
    public String getTipoDescoberta() { return tipoDescoberta; }
    public void setTipoDescoberta(String tipoDescoberta) { this.tipoDescoberta = tipoDescoberta; }
    public List<Item> getRecursosEncontrados() { return recursosEncontrados; }
    public void setRecursosEncontrados(List<Item> recursosEncontrados) { this.recursosEncontrados = recursosEncontrados; }
    public String getCondicaoEspecial() { return condicaoEspecial; }
    public void setCondicaoEspecial(String condicaoEspecial) { this.condicaoEspecial = condicaoEspecial; }

    // Método sobrescrito para executar o evento de descoberta
    @Override
    public void executar() {
        System.out.println("🔍 Descoberta: " + getTipoDescoberta());
        System.out.println("Descrição: " + getDescricao());
        System.out.println("Recursos encontrados:");
        for (Item item : getRecursosEncontrados()) {
            System.out.println("- " + item.getNome());
        }
        System.out.println("Condição Especial: " + getCondicaoEspecial());
    }
}


