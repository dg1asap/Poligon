package designPatterns.structualPatterns.bridge.shape;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ShapeTest {
    static Shape redCircle;
    static Shape greenCircle;
    static Shape redRectangle;
    static Shape greenRectangle;

    static void createShapes() {
        redCircle = getRedCircle();
        greenCircle = getGreenCircle();
        redRectangle = getRedRectangle();
        greenRectangle = getGreenRectangle();
    }

    static Circle getRedCircle() {
        Color red = new Color();
        return new Circle(red);
    }

    static Circle getGreenCircle() {
        Color green = new Color();
        return new Circle(green);
    }

    static Rectange getRedRectangle() {
        Color red = new Color();
        return new Rectangle(red);
    }

    static Rectange getGreenRectangle() {
        Color green = new Color();
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
        assertEquals("#FF0000", redCircle.getColor());
        assertEquals("#FF0000", redRectangle.getColor());
        assertEquals("#008000", greenCircle.getColor());
        assertEquals("#008000", greenRectangle.getColor());
    }


}
