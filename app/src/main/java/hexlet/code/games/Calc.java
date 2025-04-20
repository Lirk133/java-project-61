package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;

public class Calc {

    public static void gameCalc(boolean starting) {
        //приветствие и объяснение правил
        if (starting) {
            Cli.startGame();
            System.out.println("What is the result of the expression?");
        }

        //задаём случайные два числа
        int number1 = Engine.random(GameConfig.getRandomMaxNumber());
        int number2 = Engine.random(GameConfig.getRandomMaxNumber());

        //задаём случайный математический знак и делаем верный подсчёт
        String mathSign = "";
        String correctly = switch (Integer.toString(Engine.random(GameConfig.getRandomMaxSigns()))) {
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
        String question = number1 + " " + mathSign + " " + number2;
        //задаём вопрос и получаем ответ
        String answer = Engine.question(question);
        //проверяем ответ
        Engine.isCorrectly(answer, correctly);
    }
}
