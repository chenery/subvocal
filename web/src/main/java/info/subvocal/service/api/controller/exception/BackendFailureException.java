package info.subvocal.service.api.controller.exception;

/**
 *  We received a NotOk from the backend
 */
public class BackendFailureException extends RuntimeException {

    public BackendFailureException(String message) {
        super(message);
    }
}
