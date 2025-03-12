package models.Ambientes;

import models.Eventos.Evento;
import models.Itens.Item;
import java.util.List;

public class Ambiente {
    
    protected String nome;
    protected String descricao;
    protected double dificuldadeExploracao;
    protected List<Item> recursosDisponiveis;
    protected List<Evento> eventosPossiveis;
    protected String condicoesClimaticas;

}