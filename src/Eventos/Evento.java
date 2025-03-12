package Eventos;
public class Evento {
    
    protected String nome; // Identificação do evento
    protected String descricao; // Texto explicativo sobre o evento
    protected double probabilidadeOcorrencia; // Chance de o evento acontecer a cada turno
    protected String impacto; // Indica quais aspectos do jogo serão alterados (vida, fome, sede, etc.)
    protected boolean condicaoAtivacao; // Determina se o evento pode ocorrer (ex.: apenas em determinados ambientes)

}
