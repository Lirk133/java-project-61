package hexlet.code;

public class Engine {

    public static void gameStart(String greeting, String[][] questAnswers) {

        String nameGamer;

        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        //задаётся имя игрока и запоминается на постоянку
        nameGamer = Utils.scannerString();
        System.out.println("Hello, " + nameGamer + "!");
        System.out.println(greeting);


        int rounds = GameConfig.getMaxRounds();
        for (int i = 0; i < rounds; i++) {
            System.out.print("Question: " + questAnswers[i][0] + "\nYour answer: ");
            String playerAnswer = Utils.scannerString();
            if (playerAnswer.equals(questAnswers[i][1])) {
                System.out.println("Correct!");
            } else {
                System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n",
                        playerAnswer, questAnswers[i][1]);
                System.out.printf("Let's try again, %s!\n", nameGamer);
                System.exit(0);
            }
        }
        System.out.printf("Congratulations, %s!\n", nameGamer);
    }

}
