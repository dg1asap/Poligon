package designPatterns.structualPatterns.bridge.color;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ColorTest {
    static Color green;
    static Color red;

    @BeforeAll
    static void createColors() {
        green = new Green();
        red = new Red();
    }

    @Test
    void testGetRedRGB() {
        assertEquals("#FF0000", red.getRGB());
    }

    @Test
    void testGetGreenRGB() {
        assertEquals("008000", green.getRGB());
    }


}
