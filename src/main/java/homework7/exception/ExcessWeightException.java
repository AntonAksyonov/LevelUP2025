package homework7.exception;

public class ExcessWeightException extends RuntimeException {
    public ExcessWeightException() {
        super("Превышение массы!");
    }
}
