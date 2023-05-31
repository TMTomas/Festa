package pt.tpsi.festa.reports.exceptions;

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
