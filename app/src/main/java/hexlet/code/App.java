package hexlet.code;


public class App {
    public static void main(String[] args) {

        System.out.println("Welcome to the Brain Games!");
        System.out.print("May I have your name? ");

        String nameGamer = Cli.scannerString();

        System.out.println("Hello, " + nameGamer + "!");
    }
}
