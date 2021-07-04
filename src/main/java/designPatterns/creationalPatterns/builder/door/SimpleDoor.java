package designPatterns.creationalPatterns.builder.door;

import designPatterns.creationalPatterns.builder.room.Room;

public class SimpleDoor extends Door {
    public SimpleDoor(Room firstRoom, Room secondRoom) {
        super(firstRoom, secondRoom);
    }
}
