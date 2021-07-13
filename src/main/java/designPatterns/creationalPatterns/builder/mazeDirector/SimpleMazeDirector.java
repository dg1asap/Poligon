package designPatterns.creationalPatterns.builder.mazeDirector;

import designPatterns.creationalPatterns.builder.mazeBuilder.StandardMazeBuilder;
import mazeGame.utilities.Side;

public class SimpleMazeDirector implements MazeDirector {
    @Override
    public void constructMaze(StandardMazeBuilder builder) {
        builder.buildMaze();

        builder.buildRoom();
        builder.buildWallInRoomWithIndexFromSide(0, Side.NORTH);
        builder.buildWallInRoomWithIndexFromSide(0, Side.WEST);
        builder.buildWallInRoomWithIndexFromSide(0, Side.SOUTH);

        builder.buildRoom();
        builder.buildWallInRoomWithIndexFromSide(1, Side.NORTH);
        builder.buildWallInRoomWithIndexFromSide(1, Side.EAST);
        builder.buildWallInRoomWithIndexFromSide(1, Side.SOUTH);

        builder.buildCommonWallFromSideOfFirstRoomWithIndex(Side.EAST, 0, 1);
        builder.buildDoorBetweenRoomsWithIndexes(0, 1);
    }
}
