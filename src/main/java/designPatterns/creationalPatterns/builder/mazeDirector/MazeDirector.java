package designPatterns.creationalPatterns.builder.mazeDirector;

import designPatterns.creationalPatterns.builder.mazeBuilder.StandardMazeBuilder;

public interface MazeDirector {
    void createMaze(StandardMazeBuilder standardMazeBuilder);
}
