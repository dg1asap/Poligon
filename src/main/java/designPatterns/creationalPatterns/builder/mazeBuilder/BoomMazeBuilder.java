package designPatterns.creationalPatterns.builder.mazeBuilder;

import mazeGame.room.BoomRoom;
import mazeGame.room.Room;
import mazeGame.utilities.Side;
import mazeGame.wall.BoomWall;
import mazeGame.wall.Wall;

public class BoomMazeBuilder extends StandardMazeBuilder{

    @Override
    public void buildRoom() {
        Room room = new BoomRoom();
        maze.addRoom(room);
    }

    @Override
    public void buildWallInRoomWithIndexFromSide(int roomIndex, Side side) {
        Wall wall = new BoomWall();
        maze.setWallInRoomWithIndexFromSide(wall, roomIndex, side);
    }

    @Override
    public void buildCommonWallFromSideOfFirstRoomWithIndex(Side side, int firstRoomIndex, int secondRoomIndex) {
        Wall wall = new BoomWall();
        maze.setWallInRoomWithIndexFromSide(wall, firstRoomIndex, side);
        maze.setWallInRoomWithIndexFromSide(wall, secondRoomIndex, side.getOppositeSide());
    }


}