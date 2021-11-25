package main.exception;

public class ApplianceNotFoundException extends RuntimeException {
    public ApplianceNotFoundException(String message) {
        super(message);
    }
}
