package mazeGame.door;

import mazeGame.room.Room;

public abstract class Door {
    protected Room firstRoom;
    protected Room secondRoom;

    public Door(Room firstRoom, Room secondRoom) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
    }

}
