package pt.tpsi.festa.execeptions;

public class RequestException extends RuntimeException{
    public RequestException( String message ) {
        super( message );
    }
}
