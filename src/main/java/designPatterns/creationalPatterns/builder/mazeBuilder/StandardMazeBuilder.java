package designPatterns.creationalPatterns.builder.mazeBuilder;

import mazeGame.door.Door;
import mazeGame.door.SimpleDoor;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import mazeGame.utilities.Side;
import mazeGame.wall.SimpleWall;
import mazeGame.wall.Wall;

public class StandardMazeBuilder {
    protected Maze maze;

    public void buildMaze() {
        maze = new Maze();
    }

    public void buildRoom() {
        Room room = new SimpleRoom();
        maze.addRoom(room);
    }

    public void buildWallInRoomWithIndexFromSide(int roomIndex, Side side) {
        Wall wall = new SimpleWall();
        maze.setWallInRoomWithIndexFromSide(wall, roomIndex, side);
    }

    public void buildDoorBetweenRoomsWithIndexes(int firstRoomIndex, int secondRoomIndex) {
        Door door = new SimpleDoor();
        maze.embedDoorInRoomsWithIndexes(door, firstRoomIndex, secondRoomIndex);
    }

    public void buildCommonWallFromSideOfFirstRoomWithIndex(Side side, int firstRoomIndex, int secondRoomIndex) {
        Wall wall = new SimpleWall();
        maze.setWallInRoomWithIndexFromSide(wall, firstRoomIndex, side);
        maze.setWallInRoomWithIndexFromSide(wall, secondRoomIndex, side.getOppositeSide());
    }

    public Maze getMaze() {
        return maze;
    }

}