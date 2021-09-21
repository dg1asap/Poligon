package designPatterns.structualPatterns.flyweight.tableTennis.products;

public class RacketType {
    protected int speed;
    protected int spin;
    protected int control;

    public RacketType(int speed, int spin, int control) {
        this.speed = speed;
        this.spin = spin;
        this.control = control;
    }

    public boolean hasSpeedSpinAndControl(int speed, int spin, int control) {
        return this.speed == speed && this.spin == spin && this.control == control;
    }

}
