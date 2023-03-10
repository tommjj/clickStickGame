package utilz;

import static utilz.Constants.GameConstants.SCALE;

public class Constants {
    public static class UI {
        public static class NumberDisplayContants {
            public static final int WIDTH_DEFAULT_SIZE = 168*3;
            public static final int HEIGHT_DEFAULT_SIZE = 218;

            public static final int WIDTH_SIZE = (int) (WIDTH_DEFAULT_SIZE * SCALE);
            public static final int HEIGHT_SIZE = (int) (HEIGHT_DEFAULT_SIZE * SCALE);
        }
        
        public static class MenuButtonsContants {
            public static final int WIDTH_DEFAULT_SIZE = 500;
            public static final int HEIGHT_DEFAULT_SIZE = 140;

            public static final int WIDTH_SIZE = (int) (WIDTH_DEFAULT_SIZE * SCALE);
            public static final int HEIGHT_SIZE = (int) (HEIGHT_DEFAULT_SIZE * SCALE);
        }
    }
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
