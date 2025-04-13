package hexlet.code;
import java.util.Scanner;

public class Cli {
    //имя игрока
    public static String nameGamer;

    //основное приветствие
    public static void startGame() {
        //Приветствие в игре
        System.out.println();
        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        //задаётся имя игрока и запоминается на постоянку
        nameGamer = scannerString();
        System.out.println("Hello, " + nameGamer + "!");
    }

    //упрощённый сканер текста для быстрого написания
    public static String scannerString() {
        return new Scanner(System.in).nextLine();
    }

}
