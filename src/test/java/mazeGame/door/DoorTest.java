package mazeGame.door;

import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class DoorTest {
    @Test
    void constructionTest() {
        Room firstRoom = new SimpleRoom();
        Room secondRoom = new SimpleRoom();
        Door door = new SimpleDoor(firstRoom, secondRoom);
        assertEquals(firstRoom, door.firstRoom);
        assertEquals(secondRoom, door.secondRoom);
    }

}
