package mazeGame.maze;

import mazeGame.room.Room;
import mazeGame.utilities.Side;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Maze {
    protected ArrayList <Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }

    public int getNumberOfRooms() {
        return rooms.size();
    }

    public int getNumberOfWallsFromSide(Side side) {
        AtomicInteger numberOfWalls = new AtomicInteger(0);
        rooms.forEach(room -> countNumberOfWallsInRoomFromSide(numberOfWalls, room, side));
        return numberOfWalls.intValue();
    }

    public int getNumberOfDoorsFromSide(Side side) {
        AtomicInteger numberOfDoors = new AtomicInteger(0);
        rooms.forEach(room -> countNumberOfDoorsInRoomFromSide(numberOfDoors, room, side));
        return numberOfDoors.intValue();
    }

    private void countNumberOfWallsInRoomFromSide(AtomicInteger numberOfWalls, Room room, Side side) {
        if (room.hasWallFromSide(side))
            numberOfWalls.set(numberOfWalls.incrementAndGet());
    }

    private void countNumberOfDoorsInRoomFromSide(AtomicInteger numberOfDoors, Room room, Side side) {
        if (room.hasDoorFromSide(side))
            numberOfDoors.set(numberOfDoors.incrementAndGet());
    }

}
