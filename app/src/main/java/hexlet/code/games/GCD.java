package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class GCD {

    //Игра наибольший общий делитель
    public static void gameGCD(String[] answers, String[] questions, int rounds) {

        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("Find the greatest common divisor of given numbers.");

        for (int i = 0; i < rounds; i++) {
            createQuestions(answers, questions, i);
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameRounds(questions, answers);
    }

    private static void createQuestions(String[] answers, String[] questions, int round) {
        //задаём случайные два числа
        int number1 = Utils.random(GameConfig.getRandomMaxNumber());
        int number2 = Utils.random(GameConfig.getRandomMaxNumber());
        //определяем наибольший общий делитель
        answers[round] = Integer.toString(gcd(number1, number2));
        //создаём строку для вопроса
        questions[round] = number1 + " " + number2;
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
