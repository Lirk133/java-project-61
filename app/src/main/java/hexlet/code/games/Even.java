package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;
import hexlet.code.GameConfig;

public class Even {

    //Игра в четные числа
    public static void gameEven(boolean starting) {
        //приветствие и объяснение правил
        if (starting) {
            Cli.startGame();
            System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");
        }

        //генерация случайного числа и определение его как чётное или не чётное
        int number = Engine.random(GameConfig.getRandomMaxNumber());
        String correctly = Engine.numberCheck(number);
        //получение ответа от игрока
        String answer = Engine.question(Integer.toString(number));

        //сравнение ответа игрока с правильным ответом
        Engine.isCorrectly(answer, correctly);
    }
}
