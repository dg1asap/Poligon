package designPatterns.structualPatterns.flyweight.tableTennis.products;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RacketTypeTest {
    private static RacketType firstRacketType;
    private static RacketType secondRacketType;

    @BeforeAll
    public static void createRacketTypes() {
        firstRacketType = new RacketType(10, 1, 5);
        secondRacketType = new RacketType(9, 4, 5);
    }

    @Test
    public void testRacketSpeed() {
        assertEquals(10, firstRacketType.speed);
        assertEquals(9, secondRacketType.speed);
    }

    @Test
    public void testRacketSpin() {
        assertEquals(1, firstRacketType.spin);
        assertEquals(4, secondRacketType.spin);

    }

    @Test
    public void testRacketControl() {
        assertEquals(5, firstRacketType.control);
        assertEquals(5, secondRacketType.control);

    }

    @Test
    public void testHasSpeedSpinAndControl() {
        assertTrue(firstRacketType.hasSpeedSpinAndControl(10, 1 ,5));
        assertTrue(secondRacketType.hasSpeedSpinAndControl(9, 4 ,5));
    }

}
