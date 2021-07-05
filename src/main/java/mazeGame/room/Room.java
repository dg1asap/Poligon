package mazeGame.room;

import mazeGame.utilities.Side;
import mazeGame.wall.Wall;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {
    protected Map<Side, Wall> sides = new HashMap<>();

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

}
