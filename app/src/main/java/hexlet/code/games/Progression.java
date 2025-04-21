package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Progression {

    public static void gameProgression(String[] answers, String[] questions, int rounds) {

        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("What number is missing in the progression?");

        for (int i = 0; i < rounds; i++) {
            createQuestions(answers, questions, i);
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameRounds(questions, answers);



    }

    private static void createQuestions(String[] answers, String[] questions, int round) {
        //задаём случайные шаг для прогрессии
        int step = Utils.random(GameConfig.getNumberFirstStepOne(), GameConfig.getNumberLast());
        //запоминаем какую позицию в прогрессии скрыть
        int hiddenNumber = Utils.random(GameConfig.getNumberFirstStepTwo(), GameConfig.getNumberLast());
        //определяем первое число в прогрессии
        int firstNumber = Utils.random(GameConfig.getRandomFirstNumber());
        //создаём массив прогрессии
        int[] numbers = new int[GameConfig.getMassiveLength()];
        massiveProgression(numbers, firstNumber, step);

        //определяем скрытое число в строку
        answers[round] = Integer.toString(numbers[hiddenNumber]);

        //создаём строку для вопроса
        questions[round] = massiveInStringProgression(numbers, hiddenNumber);
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
