package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import designPatterns.structualPatterns.flyweight.tableTennis.products.Ball;
import designPatterns.structualPatterns.flyweight.tableTennis.products.BallType;

public class BallFactory extends TableTennisFactory {
    BallTypeFactory ballTypeFactory;

    public BallFactory(int startingID) {
        super(startingID);
        ballTypeFactory = new BallTypeFactory();
    }

    public Ball createBallWithQuality(int quality) {
        BallType type = ballTypeFactory.createBallTypeWithQuality(quality);
        return new Ball(counterID++, type);
    }

}
