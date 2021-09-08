package designPatterns.structualPatterns.bridge.shape;

import designPatterns.structualPatterns.bridge.color.Color;

public class Rectangle extends Shape{
    public Rectangle(Color color) {
        super(color);
    }

    @Override
    public int getNumberOfEdges() {
        return 4;
    }
}
