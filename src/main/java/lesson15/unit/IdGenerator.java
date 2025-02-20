package lesson15.unit;
import java.util.UUID;
public class IdGenerator implements Generator {
    public String generate() throws Exception {
//        throw new Exception("Test");
        Thread.sleep(100);
        return UUID.randomUUID().toString();
    }
    @Override
    public void printId(String id) {
    }
}