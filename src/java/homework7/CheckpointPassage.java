package homework7;

import homework7.atomobile.Automobile;
import homework7.exception.ExcesSpeedException;
import homework7.exception.ExcessSizeException;
import homework7.exception.ExcessWeightException;

public class CheckpointPassage implements HasTrueSpeed, HasTrueWeightSize {

    private Boolean passageAllowed;

    public CheckpointPassage(Automobile automobile) {
        boolean result;
        try {
            result = isTrueSpeed(automobile.getTravelSpeed())
                    && isTrueWeightSize(
                    automobile.getWeight()
                    , automobile.getWidth()
                    , automobile.getHeight()
                    , automobile.getLength()
            );
        } catch (ExcesSpeedException e) {
            result = false;
            if (automobile.getTravelSpeed() <= 100) {
                System.out.println("!" + e.getMessage());
            } else {
                CallPolice callPolice = new CallPolice(automobile);
            }
        } catch (ExcessWeightException | ExcessSizeException e) {
            result = false;
            System.out.println("!Невозможен проезд автомобиля с номером %s, с типом - %s, причина: %s".formatted(
                    automobile.getNumber()
                    , automobile.getType().getTypeName()
                    , e.getMessage()
            ));
        }
        this.passageAllowed = result;
    }

    @Override
    public boolean isTrueSpeed(int speed) throws ExcesSpeedException {
        if (speed > 80) {
            throw new ExcesSpeedException();
        }
        return true;
    }

    @Override
    public boolean isTrueWeightSize(int weight, float width, float height, float length) throws ExcessWeightException, ExcessSizeException {
        if (weight > 8) {
            throw new ExcessWeightException();
        }
        if (height > 4F || width > 2.5F) {
            throw new ExcessSizeException();
        }
        return true;
    }

    public boolean getPassageAllowed() {
        return passageAllowed;
    }
}
