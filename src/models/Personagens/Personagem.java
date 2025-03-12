package models.Personagens;

import java.util.List;
import java.util.ArrayList;
import models.Itens.Item;
import models.Ambientes.Ambiente;

public class Personagem {
    private String nome; 
    private int vida; 
    private int fome; 
    private int sede; 
    private int energia; 
    private int sanidade; 
    private List<Item> inventario; 
    private Ambiente localizacao; 

}