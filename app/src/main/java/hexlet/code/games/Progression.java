package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Progression {

    private static final int NUMBER_LAST = 10;
    private static final int NUMBER_FIRST_STEP_ONE = 2;
    private static final int NUMBER_FIRST_STEP_TWO = 0;
    private static final int RANDOM_FIRST_NUMBER = 20;
    private static final int MASSIVE_LENGTH = 10;

    public static void gameProgression() {

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[][] questAnswers = new String[2][rounds];
        String greeting = "What number is missing in the progression?";

        for (int i = 0; i < rounds; i++) {
            //задаём случайные шаг для прогрессии
            int step = Utils.random(NUMBER_FIRST_STEP_ONE, NUMBER_LAST);
            //запоминаем какую позицию в прогрессии скрыть
            int hiddenNumber = Utils.random(NUMBER_FIRST_STEP_TWO, NUMBER_LAST);
            //определяем первое число в прогрессии
            int firstNumber = Utils.random(RANDOM_FIRST_NUMBER);
            //создаём массив прогрессии
            int[] numbers = new int[MASSIVE_LENGTH];
            massiveProgression(numbers, firstNumber, step);

            //определяем скрытое число в строку
            questAnswers[1][i] = Integer.toString(numbers[hiddenNumber]);

            //создаём строку для вопроса
            questAnswers[0][i] = massiveInStringProgression(numbers, hiddenNumber);
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameStart(greeting, questAnswers);



    }

    //задаёт в массиве элементы, начиная с первого и с определённым шагом
    private static void massiveProgression(int[] numbers, int first, int step) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = first;
            first += step;
        }
    }

    //преобразует массив в строку, скрывая определённую позицию
    public static String massiveInStringProgression(int[] numbers, int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i != position) {
                result.append(numbers[i]).append(" ");
            } else {
                result.append(".. ");
            }
        }
        return result.toString();
    }
}
