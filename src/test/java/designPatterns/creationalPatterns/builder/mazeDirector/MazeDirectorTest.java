package designPatterns.creationalPatterns.builder.mazeDirector;

import designPatterns.creationalPatterns.builder.mazeBuilder.BoomMazeBuilder;
import designPatterns.creationalPatterns.builder.mazeBuilder.MagicMazeBuilder;
import designPatterns.creationalPatterns.builder.mazeBuilder.StandardMazeBuilder;
import mazeGame.maze.Maze;
import mazeGame.utilities.Side;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class MazeDirectorTest {
    @Test
    void createSimpleStandardMaze() {
        StandardMazeBuilder builder = new StandardMazeBuilder();
        MazeDirector director = new SimpleMazeDirector();
        director.constructMaze(builder);
        Maze maze = builder.getMaze();
        assertEquals(2, maze.getNumberOfRooms());
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(0));
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(1));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.NORTH));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.EAST));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.WEST));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.SOUTH));
    }

    @Test
    void createMagicComplexMaze() {
        MagicMazeBuilder builder = new MagicMazeBuilder();
        MazeDirector director = new ComplexMazeDirector();
        director.constructMaze(builder);
        Maze maze = builder.getMaze();
        assertComplexMaze(maze);
    }

    @Test
    void createBoomComplexMaze() {
        BoomMazeBuilder builder = new BoomMazeBuilder();
        MazeDirector director = new ComplexMazeDirector();
        director.constructMaze(builder);
        Maze maze = builder.getMaze();
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