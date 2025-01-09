package homework5.automobile;

public final class Truck extends Automobile {

    @Override
    public boolean move(int distance) {
        if (distance <= 1200) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Грузовик";
    }
}
