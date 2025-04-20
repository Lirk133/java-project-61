package hexlet.code;

public class GameConfig {

    private static final int MAX_ROUNDS = 3;
    private static final int RANDOM_MAX_NUMBER = 100;
    private static final int RANDOM_MAX_SIGNS = 3;
    private static final int NUMBER_LAST = 10;
    private static final int NUMBER_FIRST_STEP_ONE = 2;
    private static final int NUMBER_FIRST_STEP_TWO = 0;
    private static final int RANDOM_FIRST_NUMBER = 20;
    private static final int MASSIVE_LENGTH = 10;

    public static int getMaxRounds() {
        return MAX_ROUNDS;
    }

    public static int getRandomMaxNumber() {
        return RANDOM_MAX_NUMBER;
    }

    public static int getRandomMaxSigns() {
        return RANDOM_MAX_SIGNS;
    }

    public static int getNumberLast() {
        return NUMBER_LAST;
    }

    public static int getNumberFirstStepOne() {
        return NUMBER_FIRST_STEP_ONE;
    }

    public static int getNumberFirstStepTwo() {
        return NUMBER_FIRST_STEP_TWO;
    }

    public static int getRandomFirstNumber() {
        return RANDOM_FIRST_NUMBER;
    }

    public static int getMassiveLength() {
        return MASSIVE_LENGTH;
    }

}
