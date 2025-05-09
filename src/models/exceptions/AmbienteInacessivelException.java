package models.exceptions;

/**
 
Exceção lançada quando o ambiente não pode ser acessado.*/
public class AmbienteInacessivelException extends Exception {

    public AmbienteInacessivelException(String mensagem) {
        super(mensagem);
    }
}