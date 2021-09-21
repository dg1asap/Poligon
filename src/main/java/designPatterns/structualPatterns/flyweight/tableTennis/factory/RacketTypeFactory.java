package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import designPatterns.structualPatterns.flyweight.tableTennis.products.RacketType;

import java.util.HashSet;
import java.util.Set;

public class RacketTypeFactory {
    Set<RacketType> racketTypes = new HashSet<>();

    public RacketType createRacketTypeWithSpeedSpinAndControl(int speed, int spin, int control) {
        if (hasBallTypeWithSpeedSpinAndControl(speed, spin, control))
            return getBallTypeWithSpeedSpinAndControl(speed, spin, control);
        return getNewBallTypeWithSpeedSpinAndControl(speed, spin, control);
    }

    public boolean hasBallTypeWithSpeedSpinAndControl(int speed, int spin, int control) {
        for (RacketType racketType : racketTypes)
            if (racketType.hasSpeedSpinAndControl(speed, spin, control))
                return true;
        return false;
    }

    public RacketType getBallTypeWithSpeedSpinAndControl(int speed, int spin, int control) {
        for (RacketType racketType : racketTypes)
            if (racketType.hasSpeedSpinAndControl(speed, spin, control))
                return racketType;
        return null;
    }

    public RacketType getNewBallTypeWithSpeedSpinAndControl(int speed, int spin, int control) {
        RacketType newRacketType = new RacketType(speed, spin, control);
        racketTypes.add(newRacketType);
        return newRacketType;
    }

}
