package designPatterns.creationalPatterns.factoryMethod.mazeCreator;

import mazeGame.door.Door;
import mazeGame.door.MagicDoor;
import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import mazeGame.wall.SimpleWall;
import mazeGame.wall.Wall;

public class MagicComplexMazeCreator extends ComplexMazeCreator {
    @Override
    protected Room createRoom() {
        return new SimpleRoom();
    }

    @Override
    protected Wall createWall() {
        return new SimpleWall();
    }

    @Override
    protected Door createDoor() {
        return new MagicDoor();
    }
}
