package lesson15.unit;
import java.util.Random;
public class RandomGenerator implements Generator {
    @Override
    public String generate() throws Exception {
        return new Random(10000000).nextInt(10000000) + "";
    }
    @Override
    public void printId(String id) {
    }
}