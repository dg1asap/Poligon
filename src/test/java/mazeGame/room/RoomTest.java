package mazeGame.room;

import mazeGame.utilities.Side;
import mazeGame.wall.SimpleWall;
import mazeGame.wall.Wall;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    @Test
    void testAddOneWallPerSide() {
        Room room = new SimpleRoom();
        createFourWallInRoom(room);
        assertNWallInRoom(4, room);
    }

    @ParameterizedTest(name =  "#{index} Add {0} Walls per {1}Side")
    @MethodSource("numberOfWallsAndSide")
    void testAddNWallPerOneSide(int numberOfWall, Side side) {
        Room room = new SimpleRoom();
        addNWallPerOneSideToRoom(numberOfWall, side, room);
        assertNWallInRoom(1, room);
    }

    @Test
    void testAddWallToMoreThanOneSide() {
        Room room = new SimpleRoom();
        addNWallPerOneSideToRoom(3, Side.NORTH, room);
        addNWallPerOneSideToRoom(7, Side.EAST, room);
        addNWallPerOneSideToRoom(4, Side.NORTH, room);
        addNWallPerOneSideToRoom(5, Side.NORTH, room);
        addNWallPerOneSideToRoom(1, Side.WEST, room);
        assertNWallInRoom(3, room);
    }

    public void createFourWallInRoom(Room room) {
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

}
