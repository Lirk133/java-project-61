package hexlet.code;

import hexlet.code.games.*;

public class App {
    public static void main(String[] args) {

        //основное меню выбора игры
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

        String choiceGame = Utils.scannerString();

        //создаём массивы с вопросами и ответами
        int rounds = GameConfig.getMaxRounds();
        String[] questions = new String[rounds];
        String[] answers = new String[rounds];

        //запускаем выбранную игру
        switch (choiceGame) {
            case "1":
                Cli.startGame();
                return;
            case "2":
                Even.gameEven(answers, questions, rounds);
                break;
            case "3":
                Calc.gameCalc(answers, questions, rounds);
                break;
            case "4":
                GCD.gameGCD(answers, questions, rounds);
                break;
            case "5":
                Progression.gameProgression(answers, questions, rounds);
                break;
            case "6":
                Prime.gamePrime(answers, questions, rounds);
                break;
            default:
                System.exit(0);
                break;
        }

    }

}

