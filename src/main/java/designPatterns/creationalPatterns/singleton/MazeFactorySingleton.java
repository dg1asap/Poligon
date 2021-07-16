package designPatterns.creationalPatterns.singleton;

import designPatterns.creationalPatterns.abstractFactory.mazeFactory.MazeFactory;
import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.wall.Wall;

public enum MazeFactorySingleton implements MazeFactory{
    MAZE_FACTORY;

    private MazeFactory factory;

    public void initMazeFactory(MazeFactory factory) {
        this.factory = factory;
    }

    @Override
    public Maze createMaze() {
        return factory.createMaze();
    }

    @Override
    public Room createRoom() {
        return factory.createRoom();
    }

    @Override
    public Wall createWall() {
        return factory.createWall();
    }

    @Override
    public Door createDoor() {
        return factory.createDoor();
    }
}
