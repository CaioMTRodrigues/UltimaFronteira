package models.Eventos;

import java.util.List;

import models.Itens.Item;

public class EventoDescoberta extends Evento {
    private String tipoDescoberta;      // Tipo da descoberta (ex: "abrigo", "suprimentos abandonados")
    private List<Item> recursosEncontrados; // Lista de recursos encontrados na descoberta
    private String condicaoEspecial;   // Condição especial para a descoberta (ex: "precisa de ferramenta para ser acessado")

    // Construtor
    public EventoDescoberta(String nome, String descricao, double probabilidade, String impacto, String tipoDescoberta, List<Item> recursosEncontrados, String condicaoEspecial) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoDescoberta = tipoDescoberta;
        this.recursosEncontrados = recursosEncontrados;
        this.condicaoEspecial = condicaoEspecial;
    }

    // Métodos de Acesso (Getters e Setters)
    public String getTipoDescoberta() {
        return tipoDescoberta;
    }

    public void setTipoDescoberta(String tipoDescoberta) {
        this.tipoDescoberta = tipoDescoberta;
    }

    public List<Item> getRecursosEncontrados() {
        return recursosEncontrados;
    }

    public void setRecursosEncontrados(List<Item> recursosEncontrados) {
        this.recursosEncontrados = recursosEncontrados;
    }

    public String getCondicaoEspecial() {
        return condicaoEspecial;
    }

    public void setCondicaoEspecial(String condicaoEspecial) {
        this.condicaoEspecial = condicaoEspecial;
    }

    // Método sobrescrito de executar
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

