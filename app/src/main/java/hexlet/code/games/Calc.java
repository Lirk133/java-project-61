package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Calc {

    private static final int RANDOM_MAX_NUMBER = 100;
    private static final String[] MATH_SIGNS = {"+", "-", "*"};

    public static void gameCalc() {

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[][] questAnswers = new String[rounds][2];
        String greeting = "What is the result of the expression?";

        for (int i = 0; i < rounds; i++) {
            //задаём случайные два числа
            int number1 = Utils.random(RANDOM_MAX_NUMBER);
            int number2 = Utils.random(RANDOM_MAX_NUMBER);

            //задаём случайный математический знак и делаем верный подсчёт
            int mathSign = Utils.random(0, MATH_SIGNS.length);
            questAnswers[i][1] = answerProgression(mathSign, number1, number2);

            //создаём строку для вопроса
            questAnswers[i][0] = number1 + " " + MATH_SIGNS[mathSign] + " " + number2;
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameStart(greeting, questAnswers);
    }

    private static String answerProgression(int mathSign, int number1, int number2) {
        String result;
        result = switch (MATH_SIGNS[mathSign]) {
            case "+" -> Integer.toString(number1 + number2);
            case "-" -> Integer.toString(number1 - number2);
            case "*" -> Integer.toString(number1 * number2);
            default -> "";
        };
        return result;
    }
}
