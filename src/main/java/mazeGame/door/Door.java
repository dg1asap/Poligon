package mazeGame.door;

import mazeGame.room.Room;

public abstract class Door implements Cloneable {
    protected Room firstRoom;
    protected Room secondRoom;

    public Door() {}

    public Door(Door door) {}

    public void embedInRooms (Room firstRoom, Room secondRoom) {
        setRooms(firstRoom, secondRoom);
        ifRoomsHasCommonWallEmbedDoor(firstRoom, secondRoom);
    }

    public boolean isInRoom(Room room) {
        return firstRoom == room || secondRoom == room;
    }

    public boolean isEmbed() {
        return firstRoom != null && secondRoom != null;
    }

    public abstract Object clone() throws CloneNotSupportedException;

    private void setRooms(Room firstRoom, Room secondRoom) {
        this.firstRoom = firstRoom;
        this.secondRoom = secondRoom;
    }

    private void ifRoomsHasCommonWallEmbedDoor(Room firstRoom, Room secondRoom) {
        if (firstRoom.hasCommonWall(secondRoom))
            firstRoom.embedDoorInCommonWall(this, secondRoom);
    }

}
