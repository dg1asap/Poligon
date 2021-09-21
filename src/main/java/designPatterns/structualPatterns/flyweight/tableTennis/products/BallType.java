package designPatterns.structualPatterns.flyweight.tableTennis.products;

public class BallType {
    protected int quality;

    public BallType(int quality) {
        this.quality = quality;
    }

    public boolean hasQuality(int quality) {
        return this.quality == quality;
    }

}
