package hexlet.code;

public class GCD {

    //Игра наибольший общий делитель
    public static void gameGCD() {
        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("Find the greatest common divisor of given numbers.");

        //начало раундов
        for (int i = 0; i < 3; i++) {

            //задаём случайные два числа
            int number1 = Engine.random(100);
            int number2 = Engine.random(100);

            //определяем наибольший общий делитель
            String correctly = Integer.toString(Engine.gcd(number1, number2));

            //создаём строку для вопроса
            String question = number1 + " " + number2;
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
