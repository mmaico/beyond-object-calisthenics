package examples.repository.infrastructure.http;

public class ValidationException extends RuntimeException {

    public ValidationException(String message) {
        super(message);
    }
}
