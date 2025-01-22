package homework7.atomobile;

public class Automobile {

    private TypeAutomobile type;
    private String number;
    private int travelSpeed;
    private int weight;
    private float width;
    private float height;
    private float length;

    public Automobile(TypeAutomobile type, String number, int travelSpeed, int weight, float width, float height, float length) {
        this.type = type;
        this.number = number;
        this.travelSpeed = travelSpeed;
        this.weight = weight;
        this.width = width;
        this.height = height;
        this.length = length;
    }

    public TypeAutomobile getType() {
        return type;
    }

    public String getNumber() {
        return number;
    }

    public int getTravelSpeed() {
        return travelSpeed;
    }

    public float getWidth() {
        return width;
    }

    public int getWeight() {
        return weight;
    }

    public float getHeight() {
        return height;
    }

    public float getLength() {
        return length;
    }

    @Override
    public String toString() {
        return "Automobile{" +
                "type=" + type.getTypeName() +
                ", number='" + number + '\'' +
                ", travelSpeed=" + travelSpeed +
                ", weight=" + weight +
                ", width=" + width +
                ", height=" + height +
                ", length=" + length +
                '}';
    }
}
