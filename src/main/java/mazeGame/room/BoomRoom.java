package mazeGame.room;

public class BoomRoom extends Room {
    public BoomRoom() {
        super();
    }

    public BoomRoom(BoomRoom room) {
        super(room);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new BoomRoom(this);
    }
}
