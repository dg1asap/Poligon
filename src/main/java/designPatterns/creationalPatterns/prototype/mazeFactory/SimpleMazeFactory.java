package designPatterns.creationalPatterns.prototype.mazeFactory;

import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.utilities.Side;
import mazeGame.wall.Wall;

public class SimpleMazeFactory extends MazeFactory {
    private Maze maze;

    SimpleMazeFactory(Room room, Wall wall, Door door) {
        super(room, wall, door);
    }

    @Override
    public Maze createMaze() throws CloneNotSupportedException {
        createEmptyMaze();
        createRooms();
        equipRooms();
        return maze;
    }

    private void createEmptyMaze() {
        this.maze = new Maze();
    }

    private void createRooms() throws CloneNotSupportedException {
        Room firstRoom = (Room) prototypeRoom.clone();
        Room secondRoom = (Room) prototypeRoom.clone();
        maze.addRoom(firstRoom);
        maze.addRoom(secondRoom);
    }

    private void equipRooms() throws CloneNotSupportedException {
        equipFirstRoomWithItsOwnElements();
        equipSecondRoomWithItsOwnElements();
        equipFirstAndSecondRoomWithCommonElements();
    }

    private void equipFirstRoomWithItsOwnElements() throws CloneNotSupportedException {
        Wall northWall = (Wall) prototypeWall.clone();
        Wall westWall = (Wall) prototypeWall.clone();
        Wall southWall = (Wall) prototypeWall.clone();
        maze.setWallInRoomWithIndexFromSide(northWall, 0, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(westWall, 0, Side.WEST);
        maze.setWallInRoomWithIndexFromSide(southWall, 0, Side.SOUTH);
    }

    private void equipSecondRoomWithItsOwnElements() throws CloneNotSupportedException {
        Wall northWall = (Wall) prototypeWall.clone();
        Wall eastWall = (Wall) prototypeWall.clone();
        Wall southWall = (Wall) prototypeWall.clone();
        maze.setWallInRoomWithIndexFromSide(northWall, 1, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(eastWall, 1, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(southWall, 1, Side.SOUTH);
    }

    private void equipFirstAndSecondRoomWithCommonElements() throws CloneNotSupportedException {
        equipFirstAndSecondRoomInCommonWall();
        equipFirstAndSecondRoomInDoor();
    }

    private void equipFirstAndSecondRoomInCommonWall() throws CloneNotSupportedException {
        Wall commonWall = (Wall) prototypeWall.clone();
        maze.setWallInRoomWithIndexFromSide(commonWall, 0, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(commonWall, 1, Side.WEST);
    }

    private void equipFirstAndSecondRoomInDoor() throws CloneNotSupportedException {
        Door door = (Door) prototypeDoor.clone();
        maze.embedDoorInRoomsWithIndexes(door, 0, 1);
    }

}
