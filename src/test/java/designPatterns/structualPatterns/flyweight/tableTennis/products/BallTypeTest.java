package designPatterns.structualPatterns.flyweight.tableTennis.products;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTypeTest {
    private static BallType firstBallType;
    private static BallType secondBallType;

    @BeforeAll
    public static void createBallTypes() {
        firstBallType = new BallType(2);
        secondBallType = new BallType(10);
    }

    @Test
    public void testBallTypeQuality() {
        assertEquals(2, firstBallType.quality);
        assertEquals(10, firstBallType.quality);
    }

}
