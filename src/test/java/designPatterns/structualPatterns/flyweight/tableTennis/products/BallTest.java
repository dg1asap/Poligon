package designPatterns.structualPatterns.flyweight.tableTennis.products;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BallTest {
    private static Ball firstBall;
    private static Ball secondBall;
    private static Ball thirdBall;

    @BeforeAll
    public static void createBalls() {
        createFirstBallWithQuality(3);
        createSecondAndThirdBallWithSameQuality(2);
    }

    private static void createFirstBallWithQuality(int quality) {
        BallType type = new BallType(quality);
        firstBall = new Ball(42000001, type);
    }

    private static void createSecondAndThirdBallWithSameQuality(int quality) {
        BallType type = new BallType(quality);
        secondBall = new Ball(48050005, type);
        thirdBall = new Ball(523400001, type);
    }

    @Test
    public void testBallID(){
        assertEquals(42000001, firstBall.getID());
        assertEquals(48050005, secondBall.getID());
        assertEquals(523400001, thirdBall.getID());
    }

    @Test
    public void testIsSameType() {
        assertFalse(firstBall.isSameType(secondBall));
        assertTrue(secondBall.isSameType(thirdBall));
    }

}
