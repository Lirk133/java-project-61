package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Prime {

    public static void gamePrime() {
        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("Answer 'yes' if given number is prime. Otherwise answer 'no'.");

        //начало раундов
        for (int i = 0; i < Engine.getRound(); i++) {

            //задаём случайные шаг для прогрессии
            int number = Engine.random(Engine.getRandomMaxNumber());

            //определяем является ли число простым
            String correctly = Engine.primeCheck(number);

            //создаём строку для вопроса
            String question = Integer.toString(number);
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
