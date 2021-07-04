package designPatterns.creationalPatterns.builder.door;

import designPatterns.creationalPatterns.builder.room.Room;

public abstract class Door {
    private Room firstRoom;
    private Room secondRoom;

    public Door(Room firstRoom, Room secondRoom) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
    }

}
