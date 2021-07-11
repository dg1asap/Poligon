package mazeGame.maze;

import mazeGame.door.Door;
import mazeGame.door.SimpleDoor;
import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import mazeGame.utilities.Side;
import mazeGame.wall.SimpleWall;
import mazeGame.wall.Wall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MazeTest {
    private static Maze maze = new Maze();
    private static Maze secondMaze = new Maze();
    private static Maze thirdMaze = new Maze();

    @BeforeAll
    static void createWithTwoSimpleMaze() {
        createDefectiveSimpleStandardMaze(maze);
        createDefectiveComplexStandardMaze(secondMaze);
    }

    static void createDefectiveSimpleStandardMaze(Maze maze) {
        Room firstRoom = new SimpleRoom();
        Room secondRoom = new SimpleRoom();

        Door simpleDoor = new SimpleDoor();
        simpleDoor.embedInRooms(firstRoom, secondRoom);
        Wall commonWall = new SimpleWall();
        commonWall.setDoor(simpleDoor);
        firstRoom.setSide(Side.EAST, commonWall);
        secondRoom.setSide(Side.WEST, commonWall);

        firstRoom.setSide(Side.NORTH, new SimpleWall());
        secondRoom.setSide(Side.NORTH, new SimpleWall());

        maze.addRoom(firstRoom);
        maze.addRoom(secondRoom);
    }

    static void createDefectiveComplexStandardMaze(Maze maze) {
        Room firstRoom = new SimpleRoom();
        Room secondRoom = new SimpleRoom();
        Room thirdRoom = new SimpleRoom();

        Wall firstAndSecondRoomCommonWall = new SimpleWall();
        Wall secondAndThirdRoomCommonWall = new SimpleWall();
        Door firstAndSecondRoomCommonDoor = new SimpleDoor();
        firstAndSecondRoomCommonDoor.embedInRooms(firstRoom, secondRoom);

        Door secondAndThirdRoomCommonDoor = new SimpleDoor();
        secondAndThirdRoomCommonDoor.embedInRooms(secondRoom, thirdRoom);

        firstAndSecondRoomCommonWall.setDoor(firstAndSecondRoomCommonDoor);
        secondAndThirdRoomCommonWall.setDoor(secondAndThirdRoomCommonDoor);

        firstRoom.setSide(Side.EAST, firstAndSecondRoomCommonWall);
        secondRoom.setSide(Side.WEST, firstAndSecondRoomCommonWall);
        secondRoom.setSide(Side.SOUTH, secondAndThirdRoomCommonWall);
        thirdRoom.setSide(Side.NORTH, secondAndThirdRoomCommonWall);

        maze.addRoom(firstRoom);
        maze.addRoom(secondRoom);
        maze.addRoom(thirdRoom);
    }

    @Test
    void testNumberOfRooms() {
        int numberOfRoomsInMaze = maze.getNumberOfRooms();
        assertEquals(numberOfRoomsInMaze, 2);
    }

    @ParameterizedTest(name = "#{index} {0} walls from site {1}")
    @MethodSource("numberOfWallsAndSides")
    void testNumberOfWallsFromSide(int expectedNumberOfWalls, Side side) {
        int actualNumberOfWalls = maze.getNumberOfWallsFromSide(side);
        assertEquals(expectedNumberOfWalls, actualNumberOfWalls);
    }

    @ParameterizedTest(name = "#{index} {0} doors form site {1}")
    @MethodSource("numberOfDoorsAndSides")
    void testNumberOfDoorFromSide(int expectedNumberOfDoor, Side side) {
        int actualNumberOfDoors = maze.getNumberOfDoorsFromSide(side);
        assertEquals(expectedNumberOfDoor, actualNumberOfDoors);
    }

    @Test
    void testNumberOfDoorsInRoomOfFirstMaze() {
        int numberOfDoorsInFirstRoom = maze.getNumberOfDoorsRoomWithIndex(0);
        int numberOfDoorsInSecondRoom = maze.getNumberOfDoorsRoomWithIndex(1);
        assertEquals(1, numberOfDoorsInFirstRoom);
        assertEquals(1, numberOfDoorsInSecondRoom);
    }

    @Test
    void testNumberOfDoorsInRoomOfSecondMaze() {
        int numberOfDoorsInFirstRoom = secondMaze.getNumberOfDoorsRoomWithIndex(0);
        int numberOfDoorsInSecondRoom = secondMaze.getNumberOfDoorsRoomWithIndex(1);
        int numberOfDoorsInThirdRoom = secondMaze.getNumberOfDoorsRoomWithIndex(2);
        assertEquals(1, numberOfDoorsInFirstRoom);
        assertEquals(2, numberOfDoorsInSecondRoom);
        assertEquals(1, numberOfDoorsInThirdRoom);
    }

    @Test
    void testAddDoor() {
        thirdMaze.addRoom(new SimpleRoom());
        thirdMaze.addRoom(new SimpleRoom());

        int numberOfDoorsFromEastSideBefore = thirdMaze.getNumberOfDoorsFromSide(Side.EAST);
        int numberOfDoorsFromWestSideBefore = thirdMaze.getNumberOfDoorsFromSide(Side.WEST);
        int numberOfDoorsFromNorthSideBefore = thirdMaze.getNumberOfDoorsFromSide(Side.NORTH);
        int numberOfDoorsFromSouthSideBefore = thirdMaze.getNumberOfDoorsFromSide(Side.SOUTH);

        createMazeAndEmbedDoorUsingAddDoor(thirdMaze);

        int numberOfDoorsFromEastSideAfter = thirdMaze.getNumberOfDoorsFromSide(Side.EAST);
        int numberOfDoorsFromWestSideAfter = thirdMaze.getNumberOfDoorsFromSide(Side.WEST);
        int numberOfDoorsFromNorthSideAfter = thirdMaze.getNumberOfDoorsFromSide(Side.NORTH);
        int numberOfDoorsFromSouthSideAfter = thirdMaze.getNumberOfDoorsFromSide(Side.SOUTH);

        assertTrue(numberOfDoorsFromEastSideBefore < numberOfDoorsFromEastSideAfter);
        assertTrue(numberOfDoorsFromWestSideBefore < numberOfDoorsFromWestSideAfter);
        assertEquals(numberOfDoorsFromNorthSideBefore, numberOfDoorsFromNorthSideAfter);
        assertEquals(numberOfDoorsFromSouthSideBefore, numberOfDoorsFromSouthSideAfter);
    }

    @Test
    void testEmbedDoorInRoomsWithIndexes() {
        Maze maze = new Maze();
        Room firstRoom = new SimpleRoom();
        Room secondRoom = new SimpleRoom();
        Wall commonWall = new SimpleWall();
        firstRoom.setSide(Side.EAST, commonWall);
        secondRoom.setSide(Side.WEST, commonWall);
        maze.addRoom(firstRoom);
        maze.addRoom(secondRoom);

        Door door = new SimpleDoor();
        maze.embedDoorInRoomsWithIndexes(door, 0, 1);
    }

    @ParameterizedTest(name = "#{index} Set Wall from {0} side")
    @MethodSource("sides")
    void testSetWallInRoomWithIndexFromSide(Side side) {
        Maze maze = new Maze();
        Room room = new SimpleRoom();
        Wall wall = new SimpleWall();

        maze.addRoom(room);
        maze.setWallInRoomWithIndexFromSide(wall, 0, side);

        Room modifiedRoom = maze.rooms.get(0);
        assertTrue(modifiedRoom.hasWallFromSide(side));
    }

    private void createMazeAndEmbedDoorUsingAddDoor(Maze maze) {
        Room thirdRoom = new SimpleRoom();
        Room fourRoom = new SimpleRoom();
        Wall commonWall = new SimpleWall();
        thirdRoom.setSide(Side.EAST, commonWall);
        fourRoom.setSide(Side.WEST, commonWall);

        Door door = new SimpleDoor();
        door.embedInRooms(thirdRoom, fourRoom);

        maze.addRoom(thirdRoom);
        maze.addRoom(fourRoom);
    }

    static Stream <Arguments> numberOfWallsAndSides() {
        return Stream.of(
                Arguments.arguments(2, Side.NORTH),
                Arguments.arguments(1, Side.EAST),
                Arguments.arguments(1, Side.WEST),
                Arguments.arguments(0, Side.SOUTH)
        );
    }

    static Stream <Arguments> numberOfDoorsAndSides() {
        return Stream.of(
                Arguments.arguments(0, Side.NORTH),
                Arguments.arguments(1, Side.EAST),
                Arguments.arguments(1, Side.WEST),
                Arguments.arguments(0, Side.SOUTH)
        );
    }

    static Stream <Arguments> sides() {
        return Stream.of(
                Arguments.arguments(Side.NORTH),
                Arguments.arguments(Side.EAST),
                Arguments.arguments(Side.WEST),
                Arguments.arguments(Side.SOUTH)
        );
    }

}
