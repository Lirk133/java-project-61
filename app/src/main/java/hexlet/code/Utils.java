package hexlet.code;

import java.util.Random;
import java.util.Scanner;

public class Utils {

    //упрощённый сканер текста для быстрого написания
    public static String scannerString() {
        return new Scanner(System.in).nextLine();
    }

    //метод рандома от 1 до number
    public static int random(int number) {
        return random(1, number);
    }

    //метод рандома от number_one до number_two
    public static int random(int numberFirstStep, int numberLength) {
        Random rnd = new Random();
        int result = rnd.nextInt(numberLength);
        if (result < numberFirstStep) {
            result += numberFirstStep;
        }
        return result;
    }

}
