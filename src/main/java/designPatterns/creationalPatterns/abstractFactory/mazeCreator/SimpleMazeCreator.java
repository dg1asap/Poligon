package designPatterns.creationalPatterns.abstractFactory.mazeCreator;

import designPatterns.creationalPatterns.abstractFactory.mazeFactory.MazeFactory;
import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.utilities.Side;
import mazeGame.wall.Wall;

public class SimpleMazeCreator implements MazeCreator{
    private MazeFactory factory;
    private Maze maze;

    @Override
    public Maze createMaze(MazeFactory factory) {
        setFactory(factory);
        createEmptyMaze();
        createNRooms(2);
        equipFirstRoom();
        equipSecondRoom();
        equipFirstAndSecondRoomWithCommonElements();
        return maze;
    }

    private void setFactory(MazeFactory factory) {
        this.factory = factory;
    }

    private void createEmptyMaze() {
        this.maze = factory.createMaze();
    }

    private void createNRooms(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            Room firstRoom = factory.createRoom();
            maze.addRoom(firstRoom);
        }
    }

    private void equipFirstRoom() {
        Wall northWallOfFirstRoom = factory.createWall();
        Wall westWallOfFirstRoom = factory.createWall();
        Wall southWallOfFirstRoom = factory.createWall();

        maze.setWallInRoomWithIndexFromSide(northWallOfFirstRoom, 0, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(westWallOfFirstRoom, 0, Side.WEST);
        maze.setWallInRoomWithIndexFromSide(southWallOfFirstRoom, 0, Side.SOUTH);
    }

    private void equipSecondRoom() {
        Wall northWallOfSecondRoom = factory.createWall();
        Wall eastWallOfSecondRoom = factory.createWall();
        Wall southWallOfSecondRoom = factory.createWall();

        maze.setWallInRoomWithIndexFromSide(northWallOfSecondRoom, 1, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(eastWallOfSecondRoom, 1, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(southWallOfSecondRoom, 1, Side.SOUTH);
    }

    private void equipFirstAndSecondRoomWithCommonElements() {
        equipFirstAndSecondRoomInCommonWall();
        equipFirstAndSecondRoomInCommonDoor();
    }

    private void equipFirstAndSecondRoomInCommonWall() {
        Wall commonWallOfFirstAndSecondRooms = factory.createWall();
        maze.setWallInRoomWithIndexFromSide(commonWallOfFirstAndSecondRooms, 0, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(commonWallOfFirstAndSecondRooms, 1, Side.WEST);
    }

    private void equipFirstAndSecondRoomInCommonDoor() {
        Door door = factory.createDoor();
        maze.embedDoorInRoomsWithIndexes(door, 0, 1);
    }

}

