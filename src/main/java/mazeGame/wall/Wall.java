package mazeGame.wall;

import mazeGame.door.Door;

public abstract class Wall implements Cloneable {
    protected Door door;

    public Wall() {}

    public Wall(Wall wall) {
        if (wall.hasDoor()) {
            trySetCloneAttributesFromWall(wall);
        }
    }

    public void setDoor(Door door) {
        this.door = door;
    }

    public boolean hasDoor() {
        return door != null;
    }

    public abstract Object clone() throws CloneNotSupportedException;

    private void trySetCloneAttributesFromWall(Wall wall) {
        try {
            setCloneAttributesFromWall(wall);
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    private void setCloneAttributesFromWall(Wall wall) throws CloneNotSupportedException {
        this.door = (Door) wall.door.clone();
    }


}
