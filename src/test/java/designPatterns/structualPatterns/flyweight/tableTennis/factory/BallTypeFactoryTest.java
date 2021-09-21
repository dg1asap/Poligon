package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BallTypeFactoryTest {
    private static BallParametersFactory factory;

    @BeforeAll
    public static void createFactory() {
        factory = new BallTypeFactory();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testCreateRacketParameters(int ballQuality) {
        BallType ballType = factory.createBallType(ballQuality);
        assertEquals(ballQuality, ballType.ballQuality);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testCreateTheSameTypes(int ballQuality) {
        BallType firstBallType = factory.createBallType(ballQuality);
        BallType secondBallType = factory.createBallType(ballQuality);
        assertSame(firstBallType, secondBallType);
    }

}
