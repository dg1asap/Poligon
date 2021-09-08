package designPatterns.structualPatterns.bridge.shape;

import designPatterns.structualPatterns.bridge.color.Color;

public class Circle extends Shape {
    public Circle(Color color) {
        super(color);
    }

    @Override
    public int getNumberOfEdges() {
        return 0;
    }
}
