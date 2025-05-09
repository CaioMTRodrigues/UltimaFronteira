package models.exceptions;

/**
 
Exceção lançada quando o inventário está cheio e não pode adicionar mais itens.*/
public class InventarioCheioException extends Exception {

    public InventarioCheioException(String mensagem) {
        super(mensagem);
    }
}