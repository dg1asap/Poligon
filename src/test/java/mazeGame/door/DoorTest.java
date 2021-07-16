package mazeGame.door;

import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoorTest {
    static Door door;
    static Room firstRoom;
    static Room secondRoom;

    @BeforeAll
    static void createAndEmbedDoorInTwoRooms() {
        firstRoom = new SimpleRoom();
        secondRoom = new SimpleRoom();
        door = new SimpleDoor();
        door.embedInRooms(firstRoom, secondRoom);
    }

    @Test
    void testIsInRoom() {
        Room roomWithoutDoors = new SimpleRoom();

        assertTrue(door.isInRoom(firstRoom));
        assertTrue(door.isInRoom(secondRoom));
        assertFalse(door.isInRoom(roomWithoutDoors));
    }

    @Test
    void testCloneDoor() throws CloneNotSupportedException {
        Door door = new SimpleDoor();
        Door clonedDoor = (Door) door.clone();
        assertEquals(door.getClass(), clonedDoor.getClass());
    }

    @Test
    void testDoorIsEmbed() {
        assertTrue(door.isEmbed());
    }

}
