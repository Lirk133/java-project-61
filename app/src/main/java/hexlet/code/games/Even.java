package hexlet.code.games;

import hexlet.code.Engine;
import hexlet.code.GameConfig;
import hexlet.code.Utils;

public class Even {

    private static final int RANDOM_MAX_NUMBER = 100;

    //Игра в четные числа
    public static void gameEven() {

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[][] questAnswers = new String[rounds][2];
        String greeting = "Answer 'yes' if the number is even, otherwise answer 'no'.";

        //Создаём вопросы
        for (int i = 0; i < rounds; i++) {
            //генерация случайного числа и определение его как чётное или не чётное
            int number = Utils.random(RANDOM_MAX_NUMBER);
            questAnswers[i][0] = Integer.toString(number);
            questAnswers[i][1] = number % 2 == 0 ? "yes" : "no";
        }

        //Запускаем основную игру, передавая туда наши вопросы и ответы
        Engine.gameStart(greeting, questAnswers);
    }
}
