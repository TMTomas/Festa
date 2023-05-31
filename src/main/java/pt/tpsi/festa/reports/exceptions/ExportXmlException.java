package pt.tpsi.festa.reports.exceptions;

public class ExportXmlException extends RuntimeException{
    /**
     * Constructs a new instance of ExportXmlException with the specified error message.
     *
     * @message the error message describing the exception
     */
    public ExportXmlException(String message) {
        super(message);
    }
}
