package designPatterns.creationalPatterns.builder.room;

import com.sun.jdi.event.StepEvent;
import designPatterns.creationalPatterns.builder.utilities.Side;
import designPatterns.creationalPatterns.builder.wall.SimpleWall;
import designPatterns.creationalPatterns.builder.wall.Wall;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class RoomTest {
    @Test
    void addOneWallPerSide() {
        Room room = new SimpleRoom();
        createFourWallInRoom(room);
        assertNWallInRoom(4, room);
    }

    @ParameterizedTest(name =  "#{index} Add {0} Walls per {1}Side")
    @MethodSource("numberOfWallAndSide")
    void addNWallPerOneSide(int numberOfWall, Side side) {
        Room room = new SimpleRoom();
        for (int i = 0; i < numberOfWall; i++) {
            Wall wall = new SimpleWall();
            room.setSide(side, wall);
        }

        assertNWallInRoom(1, room);
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

    private void assertNWallInRoom(int numberOfWall, Room room) {
        int numberOfWalls = room.sides.size();
        assertEquals(numberOfWalls, numberOfWall);
    }

    static Stream <Arguments> numberOfWallAndSide() {
        return Stream.of(
                Arguments.arguments(1, Side.EAST),
                Arguments.arguments(2, Side.EAST),
                Arguments.arguments(3, Side.WEST),
                Arguments.arguments(4, Side.SOUTH),
                Arguments.arguments(5, Side.EAST),
                Arguments.arguments(8, Side.NORTH),
                Arguments.arguments(84, Side.NORTH)
        );
    }

}