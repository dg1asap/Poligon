package mazeGame.maze;

import mazeGame.room.Room;

import java.util.ArrayList;

public class Maze {
    protected ArrayList <Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
