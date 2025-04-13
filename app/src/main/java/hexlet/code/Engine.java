package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Engine {

    //упрощённый сканер текста для быстрого написания
    public static String scannerString() {
        return new Scanner(System.in).nextLine();
    }


    //метод проверки ответа (yes - верный ответ, no - не верный ответ)
    public static String numberCheck(int number1, int number2) {
        if (number1 % number2 == 0) {
            return "yes";
        }
        return "no";
    }

    //метод рандома от 1 до 100
    public static int random(int number) {
        Random rnd = new Random();
        int result = rnd.nextInt(number) + 1;
        return result;
    }

    //метод вопроса и получения ответа
    public static String question(String question) {
        System.out.print("Question: " + question + "\nYour answer: ");
        return scannerString();
    }

    //метод проверки вопроса и ответа
    public static boolean isCorrectly(String answer, String correctly) {
        boolean isCorrectly = answer.equals(correctly);
        if (isCorrectly) {
            System.out.println("Correct!");
            return true;
        }
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.", answer, correctly);
        System.out.println();
        return false;
    }

    //победа игрока
    public static void winner() {
        System.out.printf("Congratulations, %s!", Cli.nameGamer);
        System.out.println();
    }
}
