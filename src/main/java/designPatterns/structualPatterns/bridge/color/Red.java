package designPatterns.structualPatterns.bridge.color;

public class Red implements Color {
    @Override
    public String getRGB() {
        return "#FF0000";
    }
}
