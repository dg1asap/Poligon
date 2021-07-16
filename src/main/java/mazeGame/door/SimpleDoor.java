package mazeGame.door;

public class SimpleDoor extends Door {
    public SimpleDoor() {
        super();
    }

    public SimpleDoor(SimpleDoor door) {
        super(door);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new SimpleDoor(this);
    }
}
