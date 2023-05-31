package pt.tpsi.festa.espaco.execeptions;

/**
 * Uma exceção personalizada que representa um erro durante uma requisição.
 * Essa exceção é uma subclasse de RuntimeException.
 */

public class RequestException extends RuntimeException{
    

    /**
     * Constrói uma nova instância de RequestException com a mensagem de erro especificada.
     *
     * @message a mensagem de erro que descreve a exceção
     */
	
	public RequestException( String message ) {
        super( message );
    }
}
