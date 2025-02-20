package lesson15.unit;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
@RequiredArgsConstructor
public class CardService {
    private final Generator generator;
    @SneakyThrows
    public void printId(String id) {
        generator.printId(id);
//        String result = generator.generate();
//        System.out.println(generator.generate());
    }
    @SneakyThrows
    public String generateId(String type) {
        return switch (type) {
            case "id" -> new IdGenerator().generate();
            default -> generator.generate();
        };
    }
}