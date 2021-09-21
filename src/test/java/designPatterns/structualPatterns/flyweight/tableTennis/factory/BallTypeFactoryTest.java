package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import designPatterns.structualPatterns.flyweight.tableTennis.products.BallType;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class BallTypeFactoryTest {
    private static BallTypeFactory factory;

    @BeforeAll
    public static void createFactory() {
        factory = new BallTypeFactory();
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testCreateRacketParameters(int ballQuality) {
        BallType ballType = factory.createBallTypeWithQuality(ballQuality);
        assertTrue(ballType.hasQuality(ballQuality));
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testCreateTheSameTypes(int ballQuality) {
        BallType firstBallType = factory.createBallTypeWithQuality(ballQuality);
        BallType secondBallType = factory.createBallTypeWithQuality(ballQuality);
        assertSame(firstBallType, secondBallType);
    }

}
