package designPatterns.creationalPatterns.abstractFactory.mazeFactory;

import mazeGame.door.Door;
import mazeGame.door.MagicDoor;
import mazeGame.door.SimpleDoor;
import mazeGame.room.BoomRoom;
import mazeGame.room.Room;
import mazeGame.room.SimpleRoom;
import mazeGame.wall.BoomWall;
import mazeGame.wall.SimpleWall;
import mazeGame.wall.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MazeScalableFactoryTest {

    private static MazeScalableFactory mazeScalableFactory;

    @BeforeAll
    static void setupScalableFactory() {
        mazeScalableFactory = new MazeScalableFactory();

        MazeFactory standardMazeFactory = new StandardMazeFactory();
        mazeScalableFactory.registerMaze("simpleMaze", standardMazeFactory::createMaze);
        mazeScalableFactory.registerRoom("simpleRoom", standardMazeFactory::createRoom);
        mazeScalableFactory.registerWall("simpleWall", standardMazeFactory::createWall);
        mazeScalableFactory.registerDoor("simpleDoor", standardMazeFactory::createDoor);

        MazeFactory magicMazeFactory = new MagicMazeFactory();
        mazeScalableFactory.registerMaze("magicMaze", magicMazeFactory::createMaze);
        mazeScalableFactory.registerRoom("magicRoom", magicMazeFactory::createRoom);
        mazeScalableFactory.registerWall("magicWall", magicMazeFactory::createWall);
        mazeScalableFactory.registerDoor("magicDoor", magicMazeFactory::createDoor);

        MazeFactory boomMazeFactory = new BoomMazeFactory();
        mazeScalableFactory.registerMaze("boomMaze", boomMazeFactory::createMaze);
        mazeScalableFactory.registerRoom("boomRoom", boomMazeFactory::createRoom);
        mazeScalableFactory.registerWall("boomWall", boomMazeFactory::createWall);
        mazeScalableFactory.registerDoor("boomDoor", boomMazeFactory::createDoor);
    }

    @Test
    void testCreate() {
        // when
        Room simpleRoom = mazeScalableFactory.createRoom("simpleRoom");
        Room boomRoom = mazeScalableFactory.createRoom("boomRoom");

        Wall simpleWall = mazeScalableFactory.createWall("simpleWall");
        Wall boomWall = mazeScalableFactory.createWall("boomWall");

        Door simpleDoor = mazeScalableFactory.createDoor("simpleDoor");
        Door magicDoor = mazeScalableFactory.createDoor("magicDoor");

        // then
        Assertions.assertTrue(simpleRoom instanceof SimpleRoom);
        Assertions.assertTrue(boomRoom instanceof BoomRoom);

        Assertions.assertTrue(simpleWall instanceof SimpleWall);
        Assertions.assertTrue(boomWall instanceof BoomWall);

        Assertions.assertTrue(simpleDoor instanceof SimpleDoor);
        Assertions.assertTrue(magicDoor instanceof MagicDoor);
    }
}
