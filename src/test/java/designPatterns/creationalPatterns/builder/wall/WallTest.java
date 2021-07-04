package designPatterns.creationalPatterns.builder.wall;

import designPatterns.creationalPatterns.builder.door.Door;
import designPatterns.creationalPatterns.builder.door.SimpleDoor;
import designPatterns.creationalPatterns.builder.room.Room;
import designPatterns.creationalPatterns.builder.room.SimpleRoom;
import designPatterns.creationalPatterns.builder.utilities.Side;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WallTest {
    static Room firstRoom;
    static Room secondRoom;
    static Wall commonWall;

    @BeforeAll
    static void initRooms() {
        firstRoom = new SimpleRoom();
        secondRoom = new SimpleRoom();
        createCommonWallBetweenFirstAndSecondRoom();
        fillRemainingSidesOfFirstRoomWithWalls();
        fillRemainingSidesOfSecondRoomWithWalls();
    }

    private static void createCommonWallBetweenFirstAndSecondRoom() {
        commonWall = new SimpleWall();
        firstRoom.setSide(Side.EAST, commonWall);
        secondRoom.setSide(Side.WEST, commonWall);
    }

    private static void fillRemainingSidesOfFirstRoomWithWalls() {
        firstRoom.setSide(Side.NORTH, new SimpleWall());
        firstRoom.setSide(Side.WEST, new SimpleWall());
        firstRoom.setSide(Side.SOUTH, new SimpleWall());
    }

    private static void fillRemainingSidesOfSecondRoomWithWalls() {
        secondRoom.setSide(Side.NORTH, new SimpleWall());
        secondRoom.setSide(Side.EAST, new SimpleWall());
        secondRoom.setSide(Side.SOUTH, new SimpleWall());
    }

    @Test
    void addDoorToWall() {
        Door door = new SimpleDoor(firstRoom, secondRoom);
        commonWall.setDoor(door);
        assertEquals(door, commonWall.door);
    }


}
