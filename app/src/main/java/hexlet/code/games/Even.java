package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Even {

    //Игра в четные числа
    public static void gameEven(String[] answers, String[] questions, int rounds) {

        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        //Создаём вопросы
        for (int i = 0; i < rounds; i++) {
            //генерация случайного числа и определение его как чётное или не чётное
            int number = Utils.random(GameConfig.getRandomMaxNumber());
            questions[i] = Integer.toString(number);
            answers[i] = numberCheck(number);
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameRounds(questions, answers);
    }

    //метод проверки ответа (yes - верный ответ, no - не верный ответ)
    private static String numberCheck(int number) {
        if (number % 2 == 0) {
            return "yes";
        }
        return "no";
    }

}
