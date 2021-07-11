package designPatterns.creationalPatterns.builder.mazeBuilder;

import mazeGame.door.Door;
import mazeGame.door.MagicDoor;

public class MagicMazeBuilder extends StandardMazeBuilder {
    @Override
    public void buildDoorBetweenRoomsWithIndexes(int firstRoomIndex, int secondRoomIndex) {
        Door door = new MagicDoor();
        maze.embedDoorInRoomsWithIndexes(door, firstRoomIndex, secondRoomIndex);
    }

}