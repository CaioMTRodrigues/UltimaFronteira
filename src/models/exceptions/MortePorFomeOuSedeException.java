package models.exceptions;

/**
 
Exceção lançada quando o jogador morre devido à falta de comida ou água.*/
public class MortePorFomeOuSedeException extends Exception {

    public MortePorFomeOuSedeException(String mensagem) {
        super(mensagem);
    }
}
