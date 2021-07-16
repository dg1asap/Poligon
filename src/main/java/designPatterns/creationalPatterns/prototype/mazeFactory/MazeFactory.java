package designPatterns.creationalPatterns.prototype.mazeFactory;

import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.wall.Wall;

public abstract class MazeFactory {
    protected Room prototypeRoom;
    protected Wall prototypeWall;
    protected Door prototypeDoor;

    public MazeFactory(Room room, Wall wall, Door door) {
        prototypeRoom = room;
        prototypeWall = wall;
        prototypeDoor = door;
    }

    public abstract Maze createMaze() throws CloneNotSupportedException;

}
