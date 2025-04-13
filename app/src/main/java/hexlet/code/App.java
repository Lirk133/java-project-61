package hexlet.code;

import hexlet.code.games.Calc;
import hexlet.code.games.Even;
import hexlet.code.games.GCD;
import hexlet.code.games.Prime;
import hexlet.code.games.Progression;

public class App {
    public static void main(String[] args) {

        //основное меню выбора игры
        while (true) {
            System.out.print("""
                    Please enter the game number and press Enter.
                    1 - Greet
                    2 - Even
                    3 - Calc
                    4 - GCD
                    5 - Progression
                    6 - Prime
                    0 - Exit
                    Your choice:\s""");

            String choiceGame = Engine.scannerString();

            switch (choiceGame) {
                case "1":
                    Cli.startGame();
                    break;
                case "2":
                    Even.gameEven();
                    break;
                case "3":
                    Calc.gameCalc();
                    break;
                case "4":
                    GCD.gameGCD();
                    break;
                case "5":
                    Progression.gameProgression();
                    break;
                case "6":
                    Prime.gamePrime();
                    break;
                case "0":
                    System.exit(0);
                    break;
                default:
                    System.out.println("Wrong command.\nPlease try again.");
                    break;
            }
        }

    }
}
