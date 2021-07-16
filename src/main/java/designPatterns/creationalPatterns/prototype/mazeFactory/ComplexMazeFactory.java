package designPatterns.creationalPatterns.prototype.mazeFactory;

import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.utilities.Side;
import mazeGame.wall.Wall;

public class ComplexMazeFactory extends MazeFactory {
    private Maze maze;

    ComplexMazeFactory(Room room, Wall wall, Door door) {
        super(room, wall, door);
    }

    @Override
    public Maze createMaze() throws CloneNotSupportedException {
        createEmptyMaze();
        createNRooms(3);
        equipRooms();
        return maze;
    }

    private void createEmptyMaze() {
        this.maze = new Maze();
    }

    private void createNRooms(int numberOfRooms) throws CloneNotSupportedException {
        for (int i = 0; i < numberOfRooms; i++) {
            Room room = (Room) prototypeRoom.clone();
            maze.addRoom(room);
        }
    }

    private void equipRooms() throws CloneNotSupportedException {
        equipFirstRoomWithItsOwnElements();
        equipSecondRoomWithItsOwnElements();
        equipThirdRoomWithItsOwnElements();
        equipFirstAndSecondRoomWithCommonElements();
        equipSecondAndThirdRoomWithCommonElements();
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
        maze.setWallInRoomWithIndexFromSide(northWall, 1, Side.NORTH);
        maze.setWallInRoomWithIndexFromSide(eastWall, 1, Side.EAST);
    }

    private void equipThirdRoomWithItsOwnElements() throws CloneNotSupportedException {
        Wall eastWall = (Wall) prototypeWall.clone();
        Wall westWall = (Wall) prototypeWall.clone();
        Wall southWall = (Wall) prototypeWall.clone();
        maze.setWallInRoomWithIndexFromSide(eastWall, 2, Side.EAST);
        maze.setWallInRoomWithIndexFromSide(westWall, 2, Side.WEST);
        maze.setWallInRoomWithIndexFromSide(southWall, 2, Side.SOUTH);
    }

    private void equipFirstAndSecondRoomWithCommonElements() throws CloneNotSupportedException {
        equipFirstAndSecondRoomInCommonWall();
        equipFirstAndSecondRoomInDoor();
    }

    private void equipSecondAndThirdRoomWithCommonElements() throws CloneNotSupportedException {
        equipSecondAndThirdRoomInCommonWall();
        equipSecondAndThirdRoomInDoor();
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

    private void equipSecondAndThirdRoomInCommonWall() throws CloneNotSupportedException {
        Wall commonWall = (Wall) prototypeWall.clone();
        maze.setWallInRoomWithIndexFromSide(commonWall, 1, Side.SOUTH);
        maze.setWallInRoomWithIndexFromSide(commonWall, 2, Side.NORTH);
    }

    private void equipSecondAndThirdRoomInDoor() throws CloneNotSupportedException {
        Door door = (Door) prototypeDoor.clone();
        maze.embedDoorInRoomsWithIndexes(door, 1, 2);
    }
}
