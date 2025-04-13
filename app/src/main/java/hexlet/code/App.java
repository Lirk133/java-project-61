package hexlet.code;


public class App {
    public static void main(String[] args) {

        //основное меню выбора игры
        System.out.print("""
                Please enter the game number and press Enter.
                1 - Greet
                2 - Even
                0 - Exit
                Your choice:\s""");

        String choiceGame = Cli.scannerString();

        switch (choiceGame) {
            case "1":
                Cli.startGame();
            case "2":
                Even.gameEven();
            case "0":
            default:
        }


    }
}
