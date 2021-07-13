package designPatterns.creationalPatterns.abstractFactory.mazeFactory;

import mazeGame.door.Door;
import mazeGame.door.SimpleDoor;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import mazeGame.wall.SimpleWall;
import mazeGame.wall.Wall;

public class StandardMazeFactory implements MazeFactory {
    @Override
    public Maze createMaze() {
        return new Maze();
    }

    @Override
    public Room createRoom() {
        return new SimpleRoom();
    }

    @Override
    public Wall createWall() {
        return new SimpleWall();
    }

    @Override
    public Door createDoor() {
        return new SimpleDoor();
    }
}
