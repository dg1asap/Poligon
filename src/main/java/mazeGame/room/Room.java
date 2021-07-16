package mazeGame.room;

import mazeGame.door.Door;
import mazeGame.utilities.Side;
import mazeGame.wall.Wall;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;

public abstract class Room implements Cloneable {
    protected Map<Side, Wall> sides = new HashMap<>();

    public Room() {}

    public Room(Room room) {
        if (!room.sides.isEmpty()) {
            room.sides.forEach(this::tryAddFromSideCloneOfWall);
        }
    }

    public void setSide(Side side, Wall wall) {
        sides.put(side, wall);
    }

    public boolean hasWallFromSide(Side side) {
        return sides.containsKey(side);
    }

    public boolean hasDoorFromSide(Side side) {
        if (hasWallFromSide(side)) {
            Wall wall = sides.get(side);
            return wall.hasDoor();
        }
        return false;
    }

    public int getNumberOfDoors() {
        AtomicInteger numberOfDoors = new AtomicInteger(0);
        sides.forEach((side, wall) -> countNumberOfDoorsOnSide(numberOfDoors, side));
        return numberOfDoors.intValue();
    }

    public void countNumberOfDoorsOnSide(AtomicInteger numberOfDoors, Side side) {
        if (hasDoorFromSide(side))
            numberOfDoors.set(numberOfDoors.incrementAndGet());
    }

    public boolean hasCommonWall(Room compareRoom) {
        for (Wall comparedWall : compareRoom.sides.values()) {
            if (hasWall(comparedWall)) {
                return true;
            }
        }
        return false;
    }

    public void embedDoorInCommonWall(Door door, Room oppositeRoom) {
        for (Wall comparedWall : oppositeRoom.sides.values()) {
            embedDoorIfIsCommonWall(door, comparedWall);
        }
    }

    public abstract Object clone() throws CloneNotSupportedException;

    private void tryAddFromSideCloneOfWall(Side side, Wall wall) {
        try {
            addFromSideCloneOfWallFormSide(side, wall);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void addFromSideCloneOfWallFormSide(Side side, Wall wall) throws CloneNotSupportedException{
        Wall clonedWall = (Wall) wall.clone();
        this.sides.put(side, clonedWall);
    }

    private boolean hasWall(Wall comparedWall) {
        for (Wall wall : sides.values()) {
            if (wall.equals(comparedWall))
                return true;
        }
        return false;
    }

    private void embedDoorIfIsCommonWall(Door door, Wall commonWall) {
        if (hasWall(commonWall))
            commonWall.setDoor(door);
    }


}
