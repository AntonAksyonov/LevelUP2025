package homework5.automobile;

public final class Car extends Automobile {

    @Override
    public boolean move(int distance) {
        if (distance <= 500) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return "Легковой автомобиль";
    }
}
