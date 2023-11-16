package designPatterns.creationalPatterns.abstractFactory.mazeFactory;

import mazeGame.door.Door;
import mazeGame.maze.Maze;
import mazeGame.room.Room;
import mazeGame.wall.Wall;

import java.util.HashMap;
import java.util.Map;
import java.util.function.Supplier;

public class MazeScalableFactory {

    public interface CreateMazeFunction extends Supplier<Maze> {}
    public interface CreateRoomFunction extends Supplier<Room> {}
    public interface CreateWallFunction extends Supplier<Wall> {}
    public interface CreateDoorFunction extends Supplier<Door> {}

    private final Map<String, CreateMazeFunction> createMazeFunction = new HashMap<>();
    private final Map<String, CreateRoomFunction> createRoomFunction = new HashMap<>();
    private final Map<String, CreateWallFunction> createWallFunction = new HashMap<>();
    private final Map<String, CreateDoorFunction> createDoorFunction = new HashMap<>();

    public void registerMaze(String mazeName, CreateMazeFunction function) {
        createMazeFunction.put(mazeName, function);
    }

    public void registerRoom(String roomName, CreateRoomFunction function) {
        createRoomFunction.put(roomName, function);
    }

    public void registerWall(String wallName, CreateWallFunction function) {
        createWallFunction.put(wallName, function);
    }

    public void registerDoor(String doorName, CreateDoorFunction function) {
        createDoorFunction.put(doorName, function);
    }

    public Maze createMaze(String mazeName) {
        CreateMazeFunction creator = createMazeFunction.get(mazeName);
        if (creator != null) {
            return creator.get();
        } else {
            return null;
        }
    }

    public Room createRoom(String roomName) {
        CreateRoomFunction creator = createRoomFunction.get(roomName);
        if (creator != null) {
            return creator.get();
        } else {
            return null;
        }
    }

    public Wall createWall(String wallName) {
        CreateWallFunction creator = createWallFunction.get(wallName);
        if (creator != null) {
            return creator.get();
        } else {
            return null;
        }
    }

    public Door createDoor(String doorName) {
        CreateDoorFunction creator = createDoorFunction.get(doorName);
        if (creator != null) {
            return creator.get();
        } else {
            return null;
        }
    }
}
