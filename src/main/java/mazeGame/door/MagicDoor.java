package mazeGame.door;

public class MagicDoor extends Door {
    public MagicDoor() {
        super();
    }

    public MagicDoor(MagicDoor door) {
        super(door);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new MagicDoor(this);
    }
}
