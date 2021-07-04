package designPatterns.creationalPatterns.builder.wall;

import designPatterns.creationalPatterns.builder.door.Door;

public abstract class Wall {
    protected Door door;

    public void setDoor(Door door) {
        this.door = door;
    }
}
