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
            int number = (int) (Math.random() * 100);
            String correctly = numberCheck(number);

            //получение ответа от игрока
            System.out.print("Question: " + number + "\nYour answer: ");
            String answer = Cli.scannerString();

            //сравнение ответа игрока с правильным ответом
            boolean isCorrectly = answer.equals(numberCheck(number));
            if (isCorrectly) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.", answer, correctly);
                System.out.println();
                return;
            }
        }

        //поздравление с удачно пройденной игрой
        System.out.printf("Congratulations, %s!", Cli.nameGamer);
        System.out.println();
    }

    //метод проверки чётности числа (yes - чётное, no - не чётное)
    private static String numberCheck(int number) {
        if (number % 2 == 0) {
            return "yes";
        }
        return "no";
    }
}
