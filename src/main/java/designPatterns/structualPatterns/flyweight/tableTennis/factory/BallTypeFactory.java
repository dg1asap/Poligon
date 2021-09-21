package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import designPatterns.structualPatterns.flyweight.tableTennis.products.BallType;

import java.util.HashSet;
import java.util.Set;

public class BallTypeFactory {
    Set<BallType> ballTypes = new HashSet<>();

    public BallType createBallTypeWithQuality(int ballQuality) {
        if (hasBallTypeWithQuality(ballQuality))
            return getBallTypeWithQuality(ballQuality);
        return getNewBallTypeWithQuality(ballQuality);
    }

    public boolean hasBallTypeWithQuality(int ballQuality) {
        for (BallType ballType : ballTypes)
            if (ballType.hasQuality(ballQuality))
                return true;
        return false;
    }

    public BallType getBallTypeWithQuality(int ballQuality) {
        for (BallType ballType : ballTypes)
            if (ballType.hasQuality(ballQuality))
                return ballType;
            return null;
    }

    public BallType getNewBallTypeWithQuality(int ballQuality) {
        BallType newBallType = new BallType(ballQuality);
        ballTypes.add(newBallType);
        return newBallType;
    }

}
