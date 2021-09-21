package designPatterns.structualPatterns.flyweight.tableTennis.products;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TableTennisProductTest {
    private static TableTennisProduct ball;
    private static TableTennisProduct racket;

    @BeforeAll
    public static void createProducts() {
        ball = createBall();
        racket = createRacket();
    }

    private static Ball createBall() {
        BallType ballType = new BallType(2);
        return new Ball(123456789, ballType);
    }

    private static Racket createRacket() {
        RacketType racketType = new RacketType(10, 2, 3);
        return new Racket(987654321, racketType);
    }

    @Test
    public void testGetID() {
        assertEquals(123456789, ball.getID());
        assertEquals(987654321, racket.getID());
    }

}
