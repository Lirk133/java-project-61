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
        return random(1, number);
    }

    public static int random(int numberFirstStep, int numberLast) {
        Random rnd = new Random();
        int result = rnd.nextInt(numberLast);
        if (result < numberFirstStep) {
            result += numberFirstStep;
        }
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

    public static int gcd(int number1, int number2) {
        int result;
        if (number1 >= number2) {
            result = gcdLogic(number1, number2);
        } else {
            result = gcdLogic(number2, number1);
        }
        return result;
    }

    private static int gcdLogic(int number1, int number2) {
        int result = 0;
        int isGCD = number1 / 2;
        while (isGCD != 0 && result == 0) {
            if (number1 % isGCD == 0 && number2 % isGCD == 0) {
                result = isGCD;
            }
            isGCD--;
        }
        return result;
    }

    public static void massiveProgression(int[] numbers, int first, int step) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = first;
            first += step;
        }
    }

    public static String massiveInStringProgression(int[] numbers, int position) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < numbers.length; i++) {
            if (i != position) {
                result.append(numbers[i]).append(" ");
            } else {
                result.append(".. ");
            }
        }
        return result.toString();
    }
}
