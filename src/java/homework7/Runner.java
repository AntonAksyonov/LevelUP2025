package homework7;

import homework7.atomobile.Automobile;
import homework7.atomobile.Car;
import homework7.atomobile.Truck;

public class Runner {
    public static void main(String[] args) {
        Automobile[] automobiles = fill();

        for (Automobile automobile : automobiles) {
            CheckpointPassage checkpointPassage = new CheckpointPassage(automobile);
            System.out.println("    Шлагбаум " + (checkpointPassage.getPassageAllowed() == true ? "" : "не ")
                    + "открыт для: " + automobile.toString());
        }
    }

    private static Automobile[] fill() {
        String number;
        int travelSpeed;
        int weight;
        float width;
        float height;
        float length;
        Automobile[] automobiles = new Automobile[30];
        for (int index = 0; index < automobiles.length; index++) {
            Automobile automobile;

            if (((int) (Math.random() * 1000)) % 2 == 0) {
                number = String.valueOf((int) (Math.random() * 10000)) + String.valueOf(index);
                travelSpeed = (int) (Math.random() * 80) + 40;
                weight = (int) (Math.random() * 2) + 1;
                width = (float) Math.random() + 2F;
                height = (float) (Math.random() * 2) + 1F;
                length = (float) (Math.random() * 4) + 3F;

                automobile = new Car(number, travelSpeed, weight, width, height, length);
            } else {
                number = String.valueOf((int) (Math.random() * 10000)) + String.valueOf(index);
                travelSpeed = (int) (Math.random() * 45) + 40;
                weight = (int) (Math.random() * 6) + 3;
                width = (float) (Math.random()) + 2F;
                height = (float) (Math.random() * 3) + 2F;
                length = (float) (Math.random() * 5) + 5F;

                automobile = new Truck(number, travelSpeed, weight, width, height, length);
            }
            automobiles[index] = automobile;
        }

        return automobiles;
    }
}
