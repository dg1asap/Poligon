package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import designPatterns.structualPatterns.flyweight.tableTennis.products.Racket;
import designPatterns.structualPatterns.flyweight.tableTennis.products.RacketType;

public class RacketFactory extends TableTennisFactory {
    private RacketTypeFactory racketTypeFactory;

    public RacketFactory(int startingID) {
        super(startingID);
        racketTypeFactory = new RacketTypeFactory();
    }

    public Racket createRacketWithSpeedSpinAndControl(int speed, int spin, int control) {
        RacketType type = racketTypeFactory.createRacketTypeWithSpeedSpinAndControl(speed, spin, control);
        return new Racket(counterID++, type);
    }
}
