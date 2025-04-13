package hexlet.code;

import java.util.Scanner;
import java.util.Random;

public class Engine {

    private static final int round = 3;
    private static final int randomMaxNumber = 100;
    private static final int randomMaxSigns = 3;
    private static final int numberLast = 10;
    private static final int numberFirstStep1 = 2;
    private static final int numberFirstStep2 = 0;
    private static final int randomFirstNumber = 20;
    private static final int massiveLength = 10;

    public static int getRound() {
        return round;
    }

    public static int getRandomMaxNumber() {
        return randomMaxNumber;
    }

    public static int getRandomMaxSigns() {
        return randomMaxSigns;
    }

    public static int getNumberLast() {
        return numberLast;
    }

    public static int getNumberFirstStep1() {
        return numberFirstStep1;
    }

    public static int getNumberFirstStep2() {
        return numberFirstStep2;
    }

    public static int getRandomFirstNumber() {
        return randomFirstNumber;
    }

    public static int getMassiveLength() {
        return massiveLength;
    }

    //упрощённый сканер текста для быстрого написания
    public static String scannerString() {
        return new Scanner(System.in).nextLine();
    }

    //метод проверки ответа (yes - верный ответ, no - не верный ответ)
    public static String numberCheck(int number) {
        return numberCheck(number, 2);
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
        System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, correctly);
        System.out.printf("Let's try again, %s!\n", Cli.getNameGamer());
        return false;
    }

    //победа игрока
    public static void winner() {
        System.out.printf("Congratulations, %s!\n", Cli.getNameGamer());
    }

    //метод определяет какое из двух чисел большее и запускает логику наибольшего общего делителя
    public static int gcd(int number1, int number2) {
        int result;
        if (number1 >= number2) {
            result = gcdLogic(number1, number2);
        } else {
            result = gcdLogic(number2, number1);
        }
        return result;
    }

    //логика нахождения наибольшего общего делителя
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

    //задаёт в массиве элементы, начиная с первого и с определённым шагом
    public static void massiveProgression(int[] numbers, int first, int step) {
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = first;
            first += step;
        }
    }

    //преобразует массив в строку, скрывая определённую позицию
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

    public static String primeCheck(int number) {
        String result = "yes";
        int numberSecond = 2;
        while (numberSecond < number) {
            if (numberCheck(number, numberSecond).equals("yes")) {
                result = "no";
                break;
            }
            numberSecond++;
        }
        return result;
    }
}
