package designPatterns.creationalPatterns.abstractFactory.mazeCreator;

import designPatterns.creationalPatterns.abstractFactory.mazeFactory.MazeFactory;
import mazeGame.maze.Maze;

@FunctionalInterface
public interface MazeCreator {
    Maze createMaze(MazeFactory mazeFactory);
}
