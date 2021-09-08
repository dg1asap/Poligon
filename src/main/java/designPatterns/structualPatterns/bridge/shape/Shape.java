package designPatterns.structualPatterns.bridge.shape;

import designPatterns.structualPatterns.bridge.color.Color;

public abstract class Shape {
    private Color color;

    public Shape(Color color) {
        this.color = color;
    }

    public String getRGB() {
        return color.getRGB();
    }

    public abstract int getNumberOfEdges();

}
