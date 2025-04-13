package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Progression {

    public static void gameProgression() {
        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("What number is missing in the progression?");

        int round = 3;
        int numberLast = 10;
        int numberFirstStep1 = 2;
        int numberFirstStep2 = 0;
        int randomFirstNumber = 20;
        int massiveLength = 10;
        //начало раундов
        for (int i = 0; i < round; i++) {

            //задаём случайные шаг для прогрессии
            int step = Engine.random(numberFirstStep1, numberLast);
            //запоминаем какую позицию в прогрессии скрыть
            int hiddenNumber = Engine.random(numberFirstStep2, numberLast);
            //определяем первое число в прогрессии
            int firstNumber = Engine.random(randomFirstNumber);
            //создаём массив прогрессии
            int[] numbers = new int[massiveLength];
            Engine.massiveProgression(numbers, firstNumber, step);

            //определяем скрытое число в строку
            String correctly = Integer.toString(numbers[hiddenNumber]);

            //создаём строку для вопроса
            String question = Engine.massiveInStringProgression(numbers, hiddenNumber);
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
