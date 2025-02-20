package lesson14.tdd;

public class TaxService {
    public int calculateValue(int value) {
        return value <= 1_000_000 ? 13 : (value <= 5_000_000 ? 15 : 18);
    }
}