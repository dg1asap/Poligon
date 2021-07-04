package designPatterns.creationalPatterns.builder.door;

import designPatterns.creationalPatterns.builder.room.Room;

public abstract class Door {
    protected Room firstRoom;
    protected Room secondRoom;

    public Door(Room firstRoom, Room secondRoom) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
    }

}
