package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Calc {

    public static void gameCalc(String[] answers, String[] questions, int rounds) {

        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("What is the result of the expression?");

        for (int i = 0; i < rounds; i++) {
            createQuestions(answers, questions, i);
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameRounds(questions, answers);
    }

    private static void createQuestions(String[] answers, String[] questions, int round) {
        //задаём случайные два числа
        int number1 = Utils.random(GameConfig.getRandomMaxNumber());
        int number2 = Utils.random(GameConfig.getRandomMaxNumber());

        //задаём случайный математический знак и делаем верный подсчёт
        String mathSign = "";
        answers[round] = switch (Integer.toString(Utils.random(GameConfig.getRandomMaxSigns()))) {
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
