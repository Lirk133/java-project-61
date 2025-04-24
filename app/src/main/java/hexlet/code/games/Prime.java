package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Prime {

    private static final int RANDOM_MAX_NUMBER = 100;

    public static void gamePrime() {

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[] questions = new String[rounds];
        String[] answers = new String[rounds];

        //приветствие и объяснение правил
        Engine.gameGreeting("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        //создаём вопросы и ответы
        for (int i = 0; i < rounds; i++) {
            createQuestions(answers, questions, i);
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameRounds(questions, answers);
    }

    //метод создания вопроса и ответа
    private static void createQuestions(String[] answers, String[] questions, int round) {
        //задаём случайные шаг для прогрессии
        int number = Utils.random(RANDOM_MAX_NUMBER);
        //определяем является ли число простым
        answers[round] = primeCheck(number);
        //создаём строку для вопроса
        questions[round] = Integer.toString(number);

    }

    //метод проверки примитивного числа
    private static String primeCheck(int number) {
        String result = "yes";
        int numberSecond = 2;
        while (numberSecond < number) {
            if (number % numberSecond == 0) {
                result = "no";
                break;
            }
            numberSecond++;
        }
        return result;
    }
}
