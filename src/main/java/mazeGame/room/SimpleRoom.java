package mazeGame.room;

public class SimpleRoom extends Room {
    public SimpleRoom() {
        super();
    }

    public SimpleRoom(SimpleRoom room) {
        super(room);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return new SimpleRoom(this);
    }
}
