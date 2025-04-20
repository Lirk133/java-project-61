package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;

public class Prime {

    public static void gamePrime(boolean starting) {
        //приветствие и объяснение правил
        if (starting) {
            Cli.startGame();
            System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");
        }

        //задаём случайные шаг для прогрессии
        int number = Engine.random(GameConfig.getRandomMaxNumber());
        //определяем является ли число простым
        String correctly = Engine.primeCheck(number);
        //создаём строку для вопроса
        String question = Integer.toString(number);
        //задаём вопрос и получаем ответ
        String answer = Engine.question(question);

        //проверяем ответ
        Engine.isCorrectly(answer, correctly);
    }
}
