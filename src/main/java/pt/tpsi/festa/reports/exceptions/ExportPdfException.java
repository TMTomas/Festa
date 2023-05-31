package pt.tpsi.festa.reports.exceptions;
/**
 * @author Daniel Duarte (Obrigado por toda a ajuda e disponibilidade)
 * @version 1.0
 */
public class ExportPdfException extends RuntimeException{
    /**
     * Constructs a new instance of ExportPdfException with the specified error message.
     *
     * @message the error message describing the exception
     */
    public ExportPdfException(String message) {
        super(message);
    }
}
