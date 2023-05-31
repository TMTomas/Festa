package pt.tpsi.festa.reports.exceptions;

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
