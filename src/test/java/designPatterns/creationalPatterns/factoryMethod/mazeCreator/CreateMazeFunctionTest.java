package designPatterns.creationalPatterns.factoryMethod.mazeCreator;

import mazeGame.maze.Maze;
import mazeGame.utilities.Side;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CreateMazeFunctionTest {
    @Test
    void testCreateSimpleStandardMaze() {
        StandardSimpleMazeCreator creator = new StandardSimpleMazeCreator();
        Maze maze = creator.createMaze();
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
        MagicComplexMazeCreator creator = new MagicComplexMazeCreator();
        Maze maze = creator.createMaze();
        assertComplexMaze(maze);
    }

    @Test
    void testCreateBoomComplexMaze() {
        BoomComplexMazeCreator creator = new BoomComplexMazeCreator();
        Maze maze = creator.createMaze();
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
