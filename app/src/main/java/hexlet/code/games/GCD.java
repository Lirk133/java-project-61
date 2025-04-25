package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class GCD {

    private static final int RANDOM_MAX_NUMBER = 100;

    //Игра наибольший общий делитель
    public static void gameGCD() {

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[][] questAnswers = new String[2][rounds];
        String greeting = "Find the greatest common divisor of given numbers.";

        for (int i = 0; i < rounds; i++) {
            //задаём случайные два числа
            int number1 = Utils.random(RANDOM_MAX_NUMBER);
            int number2 = Utils.random(RANDOM_MAX_NUMBER);
            //определяем наибольший общий делитель
            questAnswers[1][i] = Integer.toString(gcd(number1, number2));
            //создаём строку для вопроса
            questAnswers[0][i] = number1 + " " + number2;
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameStart(greeting, questAnswers);
    }

    //метод определяет какое из двух чисел большее и запускает логику наибольшего общего делителя
    public static int gcd(int number1, int number2) {
        int result;
        if (number1 >= number2) {
            result = gcdLogic(number1, number2);
        } else {
            result = gcdLogic(number2, number1);
        }
        return result;
    }

    //логика нахождения наибольшего общего делителя
    private static int gcdLogic(int number1, int number2) {
        int result = 0;
        int isGCD = number1 / 2;
        while (isGCD != 0 && result == 0) {
            if (number1 % isGCD == 0 && number2 % isGCD == 0) {
                result = isGCD;
            }
            isGCD--;
        }
        return result;
    }
}
