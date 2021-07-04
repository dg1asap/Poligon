package designPatterns.creationalPatterns.builder;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class MazeTest {
    @BeforeAll
    static void createMaze() {
        Maze maze = new Maze();
    }

    @Test
    void addSimpleRoomsToMaze() {
        SimpleRoom simpleRoom1 = new SimpleRoom();
        SimpleRoom simpleRoom2 = new SimpleRoom();
        maze.addRoom(simpleRoom1);
        maze.addRoom(simpleRoom2);
    }
}
