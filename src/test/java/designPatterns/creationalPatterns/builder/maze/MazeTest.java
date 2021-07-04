package designPatterns.creationalPatterns.builder.maze;

import designPatterns.creationalPatterns.builder.room.SimpleRoom;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MazeTest {
    @BeforeAll
    static void createWithTwoSimpleMaze() {
        Maze maze = new Maze();
        addTwoSimpleRoomsToMaze(maze);
    }

    static void addTwoSimpleRoomsToMaze(Maze maze) {
        SimpleRoom simpleRoom1 = new SimpleRoom();
        SimpleRoom simpleRoom2 = new SimpleRoom();
        maze.addRoom(simpleRoom1);
        maze.addRoom(simpleRoom2);
    }

    @Test
    void test() {

    }
}
