package hexlet.code;


public class App {
    public static void main(String[] args) {

        //основное меню выбора игры
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                3 - Calc
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
            case "0":
                break;
            default:
                break;
        }


    }
}
