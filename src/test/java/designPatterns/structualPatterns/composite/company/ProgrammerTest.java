package designPatterns.structualPatterns.composite.company;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProgrammerTest {
    static Programmer programmer;

    @BeforeAll
    static void createProgrammer() {
        programmer = new Programmer(4000);
    }

    @Test
    void testGetCost() {
        double cost = programmer.getCost();
        assertEquals(4000, cost);
    }

}
