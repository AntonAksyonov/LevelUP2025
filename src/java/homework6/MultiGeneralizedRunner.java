package homework6;

public class MultiGeneralizedRunner {
    public static void main(String[] args) {
        Pet pet = new Pet("Шарик", 12, false);
        MultiGeneralized<String, Pet, Integer> multiGeneralized = new MultiGeneralized<>("Some string", pet, 2322);
        multiGeneralized.getFieldsClassName();
    }
}
