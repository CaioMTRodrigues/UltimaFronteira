package models.Eventos;

import java.util.List;

import models.Itens.Item;

public class EventoDescoberta extends Evento {
    private String tipoDescoberta;
    private List<Item> recursosEncontrados;
    private String condicaoEspecial;

    public EventoDescoberta(String nome, String descricao, double probabilidade, String impacto, String tipoDescoberta, List<Item> recursosEncontrados, String condicaoEspecial) {
        super(nome, descricao, probabilidade, impacto);
        this.tipoDescoberta = tipoDescoberta;
        this.recursosEncontrados = recursosEncontrados;
        this.condicaoEspecial = condicaoEspecial;
    }

    @Override
    public void executar() {
        System.out.println("🔍 Descoberta: " + tipoDescoberta);
        System.out.println("Descrição: " + descricao);
        System.out.println("Recursos encontrados:");
        for (Item item : recursosEncontrados) {
            System.out.println("- " + item.getNome());
        }
        System.out.println("Condição Especial: " + condicaoEspecial);
    }
}
