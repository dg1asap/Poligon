package mazeGame.utilities;

public enum Side {
    NORTH {
        @Override
        public Side getOppositeSide() {
            return SOUTH;
        }
    },
    EAST {
        @Override
        public Side getOppositeSide() {
            return WEST;
        }
    },
    WEST {
        @Override
        public Side getOppositeSide() {
            return EAST;
        }
    },
    SOUTH {
        @Override
        public Side getOppositeSide() {
            return NORTH;
        }
    };

    public abstract Side getOppositeSide();
}
