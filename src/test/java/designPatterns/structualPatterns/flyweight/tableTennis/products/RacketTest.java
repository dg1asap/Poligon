package designPatterns.structualPatterns.flyweight.tableTennis.products;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RacketTest {
    private static Racket firstRacket;
    private static Racket secondRacket;

    @BeforeAll
    public static void createBalls() {
        createFirstRacket();
        createSecondRacket();
    }

    private static void createFirstRacket() {
        RacketType firstRacketType = createRacketType(1, 2, 3);
        firstRacket = createRacketWithIDAndType(58000001, firstRacketType);
    }

    private static void createSecondRacket() {
        RacketType secondRacketType = createRacketType(5, 9, 10);
        secondRacket = createRacketWithIDAndType(22500005, secondRacketType);
    }

    private static void createRacketWithIDAndType(int ID, RacketType type) {
        return new Racket(ID, racketType);
    }

    @Test
    public void testBallID() {
        assertEquals(58000001, firstBall.ID);
        assertEquals(22500005, secondBall.ID);
    }

}