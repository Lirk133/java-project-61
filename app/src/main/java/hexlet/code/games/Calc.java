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
        String[] questions = new String[rounds];
        String[] answers = new String[rounds];

        //приветствие и объяснение правил
        Engine.gameGreeting("What is the result of the expression?");

        for (int i = 0; i < rounds; i++) {
            createQuestions(answers, questions, i);
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameRounds(questions, answers);
    }

    private static void createQuestions(String[] answers, String[] questions, int round) {
        //задаём случайные два числа
        int number1 = Utils.random(RANDOM_MAX_NUMBER);
        int number2 = Utils.random(RANDOM_MAX_NUMBER);

        //задаём случайный математический знак и делаем верный подсчёт
        String mathSign = "";
        answers[round] = switch (Integer.toString(Utils.random(RANDOM_MAX_SIGNS))) {
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
        questions[round] = number1 + " " + mathSign + " " + number2;
    }
}
