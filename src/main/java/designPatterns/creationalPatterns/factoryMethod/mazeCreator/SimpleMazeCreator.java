package designPatterns.creationalPatterns.factoryMethod.mazeCreator;

import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.utilities.Side;
import mazeGame.wall.Wall;

public abstract class SimpleMazeCreator {
    Maze maze = new Maze();

    public Maze createMaze() {
        buildNRooms(2);
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
        equipFirstAndSecondRoomWithCommonElements();
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
        Wall southWall = createWall();
        maze.setWallInRoomWithIndexFromSide(northWall, 1, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(eastWall, 1, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(southWall, 1, Side.SOUTH);
    }

    private void equipFirstAndSecondRoomWithCommonElements() {
        createAndSetCommonWall();
        createAndEmbedDoorInMaze();
    }

    private void createAndSetCommonWall() {
        Wall commonWall = createWall();
        maze.setWallInRoomWithIndexFromSide(commonWall, 0, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(commonWall, 1, Side.WEST);
    }

    private void createAndEmbedDoorInMaze() {
        Door door = createDoor();
        maze.embedDoorInRoomsWithIndexes(door, 0, 1);
    }

    protected abstract Room createRoom();

    protected abstract Wall createWall();

    protected abstract Door createDoor();

}
