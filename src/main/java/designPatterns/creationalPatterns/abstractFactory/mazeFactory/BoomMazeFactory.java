package designPatterns.creationalPatterns.abstractFactory.mazeFactory;

import mazeGame.door.Door;
import mazeGame.door.SimpleDoor;
import mazeGame.maze.Maze;
import mazeGame.room.BoomRoom;
import mazeGame.room.Room;
import mazeGame.wall.BoomWall;
import mazeGame.wall.Wall;

public class BoomMazeFactory implements MazeFactory {
    @Override
    public Maze createMaze() {
        return new Maze();
    }

    @Override
    public Room createRoom() {
        return new BoomRoom();
    }

    @Override
    public Wall createWall() {
        return new BoomWall();
    }

    @Override
    public Door createDoor() {
        return new SimpleDoor();
    }
}
