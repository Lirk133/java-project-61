package hexlet.code;

public class Progression {

    public static void gameProgression() {
        //приветствие и объяснение правил
        Cli.startGame();
        System.out.println("What number is missing in the progression?");

        //начало раундов
        for (int i = 0; i < 3; i++) {

            //задаём случайные шаг для прогрессии
            int step = Engine.random(2, 10);
            //запоминаем какую позицию в прогрессии скрыть
            int hiddenNumber = Engine.random(0, 10);
            //определяем первое число в прогрессии
            int firstNumber = Engine.random(20);
            //создаём массив прогрессии
            int[] numbers = new int[10];
            Engine.massiveProgression(numbers, firstNumber, step);

            //определяем скрытое число в строку
            String correctly = Integer.toString(numbers[hiddenNumber]);

            //создаём строку для вопроса
            String question = Engine.massiveInStringProgression(numbers, hiddenNumber);
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
