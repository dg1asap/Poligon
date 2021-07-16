package mazeGame.room;

import mazeGame.door.Door;
import mazeGame.door.SimpleDoor;
import mazeGame.utilities.Side;
import mazeGame.wall.SimpleWall;
import mazeGame.wall.Wall;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    static Room room;

    @BeforeEach
    void createRoom() {
        room = new SimpleRoom();
    }

    @Test
    void testAddOneWallPerSide() {
        createFourWallInRoom(room);
        assertNWallInRoom(4, room);
    }

    @ParameterizedTest(name =  "#{index} Add {0} Walls per {1}Side")
    @MethodSource("numberOfWallsAndSide")
    void testAddNWallPerOneSide(int numberOfWall, Side side) {
        addNWallPerOneSideToRoom(numberOfWall, side, room);
        assertNWallInRoom(1, room);
    }

    @Test
    void testAddWallToMoreThanOneSide() {
        addNWallPerOneSideToRoom(3, Side.NORTH, room);
        addNWallPerOneSideToRoom(7, Side.EAST, room);
        addNWallPerOneSideToRoom(4, Side.NORTH, room);
        addNWallPerOneSideToRoom(5, Side.NORTH, room);
        addNWallPerOneSideToRoom(1, Side.WEST, room);
        assertNWallInRoom(3, room);
    }

    @ParameterizedTest(name = "{index} has wall from {0} side")
    @MethodSource("side")
    void testHasWallFromSide(Side side) {
        room.setSide(side, new SimpleWall());
        assertTrue(room.hasWallFromSide(side));
    }

    @ParameterizedTest(name = "{index} has door from {0} side")
    @MethodSource("side")
    void testHasDoorFromSide(Side side) {
        createDefectiveStandardSimpleMazeWithDoorFromSide(side);
        assertTrue(room.hasDoorFromSide(side));
    }

    @Test
    void testGetNumberOfDoors() {
        createDefectiveStandardSimpleMazeWithDoorFromSide(Side.SOUTH);
        assertEquals(room.getNumberOfDoors(), 1);
    }

    @Test
    void testHasCommonWall() {
        Room firstRoom = new SimpleRoom();
        Room secondRoom = new SimpleRoom();
        createCommonWallAndDoorFor(firstRoom, secondRoom);
        assertTrue(firstRoom.hasCommonWall(secondRoom));
        assertFalse(firstRoom.hasCommonWall(room));
    }

    @Test
    void testEmbedDoorInCommonWall() {
        Room firstRoom = new SimpleRoom();
        Room secondRoom = new SimpleRoom();
        createCommonWallFor(firstRoom, secondRoom);
        Door door = new SimpleDoor();
        door.embedInRooms(firstRoom, secondRoom);

        firstRoom.embedDoorInCommonWall(door, secondRoom);

        assertTrue(firstRoom.hasCommonWall(secondRoom));
        assertFalse(firstRoom.hasCommonWall(room));
    }

    @Test
    void testCloneRoom() throws CloneNotSupportedException {
        Room room = new SimpleRoom();
        Room clonedRoom = (Room) room.clone();
        assertEquals(room.getClass(), clonedRoom.getClass());
    }

    private void createDefectiveStandardSimpleMazeWithDoorFromSide(Side side) {
        Room firstRoom = new SimpleRoom();
        Room secondRoom = new SimpleRoom();
        Door door = new SimpleDoor();
        door.embedInRooms(firstRoom, secondRoom);

        Wall wall = new SimpleWall();
        wall.setDoor(door);
        room.setSide(side, wall);
    }

    private void createFourWallInRoom(Room room) {
        Wall NorthWall = new SimpleWall();
        Wall EastWall = new SimpleWall();
        Wall WestWall = new SimpleWall();
        Wall SouthWall = new SimpleWall();

        room.setSide(Side.NORTH, NorthWall);
        room.setSide(Side.EAST, EastWall);
        room.setSide(Side.WEST, WestWall);
        room.setSide(Side.SOUTH, SouthWall);
    }

    private void addNWallPerOneSideToRoom(int numberOfWall, Side side, Room room) {
        for (int i = 0; i < numberOfWall; i++) {
            Wall wall = new SimpleWall();
            room.setSide(side, wall);
        }
    }

    private void assertNWallInRoom(int numberOfWall, Room room) {
        int numberOfWalls = room.sides.size();
        assertEquals(numberOfWalls, numberOfWall);
    }

    private void createCommonWallAndDoorFor(Room firstRoom, Room secondRoom) {
        Door door = new SimpleDoor();
        door.embedInRooms(firstRoom, secondRoom);

        Wall commonWall = new SimpleWall();
        commonWall.setDoor(door);
        firstRoom.setSide(Side.EAST, commonWall);
        secondRoom.setSide(Side.WEST, commonWall);
    }

    private void createCommonWallFor(Room firstRoom, Room secondRoom) {
        Wall commonWall = new SimpleWall();
        firstRoom.setSide(Side.EAST, commonWall);
        secondRoom.setSide(Side.WEST, commonWall);
    }

    static Stream <Arguments> numberOfWallsAndSide() {
        return Stream.of(
                Arguments.arguments(1, Side.SOUTH),
                Arguments.arguments(2, Side.EAST),
                Arguments.arguments(3, Side.WEST),
                Arguments.arguments(4, Side.SOUTH),
                Arguments.arguments(5, Side.EAST),
                Arguments.arguments(8, Side.NORTH),
                Arguments.arguments(84, Side.NORTH)
        );
    }

    static Stream <Arguments> side() {
        return Stream.of(
                Arguments.arguments(Side.NORTH),
                Arguments.arguments(Side.EAST),
                Arguments.arguments(Side.WEST),
                Arguments.arguments(Side.SOUTH)
        );
    }

}
