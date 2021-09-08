package designPatterns.structualPatterns.bridge.shape;

import designPatterns.structualPatterns.bridge.color.Color;
import designPatterns.structualPatterns.bridge.color.Green;
import designPatterns.structualPatterns.bridge.color.Red;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {
    static Shape redCircle;
    static Shape greenCircle;
    static Shape redRectangle;
    static Shape greenRectangle;

    @BeforeAll
    static void createShapes() {
        redCircle = getRedCircle();
        greenCircle = getGreenCircle();
        redRectangle = getRedRectangle();
        greenRectangle = getGreenRectangle();
    }

    static Circle getRedCircle() {
        Color red = new Red();
        return new Circle(red);
    }

    static Circle getGreenCircle() {
        Color green = new Green();
        return new Circle(green);
    }

    static Rectangle getRedRectangle() {
        Color red = new Red();
        return new Rectangle(red);
    }

    static Rectangle getGreenRectangle() {
        Color green = new Green();
        return new Rectangle(green);
    }

    @Test
    void testGetNumberOfEdges() {
        assertEquals(0, redCircle.getNumberOfEdges());
        assertEquals(0, greenCircle.getNumberOfEdges());
        assertEquals(4, redRectangle.getNumberOfEdges());
        assertEquals(4, greenRectangle.getNumberOfEdges());
    }

    @Test
    void testGetColor() {
        assertEquals("#FF0000", redCircle.getRGB());
        assertEquals("#FF0000", redRectangle.getRGB());
        assertEquals("#008000", greenCircle.getRGB());
        assertEquals("#008000", greenRectangle.getRGB());
    }


}
