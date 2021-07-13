package designPatterns.creationalPatterns.builder.mazeDirector;

import designPatterns.creationalPatterns.builder.mazeBuilder.StandardMazeBuilder;

@FunctionalInterface
public interface MazeDirector {
    void constructMaze(StandardMazeBuilder standardMazeBuilder);
}
