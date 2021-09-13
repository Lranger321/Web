package main.exception;

public class ApplianceNotFoundException extends RuntimeException {
    public ApplianceNotFoundException(String format, String message) {
        super(message);
    }
}
