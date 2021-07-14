package designPatterns.creationalPatterns.builder.mazeDirector;

import designPatterns.creationalPatterns.builder.mazeBuilder.StandardMazeBuilder;
import mazeGame.utilities.Side;

public class ComplexMazeDirector implements MazeDirector {
    StandardMazeBuilder builder;

    @Override
    public void constructMaze(StandardMazeBuilder builder) {
        setBuilder(builder);
        buildMaze();
        buildNRooms(3);
        equipRooms();
    }

    private void setBuilder(StandardMazeBuilder builder) {
        this.builder = builder;
    }

    private void buildMaze() {
        builder.buildMaze();
    }

    private void buildNRooms(int numberOfRooms) {
        for (int i = 0; i < numberOfRooms; i++)
            builder.buildRoom();
    }

    private void equipRooms() {
        equipFirstRoomWithItsOwnElements();
        equipSecondRoomWithItsOwnElements();
        equipThirdRoomWithItsOwnElements();
        equipFirstAndSecondRoomWithCommonElements();
        equipSecondAndThirdRoomWithCommonElements();
    }

    private void equipFirstRoomWithItsOwnElements() {
        builder.buildWallInRoomWithIndexFromSide(0, Side.NORTH);
        builder.buildWallInRoomWithIndexFromSide(0, Side.WEST);
        builder.buildWallInRoomWithIndexFromSide(0, Side.SOUTH);
    }

    private void equipSecondRoomWithItsOwnElements() {
        builder.buildWallInRoomWithIndexFromSide(1, Side.NORTH);
        builder.buildWallInRoomWithIndexFromSide(1, Side.EAST);
    }

    private void equipThirdRoomWithItsOwnElements() {
        builder.buildWallInRoomWithIndexFromSide(2, Side.EAST);
        builder.buildWallInRoomWithIndexFromSide(2, Side.WEST);
        builder.buildWallInRoomWithIndexFromSide(2, Side.SOUTH);
    }

    private void equipFirstAndSecondRoomWithCommonElements() {
        builder.buildCommonWallFromSideOfFirstRoomWithIndex(Side.EAST, 0, 1);
        builder.buildDoorBetweenRoomsWithIndexes(0, 1);
    }

    private void equipSecondAndThirdRoomWithCommonElements() {
        builder.buildCommonWallFromSideOfFirstRoomWithIndex(Side.SOUTH, 1, 2);
        builder.buildDoorBetweenRoomsWithIndexes(1, 2);
    }

}
