import java.util.Scanner;

public class HangmanGame {
    private GameHelper helper = new GameHelper();
    private Gallows gallows = new Gallows();
    private boolean loss = false;

    private void setLoss() {
        loss = (gallows.getCurrentStage() + 1 >= gallows.getStagesNumber()) ? true : false;
    }

    private void setUpGame() {
        System.out.println("THE HANGMAN GAME");
        System.out.println("Your goal is to guess a secret word letter by letter.");
        System.out.println("Each line _ represents one letter.");
        System.out.println("When your guess is wrong computer draw a part of the hangman.");
        System.out.println("You win before computer finishes entire hangman.");

        String[] stages = {
                "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n",
                "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "/         \n",
                "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "          \n" +
                        "/ \\       \n",
                "          \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        "/ \\       \n",
                " ________ \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        "/ \\       \n",
                " ________ \n" +
                        " |      | \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        "/ \\       \n",
                " ________ \n" +
                        " |      | \n" +
                        " |      o \n" +
                        " |        \n" +
                        " |        \n" +
                        " |        \n" +
                        "/ \\       \n",
                " ________ \n" +
                        " |      | \n" +
                        " |      o \n" +
                        " |     /  \n" +
                        " |        \n" +
                        " |        \n" +
                        "/ \\       \n",
                " ________ \n" +
                        " |      | \n" +
                        " |      o \n" +
                        " |     /| \n" +
                        " |        \n" +
                        " |        \n" +
                        "/ \\       \n",
                " ________ \n" +
                        " |      | \n" +
                        " |      o \n" +
                        " |     /|\\\n" +
                        " |        \n" +
                        " |        \n" +
                        "/ \\       \n",
                " ________ \n" +
                        " |      | \n" +
                        " |      o \n" +
                        " |     /|\\\n" +
                        " |     /  \n" +
                        " |        \n" +
                        "/ \\       \n",
                " ________ \n" +
                        " |      | \n" +
                        " |      o \n" +
                        " |     /|\\\n" +
                        " |     / \\\n" +
                        " |        \n" +
                        "/ \\       \n"
        };
        gallows.setStages(stages);
    }

    private void startPlaying() {
        helper.setRandomWord();
        helper.getEncryptedWord();

        while (helper.isWordEncrypted() && !loss) {
            checkUserGuess();
            setLoss();
        }

        finishGame();
    }

    private void checkUserGuess() {
        char userGuess = helper.getUserChar("Enter a letter: ");

        if (!helper.isCharFound(userGuess)) {
            gallows.setCurrentStage();
        }

        gallows.drawStage();
        helper.getUserLetters();
        helper.getEncryptedWord();
    }

    private void finishGame() {
        System.out.println("End of the game!");

        if (loss) {
            System.out.println("You're hanged!");
            System.out.println("The secret word was \"" + helper.getRandomWord() + "\".");
        } else {
            System.out.println("You are the winner!");
        }
    }

    public static void main(String[] args) {
        HangmanGame game = new HangmanGame();
        game.setUpGame();
        game.startPlaying();
    }
}