package designPatterns.creationalPatterns.factoryMethod.mazeCreator;

import mazeGame.door.Door;
import mazeGame.door.SimpleDoor;
import mazeGame.room.BoomRoom;
import mazeGame.room.Room;
import mazeGame.wall.BoomWall;
import mazeGame.wall.Wall;

public class BoomComplexMazeCreator extends ComplexMazeCreator {
    @Override
    protected Room createRoom() {
        return new BoomRoom();
    }

    @Override
    protected Wall createWall() {
        return new BoomWall();
    }

    @Override
    protected Door createDoor() {
        return new SimpleDoor();
    }
}
