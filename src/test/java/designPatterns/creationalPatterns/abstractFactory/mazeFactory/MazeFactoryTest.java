package designPatterns.creationalPatterns.abstractFactory.mazeFactory;

import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import mazeGame.utilities.Side;
import mazeGame.wall.SimpleWall;
import mazeGame.wall.Wall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazeFactoryTest {
    static MazeFactory standardMazeFactory;
    static MazeFactory magicMazeFactory;
    static MazeFactory boomMazeFactory;

    @BeforeAll
    static void constructFactories() {
        standardMazeFactory = new StandardMazeFactory();
        magicMazeFactory = new MagicMazeFactory();
        boomMazeFactory = new BoomMazeFactory();
    }

    @Test
    void testCreateEmptyMaze() {
        Maze firstMaze = standardMazeFactory.createMaze();
        Maze secondMaze = magicMazeFactory.createMaze();
        Maze thirdMaze = boomMazeFactory.createMaze();
        assertEquals(0, firstMaze.getNumberOfRooms());
        assertEquals(0, secondMaze.getNumberOfRooms());
        assertEquals(0, thirdMaze.getNumberOfRooms());
    }

    @Test
    void testCreateRoom() {
        Maze maze = new Maze();
        Room standardRoom = standardMazeFactory.createRoom();
        Room magicRoom = magicMazeFactory.createRoom();
        Room boomRoom = boomMazeFactory.createRoom();
        maze.addRoom(standardRoom);
        maze.addRoom(magicRoom);
        maze.addRoom(boomRoom);
        assertEquals(3, maze.getNumberOfRooms());
    }

    @Test
    void testCreateWall() {
        Maze maze = new Maze();
        Room room = new SimpleRoom();
        maze.addRoom(room);

        Wall standardWall = standardMazeFactory.createWall();
        Wall magicWall = magicMazeFactory.createWall();
        Wall boomWall = boomMazeFactory.createWall();

        maze.setWallInRoomWithIndexFromSide(standardWall, 0, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(magicWall, 0, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(boomWall, 0, Side.WEST);

        assertEquals(1, maze.getNumberOfWallsFromSide(Side.NORTH));
        assertEquals(1, maze.getNumberOfWallsFromSide(Side.EAST));
        assertEquals(1, maze.getNumberOfWallsFromSide(Side.WEST));
    }

    @Test
    void testCreateDoor() {
        Maze maze = new Maze();
        createNRoomsInMaze(4, maze);
        createNCommonWallsInMaze(3, maze);
        createVariousDoorsInMaze(maze);

        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(0));
        assertEquals(2, maze.getNumberOfDoorsRoomWithIndex(1));
        assertEquals(2, maze.getNumberOfDoorsRoomWithIndex(2));
        assertEquals(1, maze.getNumberOfDoorsRoomWithIndex(3));
    }

    private void createNRoomsInMaze(int numberOfRooms, Maze maze) {
        for (int i = 0; i < numberOfRooms; i++)
            maze.addRoom(new SimpleRoom());
    }

    private void createNCommonWallsInMaze(int numberOfCommonWalls, Maze maze) {
        for (int i = 0; i < numberOfCommonWalls; i++) {
            Wall commonWall = new SimpleWall();
            maze.setWallInRoomWithIndexFromSide(commonWall, i, Side.EAST);
            maze.setWallInRoomWithIndexFromSide(commonWall, i+1, Side.WEST);
        }
    }

    private void createVariousDoorsInMaze(Maze maze) {
        Door standardDoor = standardMazeFactory.createDoor();
        Door magicDoor = magicMazeFactory.createDoor();
        Door boomDoor = boomMazeFactory.createDoor();

        maze.embedDoorInRoomsWithIndexes(standardDoor, 0, 1);
        maze.embedDoorInRoomsWithIndexes(magicDoor, 1, 2);
        maze.embedDoorInRoomsWithIndexes(boomDoor, 2, 3);
    }
}
