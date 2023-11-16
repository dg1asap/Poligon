package designPatterns.creationalPatterns.abstractFactory.mazeCreator;

import designPatterns.creationalPatterns.abstractFactory.mazeFactory.BoomMazeFactory;
import designPatterns.creationalPatterns.abstractFactory.mazeFactory.MagicMazeFactory;
import designPatterns.creationalPatterns.abstractFactory.mazeFactory.MazeFactory;
import designPatterns.creationalPatterns.abstractFactory.mazeFactory.StandardMazeFactory;
import mazeGame.maze.Maze;
import mazeGame.utilities.Side;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateMazeFunctionTest {
    @Test
    void testCreateStandardSimpleMaze() {
        SimpleMazeCreator creator = new SimpleMazeCreator();
        MazeFactory factory = new StandardMazeFactory();
        Maze maze = creator.createMaze(factory);
        assertEquals(2, maze.getNumberOfRooms());
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(0));
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(1));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.NORTH));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.EAST));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.WEST));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.SOUTH));
    }

    @Test
    void testCreateMagicComplexMaze() {
        ComplexMazeCreator creator = new ComplexMazeCreator();
        MazeFactory factory = new MagicMazeFactory();
        Maze maze = creator.createMaze(factory);
        assertComplexMaze(maze);
    }

    @Test
    void testCreateBoomComplexMaze() {
        ComplexMazeCreator creator = new ComplexMazeCreator();
        MazeFactory factory = new BoomMazeFactory();
        Maze maze = creator.createMaze(factory);
        assertComplexMaze(maze);
    }

    private void assertComplexMaze(Maze maze) {
        assertEquals(3, maze.getNumberOfRooms());
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(0));
        assertEquals(2, maze.getNumberOfDoorsRoomWithIndex(1));
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(2));
        assertEquals(3, maze.getNumberOfWallsFromSide(Side.NORTH));
        assertEquals(3, maze.getNumberOfWallsFromSide(Side.EAST));
        assertEquals(3, maze.getNumberOfWallsFromSide(Side.WEST));
        assertEquals(3, maze.getNumberOfWallsFromSide(Side.SOUTH));
    }

}
