package designPatterns.structualPatterns.flyweight.tableTennis.products;

public class Ball extends TableTennisProduct {
    protected BallType type;

    public Ball(int ID, BallType type) {
        super(ID);
        this.type = type;
    }

    public boolean isSameType(Ball ball) {
        return this.type == ball.type;
    }

}
