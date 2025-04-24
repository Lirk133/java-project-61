package hexlet.code;

public class Engine {

    private static String nameGamer;

    //метод приветствия игрока
    public static void gameGreeting(String greeting) {
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        //задаётся имя игрока и запоминается на постоянку
        nameGamer = Utils.scannerString();
        System.out.println("Hello, " + nameGamer + "!");
        System.out.println(greeting);
    }

    //этап с раундами
    public static void gameRounds(String[] questions, String[] answers) {
        int rounds = GameConfig.getMaxRounds();
        for (int i = 0; i < rounds; i++) {
            String playerAnswer = question(questions[i]);
            isCorrectly(playerAnswer, answers[i]);
        }
        winner();
    }

    //метод вопроса и получения ответа
    public static String question(String question) {
        System.out.print("Question: " + question + "\nYour answer: ");
        return Utils.scannerString();
    }

    //метод проверки вопроса и ответа
    public static void isCorrectly(String answer, String correctly) {
        boolean isCorrectly = answer.equals(correctly);
        if (!isCorrectly) {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, correctly);
            System.out.printf("Let's try again, %s!\n", nameGamer);
            System.exit(0);
        }
        System.out.println("Correct!");
    }

    //победа игрока
    public static void winner() {
        System.out.printf("Congratulations, %s!\n", nameGamer);
    }

}
