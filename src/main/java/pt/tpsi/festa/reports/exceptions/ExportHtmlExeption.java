package pt.tpsi.festa.reports.exceptions;
/**
 * @author Daniel Duarte (Obrigado por toda a ajuda e disponibilidade)
 * @version 1.0
 */
public class ExportHtmlExeption extends RuntimeException {
    /**
     * Constructs a new instance of ExportHtmlExeption with the specified error message.
     *
     * @message the error message describing the exception
     */
    public ExportHtmlExeption(String message) {
        super(message);
    }
}
