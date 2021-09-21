package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import designPatterns.structualPatterns.flyweight.tableTennis.products.Ball;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class BallFactoryTest {
    private static BallFactory factory;

    @BeforeAll
    public static void createFactory() {
        factory = new BallFactory(78000000);
    }

    @ParameterizedTest
    @MethodSource("ballQualityAndID")
    public void testCreateBalls(int ballQuality, int ID) {
        Ball ball = factory.createBallWithQuality(ballQuality);
        assertEquals(ID, ball.getID());
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    public void testCreateBallsWithTheSameType(int ballQuality) {
        Ball firstBall = factory.createBallWithQuality(ballQuality);
        Ball secondBall = factory.createBallWithQuality(ballQuality);
        assertTrue(firstBall.isSameType(secondBall));
    }

    private static Stream <Arguments> ballQualityAndID() {
        return Stream.of(
                Arguments.of(1, 78000000),
                Arguments.of(1, 78000001),
                Arguments.of(2, 78000002),
                Arguments.of(3, 78000003),
                Arguments.of(1, 78000004),
                Arguments.of(2, 78000005),
                Arguments.of(2, 78000006),
                Arguments.of(3, 78000007),
                Arguments.of(1, 78000008),
                Arguments.of(3, 78000009),
                Arguments.of(3, 78000010)
        );
    }

}
