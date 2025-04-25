package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Prime {

    private static final int RANDOM_MAX_NUMBER = 100;

    public static void gamePrime() {

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[][] questAnswers = new String[2][rounds];
        String greeting = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        //создаём вопросы и ответы
        for (int i = 0; i < rounds; i++) {
            int number = Utils.random(RANDOM_MAX_NUMBER);
            questAnswers[0][i] = Integer.toString(number);
            questAnswers[1][i] = primeCheck(number);
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameStart(greeting, questAnswers);
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
