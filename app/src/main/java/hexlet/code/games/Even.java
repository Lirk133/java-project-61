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
        String[] questions = new String[rounds];
        String[] answers = new String[rounds];

        //приветствие и объяснение правил
        Engine.gameGreeting("Answer 'yes' if the number is even, otherwise answer 'no'.");

        //Создаём вопросы
        for (int i = 0; i < rounds; i++) {
            //генерация случайного числа и определение его как чётное или не чётное
            int number = Utils.random(RANDOM_MAX_NUMBER);
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
