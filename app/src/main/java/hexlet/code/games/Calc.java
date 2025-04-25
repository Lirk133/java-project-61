package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Calc {

    private static final int RANDOM_MAX_NUMBER = 100;
    private static final int RANDOM_MAX_SIGNS = 3;

    public static void gameCalc() {

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[][] questAnswers = new String[2][rounds];
        String greeting = "What is the result of the expression?";

        for (int i = 0; i < rounds; i++) {
            //задаём случайные два числа
            int number1 = Utils.random(RANDOM_MAX_NUMBER);
            int number2 = Utils.random(RANDOM_MAX_NUMBER);

            //задаём случайный математический знак и делаем верный подсчёт
            String mathSign = "";
            questAnswers[1][i] = switch (Integer.toString(Utils.random(RANDOM_MAX_SIGNS))) {
                case "1" -> {
                    mathSign = "+";
                    yield Integer.toString(number1 + number2);
                }
                case "2" -> {
                    mathSign = "-";
                    yield Integer.toString(number1 - number2);
                }
                case "3" -> {
                    mathSign = "*";
                    yield Integer.toString(number1 * number2);
                }
                default -> "";
            };

            //создаём строку для вопроса
            questAnswers[0][i] = number1 + " " + mathSign + " " + number2;
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameStart(greeting, questAnswers);
    }
}
