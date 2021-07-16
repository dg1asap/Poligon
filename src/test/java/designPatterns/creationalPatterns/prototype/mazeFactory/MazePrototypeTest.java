package designPatterns.creationalPatterns.prototype.mazeFactory;

import mazeGame.door.MagicDoor;
import mazeGame.door.SimpleDoor;
import mazeGame.maze.Maze;
import mazeGame.room.BoomRoom;
import mazeGame.room.SimpleRoom;
import mazeGame.utilities.Side;
import mazeGame.wall.BoomWall;
import mazeGame.wall.SimpleWall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazePrototypeTest {
    @Test
    void testCreateSimpleStandardMaze() throws CloneNotSupportedException {
        MazeFactory factory = new SimpleMazeFactory(new SimpleRoom(), new SimpleWall(), new SimpleDoor());
        Maze maze = factory.createMaze();
        assertEquals(2, maze.getNumberOfRooms());
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(0));
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(1));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.NORTH));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.EAST));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.WEST));
        assertEquals(2, maze.getNumberOfWallsFromSide(Side.SOUTH));
    }

    @Test
    void testCreateMagicComplexMaze() throws CloneNotSupportedException {
        MazeFactory factory = new ComplexMazeFactory(new SimpleRoom(), new SimpleWall(), new MagicDoor());
        Maze maze = factory.createMaze();
        assertComplexMaze(maze);
    }

    @Test
    void testCreateBoomComplexMaze() throws CloneNotSupportedException {
        MazeFactory factory = new ComplexMazeFactory(new BoomRoom(), new BoomWall(), new SimpleDoor());
        Maze maze = factory.createMaze();
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
