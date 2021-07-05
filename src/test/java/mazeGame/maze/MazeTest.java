package mazeGame.maze;

import mazeGame.door.SimpleDoor;
import mazeGame.room.SimpleRoom;
import mazeGame.utilities.Side;
import mazeGame.wall.SimpleWall;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MazeTest {
    private static Maze maze;

    @BeforeAll
    static void createWithTwoSimpleMaze() {
        maze = new Maze();
        createDefectiveSimpleStandardMaze(maze);
    }

    static void createDefectiveSimpleStandardMaze(Maze maze) {
        SimpleRoom simpleRoom1 = new SimpleRoom();
        SimpleRoom simpleRoom2 = new SimpleRoom();

        SimpleDoor simpleDoor = new SimpleDoor(simpleRoom1, simpleRoom2);
        SimpleWall commonWall = new SimpleWall();
        commonWall.setDoor(simpleDoor);
        simpleRoom1.setSide(Side.EAST, commonWall);
        simpleRoom2.setSide(Side.WEST, commonWall);

        simpleRoom1.setSide(Side.NORTH, new SimpleWall());
        simpleRoom2.setSide(Side.NORTH, new SimpleWall());

        maze.addRoom(simpleRoom1);
        maze.addRoom(simpleRoom2);
    }

    @Test
    void testNumberOfRooms() {
        int numberOfRoomsInMaze = maze.getNumberOfRooms();
        assertEquals(numberOfRoomsInMaze, 2);
    }

    @ParameterizedTest(name = "#{index} {0} walls from site {1}")
    @MethodSource("numberOfWallsAndSide")
    void testNumberOfWallsFromSide(int expectedNumberOfWalls, Side side) {
        int actualNumberOfWalls = maze.getNumberOfWallsFromSide(side);
        assertEquals(expectedNumberOfWalls, actualNumberOfWalls);
    }

    @ParameterizedTest(name = "#{index} {0} doors form site {1}")
    @MethodSource("numberOfDoorsAndSide")
    void testNumberOfDoorFromSide(int expectedNumberOfDoor, Side side) {
        int actualNumberOfDoors = maze.getNumberOfDoorsFromSide(side);
        assertEquals(expectedNumberOfDoor, actualNumberOfDoors);
    }

    static Stream <Arguments> numberOfWallsAndSide() {
        return Stream.of(
                Arguments.arguments(2, Side.NORTH),
                Arguments.arguments(1, Side.EAST),
                Arguments.arguments(1, Side.WEST),
                Arguments.arguments(0, Side.SOUTH)
        );
    }

    static Stream <Arguments> numberOfDoorsAndSide() {
        return Stream.of(
                Arguments.arguments(0, Side.NORTH),
                Arguments.arguments(1, Side.EAST),
                Arguments.arguments(1, Side.WEST),
                Arguments.arguments(0, Side.SOUTH)
        );
    }



}
