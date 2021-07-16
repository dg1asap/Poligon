package mazeGame.wall;

public class SimpleWall extends Wall {
    public SimpleWall() {
        super();
    }

    public SimpleWall(SimpleWall wall) {
        super(wall);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new SimpleWall(this);
    }
}
