package hexlet.code;

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

        String choiceGame = Engine.scannerString();

        Engine.gamesRounds(choiceGame);

    }
}

