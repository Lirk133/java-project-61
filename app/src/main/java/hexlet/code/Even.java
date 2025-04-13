package hexlet.code;

public class Even {

    //Игра в четные числа
    public static void gameEven() {
        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("Answer 'yes' if the number is even, otherwise answer 'no'.");

        //начало раундов
        for (int i = 0; i < 3; i++) {
            //генерация случайного числа и определение его как чётное или не чётное
            int number = Engine.random(100);
            String correctly = Engine.numberCheck(number, 2);

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
