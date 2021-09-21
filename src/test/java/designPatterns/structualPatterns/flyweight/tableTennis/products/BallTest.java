package designPatterns.structualPatterns.flyweight.tableTennis.products;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BallTest {
    private static Ball firstBall;
    private static Ball secondBall;

    @BeforeAll
    public static void createBalls() {
        firstBall = createBallWithIDAndQuality(42000001, 3);
        secondBall = createBallWithIDAndQuality(48050005, 3);
    }

    private static void createBallWithIDAndQuality(int ID, int quality) {
        BallType ballType = new BallType(quality);
        return new Ball(ID, ballType);
    }

    @Test
    public void testBallID(){
        assertEquals(42000001, firstBall.ID);
        assertEquals(48050005, secondBall.ID);
    }

}
