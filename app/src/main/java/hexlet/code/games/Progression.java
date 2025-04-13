package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Progression {

    public static void gameProgression() {
        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("What number is missing in the progression?");

        //начало раундов
        for (int i = 0; i < Engine.getRound(); i++) {

            //задаём случайные шаг для прогрессии
            int step = Engine.random(Engine.getNumberFirstStep1(), Engine.getNumberLast());
            //запоминаем какую позицию в прогрессии скрыть
            int hiddenNumber = Engine.random(Engine.getNumberFirstStep2(), Engine.getNumberLast());
            //определяем первое число в прогрессии
            int firstNumber = Engine.random(Engine.getRandomFirstNumber());
            //создаём массив прогрессии
            int[] numbers = new int[Engine.getMassiveLength()];
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
