package designPatterns.structualPatterns.flyweight.tableTennis.products;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class RacketTest {
    private static Racket firstRacket;
    private static Racket secondRacket;
    private static Racket thirdRacket;


    @BeforeAll
    public static void createBalls() {
        createFirstRacket();
        createSecondAndThirdRacketWithTheSameType();
    }

    private static void createFirstRacket() {
        RacketType firstRacketType = new RacketType(1, 2, 3);
        firstRacket = new Racket(58000001, firstRacketType);
    }

    private static void createSecondAndThirdRacketWithTheSameType() {
        RacketType commonRacketType = new RacketType(5, 9, 10);
        secondRacket = new Racket(22500005, commonRacketType);
        thirdRacket = new Racket(22500005, commonRacketType);
    }

    @Test
    public void testBallID() {
        assertEquals(58000001, firstRacket.getID());
        assertEquals(22500005, secondRacket.getID());
    }

    @Test
    public void testIsSameType() {
        assertTrue(secondRacket.isSameType(thirdRacket));
        assertFalse(firstRacket.isSameType(secondRacket));
    }

}