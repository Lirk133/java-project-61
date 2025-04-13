package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Calc {

    public static void gameCalc() {
        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("What is the result of the expression?");

        int randomMaxNumber = 100;
        int randomMaxSigns = 3;
        int round = 3;
        //начало раундов
        for (int i = 0; i < round; i++) {

            //задаём случайные два числа
            int number1 = Engine.random(randomMaxNumber);
            int number2 = Engine.random(randomMaxNumber);

            //задаём случайный математический знак и делаем верный подсчёт
            String mathSign = "";
            String correctly = switch (Engine.random(randomMaxSigns)) {
                case 1 -> {
                    mathSign = "+";
                    yield Integer.toString(number1 + number2);
                }
                case 2 -> {
                    mathSign = "-";
                    yield Integer.toString(number1 - number2);
                }
                case 3 -> {
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
            boolean playing = Engine.isCorrectly(answer, correctly);
            if (!playing) {
                return;
            }
        }

        //поздравляем с победой
        Engine.winner();
    }
}
