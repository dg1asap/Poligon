package designPatterns.creationalPatterns.singleton;

import designPatterns.creationalPatterns.abstractFactory.mazeFactory.BoomMazeFactory;
import designPatterns.creationalPatterns.abstractFactory.mazeFactory.MagicMazeFactory;
import designPatterns.creationalPatterns.abstractFactory.mazeFactory.StandardMazeFactory;
import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.utilities.Side;
import mazeGame.wall.Wall;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazeFactorySingletonTest {
    @Test
    void testCreateStandardMazeFactory() {
        MazeFactorySingleton.MAZE_FACTORY.initMazeFactory(new StandardMazeFactory());
        Maze maze = createDefectiveSimpleMaze();
        assertMaze(maze);
    }

    @Test
    void testCreateMagicMazeFactory() {
        MazeFactorySingleton.MAZE_FACTORY.initMazeFactory(new MagicMazeFactory());
        Maze maze = createDefectiveSimpleMaze();
        assertMaze(maze);
    }

    @Test
    void testCreateBoomMazeFactory() {
        MazeFactorySingleton.MAZE_FACTORY.initMazeFactory(new BoomMazeFactory());
        Maze maze = createDefectiveSimpleMaze();
        assertMaze(maze);
    }

    private Maze createDefectiveSimpleMaze() {
        Maze maze = createMazeWithMazeFactorySingleton();
        addTwoRoomsToMaze(maze);
        addCommonWallToMaze(maze);
        addDoorToMaze(maze);
        return maze;
    }

    private Maze createMazeWithMazeFactorySingleton() {
        return MazeFactorySingleton.MAZE_FACTORY.createMaze();
    }

    private void addTwoRoomsToMaze(Maze maze) {
        Room firstRoom = MazeFactorySingleton.MAZE_FACTORY.createRoom();
        Room secondRoom = MazeFactorySingleton.MAZE_FACTORY.createRoom();
        maze.addRoom(firstRoom);
        maze.addRoom(secondRoom);
    }

    private void addCommonWallToMaze(Maze maze) {
        Wall commonWall = MazeFactorySingleton.MAZE_FACTORY.createWall();
        maze.setWallInRoomWithIndexFromSide(commonWall, 0, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(commonWall, 1, Side.WEST);

    }

    private void addDoorToMaze(Maze maze) {
        Door door = MazeFactorySingleton.MAZE_FACTORY.createDoor();
        maze.embedDoorInRoomsWithIndexes(door, 0, 1);
    }

    private void assertMaze(Maze maze) {
        assertEquals(2, maze.getNumberOfRooms());
        assertEquals(0, maze.getNumberOfWallsFromSide(Side.NORTH));
        assertEquals(1, maze.getNumberOfWallsFromSide(Side.EAST));
        assertEquals(1, maze.getNumberOfWallsFromSide(Side.WEST));
        assertEquals(0, maze.getNumberOfWallsFromSide(Side.SOUTH));
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(0));
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(1));
    }

}
