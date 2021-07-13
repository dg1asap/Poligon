package designPatterns.creationalPatterns.abstractFactory.mazeFactory;

import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.wall.Wall;

public interface MazeFactory {
    Maze createMaze();

    Room createRoom();

    Wall createWall();

    Door createDoor();

}
