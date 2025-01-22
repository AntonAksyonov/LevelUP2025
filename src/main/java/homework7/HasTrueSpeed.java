package homework7;

import homework7.exception.ExcesSpeedException;

public interface HasTrueSpeed {
    boolean isTrueSpeed(int speed) throws ExcesSpeedException;
}
