package pt.tpsi.festa.espaco.execeptions;

/**
 * @author Daniel Duarte AND Pedro Pacheco
 * @version 1.0
 */
public class LocationListException extends RuntimeException{
    /**
     * Constructs a new instance of LocationListException with the specified error message.
     *
     * @message the error message describing the exception
     */
    public LocationListException(String message) {
        super(message);
    }
}
