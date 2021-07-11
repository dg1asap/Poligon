package designPatterns.creationalPatterns.builder.mazeBuilder;

import mazeGame.maze.Maze;
import mazeGame.utilities.Side;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;


public class MazeBuilderTest {
    static StandardMazeBuilder mazeBuilder;

    @BeforeEach
    void creteMaze() {
        mazeBuilder = new StandardMazeBuilder();
        mazeBuilder.buildMaze();
    }

    @Test
    void testGetEmptyMaze() {
        Maze maze = mazeBuilder.getMaze();
        assertEquals(0, maze.getNumberOfRooms());
        assertNumberOfRooms(0);
        assertNumberOfDoors(0);
    }

    @ParameterizedTest(name = "#{index} Add {0} rooms to Maze")
    @ValueSource(ints = {1, 2, 3, 4, 5, 32, 234, 23434, 99999})
    void testGetMazeWithNRoom(int numberOfRooms) {
        buildNRooms(numberOfRooms);
        assertNumberOfRooms(numberOfRooms);
    }

    @ParameterizedTest(name = "#{index} Add {0} doors to Maze")
    @ValueSource(ints = {1, 2, 3, 4, 5, 32, 234, 23434, 99999})
    void testGetMazeWithNDoors(int numberOfDoors) {
        buildNRooms(numberOfDoors + 1);
        buildNCommonWalls(numberOfDoors);
        buildNDoors(numberOfDoors);
        assertNumberOfDoors(numberOfDoors);
    }

    @ParameterizedTest(name = "#{index} Add {0} walls to Maze")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 32, 234, 23434, 99999})
    void testGetMazeWithNWalls(int numberOfWalls) {
        buildNRooms(numberOfWalls / 4 + 3);
        buildNWalls(numberOfWalls);
        assertNumberOfWalls(numberOfWalls);
    }

    private void buildNRooms(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++)
            mazeBuilder.buildRoom();
    }

    private void assertNumberOfRooms(int numberOfRooms) {
        Maze maze = mazeBuilder.getMaze();
        assertEquals(numberOfRooms, maze.getNumberOfRooms());
    }


    private void buildNDoors(int numberOfDoors) {
        for (int i = 0; i < numberOfDoors; i++)
            mazeBuilder.buildDoorBetweenRoomsWithIndexes(i, i+1);
    }

    private void buildNCommonWalls(int numberOfWalls) {
        mazeBuilder.buildCommonWallFromSideOfFirstRoomWithIndex(Side.EAST, 0, 1);
        for (int i = 1; i < numberOfWalls; i++) {
            mazeBuilder.buildCommonWallFromSideOfFirstRoomWithIndex(Side.EAST, i, i - 1);
            mazeBuilder.buildCommonWallFromSideOfFirstRoomWithIndex(Side.WEST, i, i + 1);
        }
        mazeBuilder.buildCommonWallFromSideOfFirstRoomWithIndex(Side.WEST, numberOfWalls, numberOfWalls - 1);
    }

    private void assertNumberOfDoors(int numberOfDoors) {
        Maze maze = mazeBuilder.getMaze();
        assertEquals(numberOfDoors, maze.getNumberOfDoorsFromSide(Side.EAST));
        assertEquals(numberOfDoors, maze.getNumberOfDoorsFromSide(Side.WEST));
    }

    private void buildNWalls(int numberOfWalls) {
        encloseRoomsWithWalls(numberOfWalls);
        encloseOtherRoomsWithSingleWall(numberOfWalls / 4 + numberOfWalls % 4, numberOfWalls / 4);
    }

    private void assertNumberOfWalls(int numberOfWalls) {
        Maze maze = mazeBuilder.getMaze();
        int numberOfWallsFromNorthSide = maze.getNumberOfWallsFromSide(Side.NORTH);
        int numberOfWallsFromEastSide = maze.getNumberOfWallsFromSide(Side.EAST);
        int numberOfWallsFromWestSide = maze.getNumberOfWallsFromSide(Side.WEST);
        int numberOfWallsFromSouthSide = maze.getNumberOfWallsFromSide(Side.SOUTH);
        assertEquals(numberOfWallsFromNorthSide, numberOfWalls / 4);
        assertEquals(numberOfWallsFromEastSide, numberOfWalls / 4);
        assertEquals(numberOfWallsFromWestSide, numberOfWalls / 4);
        assertEquals(numberOfWallsFromSouthSide, (numberOfWalls / 4) + numberOfWalls % 4);
    }

    private void encloseRoomsWithWalls(int numberOfWalls) {
        for (int i = 0; i < numberOfWalls/4; i++) {
            mazeBuilder.buildWallInRoomWithIndexFromSide(i, Side.NORTH);
            mazeBuilder.buildWallInRoomWithIndexFromSide(i, Side.EAST);
            mazeBuilder.buildWallInRoomWithIndexFromSide(i, Side.WEST);
            mazeBuilder.buildWallInRoomWithIndexFromSide(i, Side.SOUTH);
        }
    }

    private void encloseOtherRoomsWithSingleWall(int numberOfWalls, int startingIndex) {
        while (startingIndex < numberOfWalls) {
            mazeBuilder.buildWallInRoomWithIndexFromSide(startingIndex, Side.SOUTH);
            startingIndex++;
        }
    }

}