package models.Eventos;

import models.Itens.Item;
import java.util.List;

public class EventoDescoberta extends Evento {
    
    private String tipoDescoberta; // Exemplo: Caverna, abrigo, suprimentos abandonados, etc.
    private List<Item> recursosEncontrados; // Pode incluir comida, água, ferramentas ou armas
    private String condicaoEspecial; // Algumas descobertas podem exigir habilidades específicas para serem exploradas

}
