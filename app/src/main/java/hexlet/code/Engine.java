package hexlet.code;

import hexlet.code.games.Prime;
import hexlet.code.games.Progression;
import hexlet.code.games.GCD;
import hexlet.code.games.Even;
import hexlet.code.games.Calc;

import java.util.Scanner;
import java.util.Random;

public class Engine {

    //этап с раундами
    public static void gamesRounds(String game) {
        int rounds = GameConfig.getMaxRounds();
        boolean gameIsStarting = true;
        while (rounds != 0) {
            switch (game) {
                case "1":
                    Cli.startGame();
                    return;
                case "2":
                    Even.gameEven(gameIsStarting);
                    break;
                case "3":
                    Calc.gameCalc(gameIsStarting);
                    break;
                case "4":
                    GCD.gameGCD(gameIsStarting);
                    break;
                case "5":
                    Progression.gameProgression(gameIsStarting);
                    break;
                case "6":
                    Prime.gamePrime(gameIsStarting);
                    break;
                default:
                    System.exit(0);
                    break;
            }
            rounds--;
            gameIsStarting = false;
        }
        winner();
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

    public static int random(int numberFirstStep, int numberLength) {
        Random rnd = new Random();
        int result = rnd.nextInt(numberLength);
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
    public static void isCorrectly(String answer, String correctly) {
        boolean isCorrectly = answer.equals(correctly);
        if (!isCorrectly) {
            System.out.printf("'%s' is wrong answer ;(. Correct answer was '%s'.\n", answer, correctly);
            System.out.printf("Let's try again, %s!\n", Cli.getNameGamer());
            System.exit(0);
        }
        System.out.println("Correct!");
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
            if (number % numberSecond == 0) {
                result = "no";
                break;
            }
            numberSecond++;
        }
        return result;
    }
}
