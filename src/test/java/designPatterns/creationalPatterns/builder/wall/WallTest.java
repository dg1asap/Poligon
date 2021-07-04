package designPatterns.creationalPatterns.builder.wall;

import designPatterns.creationalPatterns.builder.door.Door;
import designPatterns.creationalPatterns.builder.door.SimpleDoor;
import designPatterns.creationalPatterns.builder.room.Room;
import designPatterns.creationalPatterns.builder.room.RoomTest;
import designPatterns.creationalPatterns.builder.room.SimpleRoom;
import designPatterns.creationalPatterns.builder.utilities.Side;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WallTest {
    static Room room1;
    static Room room2;
    static Wall commonWall;

    @BeforeAll
    static void initRooms() {
        RoomTest roomTest = new RoomTest();
        room1 = new SimpleRoom();
        room2 = new SimpleRoom();
        roomTest.createFourWallInRoom(room1);
        roomTest.createFourWallInRoom(room2);

        commonWall = new SimpleWall();
        room1.setSide(Side.EAST, commonWall);
        room2.setSide(Side.WEST, commonWall);
    }

    @Test
    void addDoorToWall() {
        Door door = new SimpleDoor(room1, room2);
        commonWall.setDoor(door);
        assertEquals(door, commonWall.door);
    }


}
