package lesson5.car;

public class Car {
    private String mark;
    private String model;
    private Engine engine;

    public Car(String mark, String model) {
        this.mark = mark;
        this.model = model;
    }

    public Car(String mark, String model, double volume) {
        this.mark = mark;
        this.model = model;
        this.engine = new Engine(volume);
    }

    public void setEngine(Engine engine) {
        this.engine = engine;
    }

    public static class Engine {
        private double volume;

        public Engine(double volume) {
            this.volume = volume;
        }
    }
}
