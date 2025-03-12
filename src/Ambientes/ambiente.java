package Ambientes;

import Eventos.Evento;
import Itens.Item;
import java.util.List;

public class Ambiente {
    
    protected String nome;
    protected String descricao;
    protected double dificuldadeExploracao;
    protected List<Item> recursosDisponiveis;
    protected List<Evento> eventosPossiveis;
    protected String condicoesClimaticas;

}