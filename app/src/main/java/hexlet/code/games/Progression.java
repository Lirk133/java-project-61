package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;

public class Progression {

    public static void gameProgression(boolean starting) {
        //приветствие и объяснение правил
        if (starting) {
            Cli.startGame();
            System.out.println("What number is missing in the progression?");
        }

        //задаём случайные шаг для прогрессии
        int step = Engine.random(GameConfig.getNumberFirstStepOne(), GameConfig.getNumberLast());
        //запоминаем какую позицию в прогрессии скрыть
        int hiddenNumber = Engine.random(GameConfig.getNumberFirstStepTwo(), GameConfig.getNumberLast());
        //определяем первое число в прогрессии
        int firstNumber = Engine.random(GameConfig.getRandomFirstNumber());
        //создаём массив прогрессии
        int[] numbers = new int[GameConfig.getMassiveLength()];
        Engine.massiveProgression(numbers, firstNumber, step);

        //определяем скрытое число в строку
        String correctly = Integer.toString(numbers[hiddenNumber]);

        //создаём строку для вопроса
        String question = Engine.massiveInStringProgression(numbers, hiddenNumber);
        //задаём вопрос и получаем ответ
        String answer = Engine.question(question);
        //проверяем ответ
        Engine.isCorrectly(answer, correctly);
    }
}
