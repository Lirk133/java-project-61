package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;

public class GCD {

    //Игра наибольший общий делитель
    public static void gameGCD(boolean starting) {
        //приветствие и объяснение правил
        if (starting) {
            Cli.startGame();
            System.out.println("Find the greatest common divisor of given numbers.");
        }

        //задаём случайные два числа
        int number1 = Engine.random(GameConfig.getRandomMaxNumber());
        int number2 = Engine.random(GameConfig.getRandomMaxNumber());
        //определяем наибольший общий делитель
        String correctly = Integer.toString(Engine.gcd(number1, number2));
        //создаём строку для вопроса
        String question = number1 + " " + number2;
        //задаём вопрос и получаем ответ
        String answer = Engine.question(question);

        //проверяем ответ
        Engine.isCorrectly(answer, correctly);
    }
}
