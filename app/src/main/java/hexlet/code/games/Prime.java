package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Prime {

    private static final int RANDOM_MAX_NUMBER = 100;

    public static void gamePrime() {

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[][] questAnswers = new String[rounds][2];
        String greeting = "Answer 'yes' if given number is prime. Otherwise answer 'no'.";

        //создаём вопросы и ответы
        for (int i = 0; i < rounds; i++) {
            int number = Utils.random(RANDOM_MAX_NUMBER);
            questAnswers[i][0] = Integer.toString(number);
            questAnswers[i][1] = primeCheck(number) ? "yes" : "no";
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameStart(greeting, questAnswers);
    }

    //метод проверки примитивного числа
    private static boolean primeCheck(int number) {
        int numberSecond = 2;
        while (numberSecond < number) {
            if (number % numberSecond == 0) {
                return false;
            }
            numberSecond++;
        }
        return true;
    }
}
