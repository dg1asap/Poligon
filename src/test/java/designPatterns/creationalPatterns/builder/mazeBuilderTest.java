package designPatterns.creationalPatterns.builder;

import mazeGame.maze.Maze;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class mazeBuilderTest {
    @Test
    void createSimpleStandardMaze() {
        StandardMazeBuilder mazeBuilder = new StandardMazeBuilder();
        MazeDirector mazeDirector = new SimpleMazeDirector();
        mazeDirector.createMaze(mazeBuilder);
        Maze maze = mazeBuilder.getMaze();
    }

    @Test
    void createMagicComplexMaze() {
        MagicMazeBuilder mazeBuilder = new MagicMazeBuilder();
        MazeDirector mazeDirector = new ComplexMazeDirector();
        mazeDirector.createMaze(mazeBuilder);
        Maze maze = mazeBuilder.getMaze();
    }

    @Test
    void createBoomComplexMaze() {
        BoomMazeBuilder mazeBuilder = new BoomMazeBuilder();
        MazeDirector mazeDirector = new ComplexMazeDirector();
        mazeDirector.createMaze(mazeBuilder);
        Maze maze = mazeBuilder.getMaze();
    }

}
