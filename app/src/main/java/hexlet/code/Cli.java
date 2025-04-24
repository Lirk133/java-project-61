package hexlet.code;

public class Cli {

    //основное приветствие
    public static void startGame() {
        //Приветствие в игре
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        //задаётся имя игрока и запоминается на постоянку
        String nameGamer = Utils.scannerString();
        System.out.println("Hello, " + nameGamer + "!");
    }
}
