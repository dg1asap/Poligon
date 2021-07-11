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
        StandardMazeBuilder mazeBuilder = new StandardMazeBuilder();
        MazeDirector mazeDirector = new SimpleMazeDirector();
        mazeDirector.createMaze(mazeBuilder);
        Maze maze = mazeBuilder.getMaze();
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
        MagicMazeBuilder mazeBuilder = new MagicMazeBuilder();
        MazeDirector mazeDirector = new ComplexMazeDirector();
        mazeDirector.createMaze(mazeBuilder);
        Maze maze = mazeBuilder.getMaze();
        assertComplexMaze(maze);
    }

    @Test
    void createBoomComplexMaze() {
        BoomMazeBuilder mazeBuilder = new BoomMazeBuilder();
        MazeDirector mazeDirector = new ComplexMazeDirector();
        mazeDirector.createMaze(mazeBuilder);
        Maze maze = mazeBuilder.getMaze();
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