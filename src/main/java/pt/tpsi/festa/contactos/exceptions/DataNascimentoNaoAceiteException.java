package pt.tpsi.festa.contactos.exceptions;

public class DataNascimentoNaoAceiteException extends Exception{

	public DataNascimentoNaoAceiteException(String message) {
        super(message);
    }

    public DataNascimentoNaoAceiteException(String message, Throwable cause) {
        super(message, cause);
    }
}
