package hexlet.code.games;

import hexlet.code.Cli;
import hexlet.code.Engine;

public class Even {

    //Игра в четные числа
    public static void gameEven() {
        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        int round = 3;
        int randomMax = 100;
        //начало раундов
        for (int i = 0; i < round; i++) {
            //генерация случайного числа и определение его как чётное или не чётное
            int number = Engine.random(randomMax);
            String correctly = Engine.numberCheck(number);

            //получение ответа от игрока
            String answer = Engine.question(Integer.toString(number));

            //сравнение ответа игрока с правильным ответом
            boolean playing = Engine.isCorrectly(answer, correctly);
            if (!playing) {
                return;
            }
        }

        //поздравление с удачно пройденной игрой
        Engine.winner();
    }
}
