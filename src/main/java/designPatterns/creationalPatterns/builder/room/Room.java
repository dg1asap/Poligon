package designPatterns.creationalPatterns.builder.room;

import designPatterns.creationalPatterns.builder.utilities.Side;
import designPatterns.creationalPatterns.builder.wall.Wall;

import java.util.HashMap;
import java.util.Map;

public abstract class Room {
    protected Map<Side, Wall> sides = new HashMap<>();

    public void setSide(Side side, Wall wall) {
        sides.put(side, wall);
    }
}
