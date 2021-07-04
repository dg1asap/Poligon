package mazeGame.wall;

import mazeGame.door.Door;
import mazeGame.door.SimpleDoor;
import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import mazeGame.utilities.Side;
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
