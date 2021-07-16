package mazeGame.wall;

public class BoomWall extends Wall {
    public BoomWall() {
        super();
    }

    public BoomWall(BoomWall wall) {
       super(wall);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new BoomWall(this);
    }
}
