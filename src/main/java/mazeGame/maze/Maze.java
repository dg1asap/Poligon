package mazeGame.maze;

import mazeGame.door.Door;
import mazeGame.room.Room;
import mazeGame.utilities.Side;
import mazeGame.wall.Wall;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Maze {
    protected ArrayList <Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public void embedDoorInRoomsWithIndexes(Door door, int firstRoomIndex, int secondRoomIndex) {
        Room firstRoom = rooms.get(firstRoomIndex);
        Room secondRoom = rooms.get(secondRoomIndex);
        door.embedInRooms(firstRoom, secondRoom);
    }

    public void setWallInRoomWithIndexFromSide(Wall wall, int roomIndex, Side side) {
        Room room = rooms.get(roomIndex);
        room.setSide(side, wall);
    }

    public int getNumberOfRooms() {
        return rooms.size();
    }

    public int getNumberOfDoorsRoomWithIndex(int index) {
        Room room = rooms.get(index);
        return room.getNumberOfDoors();
    }

    public int getNumberOfWallsFromSide(Side side) {
        AtomicInteger numberOfWalls = new AtomicInteger(0);
        rooms.forEach(room -> countNumberOfWallsInRoomOnSide(numberOfWalls, room, side));
        return numberOfWalls.intValue();
    }

    public int getNumberOfDoorsFromSide(Side side) {
        AtomicInteger numberOfDoors = new AtomicInteger(0);
        rooms.forEach(room -> countNumberOfDoorsInRoomOnSide(numberOfDoors, room, side));
        return numberOfDoors.intValue();
    }

    private void countNumberOfWallsInRoomOnSide(AtomicInteger numberOfWalls, Room room, Side side) {
        if (room.hasWallFromSide(side))
            numberOfWalls.set(numberOfWalls.incrementAndGet());
    }

    private void countNumberOfDoorsInRoomOnSide(AtomicInteger numberOfDoors, Room room, Side side) {
        if (room.hasDoorFromSide(side))
            numberOfDoors.set(numberOfDoors.incrementAndGet());
    }

}
