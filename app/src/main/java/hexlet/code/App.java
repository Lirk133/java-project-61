package hexlet.code;


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
