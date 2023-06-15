package pt.tpsi.festa.espaco.execeptions;

/**
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
public class RequestException extends RuntimeException{
    /**
     * Constructs a new instance of RequestException with the specified error message.
     *
     * @message the error message describing the exception
     */

    public RequestException( String message ) {
        super( message );
    }
}
