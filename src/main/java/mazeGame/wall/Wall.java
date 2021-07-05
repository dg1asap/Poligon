package mazeGame.wall;

import mazeGame.door.Door;

public abstract class Wall {
    protected Door door;

    public void setDoor(Door door) {
        this.door = door;
    }

    public boolean hasDoor() {
        return door != null;
    }

}
