package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import designPatterns.structualPatterns.flyweight.tableTennis.products.Racket;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RacketFactoryTest {
    private static RacketFactory factory;

    @BeforeAll
    public static void createFactory() {
        factory = new RacketFactory(21000000);
    }

    @ParameterizedTest
    @MethodSource("speedSpinControlAndID")
    public void testCreateBalls(int speed, int spin, int control, int ID) {
        Racket racket = factory.createRacketWithSpeedSpinAndControl(speed, spin, control);
        assertEquals(ID, racket.getID());
    }

    @ParameterizedTest
    @MethodSource("speedSpinAndControl")
    public void testCreateBallsWithTheSameType(int speed, int spin, int control) {
        Racket firstRacket = factory.createRacketWithSpeedSpinAndControl(speed, spin, control);
        Racket secondRacket = factory.createRacketWithSpeedSpinAndControl(speed, spin, control);
        assertTrue(firstRacket.isSameType(secondRacket));
    }

    private static Stream<Arguments> speedSpinControlAndID() {
        return Stream.of(
                Arguments.of(9, 8, 7, 21000000),
                Arguments.of(1, 2, 3, 21000001),
                Arguments.of(2, 5, 6, 21000002),
                Arguments.of(3, 4, 5, 21000003),
                Arguments.of(10, 1, 9, 21000004),
                Arguments.of(2, 2, 2, 21000005),
                Arguments.of(2, 3, 5, 21000006),
                Arguments.of(2, 3, 5, 21000007),
                Arguments.of(10, 10, 10, 21000008),
                Arguments.of(1, 1, 1, 21000009)
                );
    }

    private static Stream<Arguments> speedSpinAndControl() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(2, 5, 6),
                Arguments.of(3, 4, 5),
                Arguments.of(10, 1, 9),
                Arguments.of(2, 2, 2),
                Arguments.of(2, 3, 5),
                Arguments.of(2, 3, 5),
                Arguments.of(10, 10, 10),
                Arguments.of(1, 1, 1)
        );
    }

}
