package utilz;

import static utilz.Constants.GameConstants.SCALE;

public class Constants {

    public static class Entities {

        public static class StickConstants {

            public static final int HORIZONTAL = 0;
            public static final int VERTICAL = 1;

            public static final int S_LENGTH_DEFAULT_SIZE = 500;
            public static final int S_WIDTH_DEFAULT_SIZE = 20;

            public static final int S_LENGTH_SIZE = (int) (S_LENGTH_DEFAULT_SIZE * SCALE);
            public static final int S_WIDTH_SIZE = (int) (S_WIDTH_DEFAULT_SIZE * SCALE);
        }
    }

    public static class GameConstants {

        public static final float SCALE = 1.0f;
        public static final int GAME_WIDTH = (int) (1366 * SCALE);
        public static final int GAME_HEIGHT = (int) (768 * SCALE);
    }
}
