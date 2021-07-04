package designPatterns.creationalPatterns.builder.maze;

import designPatterns.creationalPatterns.builder.room.Room;

import java.util.ArrayList;

public class Maze {
    private ArrayList <Room> rooms = new ArrayList<>();

    public void addRoom(Room room) {
        rooms.add(room);
    }
}
