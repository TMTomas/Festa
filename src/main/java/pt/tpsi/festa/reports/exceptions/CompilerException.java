package pt.tpsi.festa.reports.exceptions;

public class CompilerException extends RuntimeException {
    /**
     * Constructs a new instance of CompilerException with the specified error message.
     *
     * @message the error message describing the exception
     */
    public CompilerException(String message) {
        super(message);
    }
}
