package designPatterns.creationalPatterns.factoryMethod.mazeCreator;

import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.utilities.Side;
import mazeGame.wall.Wall;

public abstract class ComplexMazeCreator extends SimpleMazeCreator {
    @Override
    public Maze createMaze() {
        buildNRooms(3);
        equipRooms();
        return maze;
    }

    private void buildNRooms(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++) {
            Room room = createRoom();
            maze.addRoom(room);
        }
    }

    private void equipRooms() {
        equipFirstRoomWithItsOwnElements();
        equipSecondRoomWithItsOwnElements();
        equipThirdRoomWithItsOwnElements();
        equipFirstAndSecondRoomWithCommonElements();
        equipSecondAndThirdRoomWithCommonElements();
    }

    private void equipFirstRoomWithItsOwnElements() {
        Wall northWall = createWall();
        Wall westWall = createWall();
        Wall southWall = createWall();
        maze.setWallInRoomWithIndexFromSide(northWall, 0, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(westWall, 0, Side.WEST);
        maze.setWallInRoomWithIndexFromSide(southWall, 0, Side.SOUTH);
    }

    private void equipSecondRoomWithItsOwnElements() {
        Wall northWall = createWall();
        Wall eastWall = createWall();
        maze.setWallInRoomWithIndexFromSide(northWall, 1, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(eastWall, 1, Side.EAST);
    }

    private void equipThirdRoomWithItsOwnElements() {
        Wall eastWall = createWall();
        Wall westWall = createWall();
        Wall southWall = createWall();
        maze.setWallInRoomWithIndexFromSide(eastWall, 2, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(westWall, 2, Side.WEST);
        maze.setWallInRoomWithIndexFromSide(southWall, 2, Side.SOUTH);
    }

    private void equipFirstAndSecondRoomWithCommonElements() {
        Wall commonWall = createWall();
        Door door = createDoor();
        setCommonWallInFirstAndSecondRoom(commonWall);
        setDoorInFirstAndSecondRoom(door);
    }

    private void equipSecondAndThirdRoomWithCommonElements() {
        Wall commonWall = createWall();
        Door door = createDoor();

        setCommonWallInSecondAndThirdRoom(commonWall);
        setDoorInSecondAndThirdRoom(door);
    }

    private void setCommonWallInFirstAndSecondRoom(Wall commonWall) {
        maze.setWallInRoomWithIndexFromSide(commonWall, 0, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(commonWall, 1, Side.WEST);
    }

    private void setDoorInFirstAndSecondRoom(Door door) {
        maze.embedDoorInRoomsWithIndexes(door, 0, 1);
    }

    private void setCommonWallInSecondAndThirdRoom(Wall commonWall) {
        maze.setWallInRoomWithIndexFromSide(commonWall, 1, Side.SOUTH);
        maze.setWallInRoomWithIndexFromSide(commonWall, 2, Side.NORTH);
    }

    private void setDoorInSecondAndThirdRoom(Door door) {
        maze.embedDoorInRoomsWithIndexes(door, 1, 2);
    }

}
