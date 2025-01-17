package homework7.exception;

public class ExcessSizeException extends RuntimeException {
    public ExcessSizeException() {
        super("Превышение габаритов!");
    }
}
