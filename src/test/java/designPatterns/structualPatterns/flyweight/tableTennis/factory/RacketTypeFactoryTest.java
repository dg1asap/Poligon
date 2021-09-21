package designPatterns.structualPatterns.flyweight.tableTennis.factory;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertSame;

public class RacketTypeFactoryTest {
    private static RacketTypeFactory factory;

    @BeforeAll
    public static void createFactory() {
        factory = new RacketTypeFactory();
    }

    @ParameterizedTest
    @MethodSource("speedSpinAndControl")
    public void testCreateRacketWithParameters(int speed, int spin, int control) {
        RacketType racketType = factory.createRacketType(speed, spin, control);

        assertEquals(speed, racketType.speed);
        assertEquals(spin, racketType.spin);
        assertEquals(control, racketType.control);
    }

    @ParameterizedTest
    @MethodSource("speedSpinAndControl")
    public void testCreateTheSameRacketWithParameters(int speed, int spin, int control) {
        RacketType firstRacketType = factory.createRacketType(speed, spin, control);
        RacketType secondRacketType = factory.createRacketType(speed, spin, control);

        assertSame(firstRacketType, secondRacketType);
    }



    private static Stream <Arguments> speedSpinAndControl() {
        return Stream.of(
                Arguments.of(1, 2, 3),
                Arguments.of(5, 6, 3),
                Arguments.of(8, 6, 3)
        );
    }

}
