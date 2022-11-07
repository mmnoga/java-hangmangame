import java.util.ArrayList;
import java.util.Scanner;

public class GameHelper {
    private final char HIDDENCHAR = '_';
    private String[] words = {"java", "python", "csharp"};
    private String randomWord;
    private String encryptedWord;
    private ArrayList<Character> userLetters = new ArrayList<Character>();

    private void setUserLetters(char letter) {
        if (!userLetters.contains(letter)) {
            userLetters.add(letter);
        }
        return;
    }

    private void replaceCharacter(int index, char character) {
        encryptedWord = encryptedWord.substring(0, index) + character + encryptedWord.substring(index + 1);
    }

    private void encryptWord() {
        encryptedWord = new String(new char[randomWord.length()]).replace('\u0000', HIDDENCHAR);
    }

    public void setRandomWord() {
        int index = (int) (Math.random() * words.length);
        randomWord = words[index];
        encryptWord();
    }

    public boolean isCharFound(char character) {
        boolean isFound = false;
        setUserLetters(character);

        for (int i = 0; i < randomWord.length(); i++) {
            if (randomWord.charAt(i) == character) {
                replaceCharacter(i, character);
                isFound = true;
            }
        }

        return isFound;
    }

    public boolean isWordEncrypted() {
        if (encryptedWord.contains(Character.toString(HIDDENCHAR))) {
            return true;
        }
        return false;
    }

    public void getEncryptedWord() {
        System.out.println("SECRET WORD: " + encryptedWord);
    }

    public char getUserChar(String prompt) {
        System.out.print(prompt + " ");
        Scanner sc = new Scanner(System.in);
        char letter = sc.next().charAt(0);

        return letter;
    }

    public String getRandomWord() {
        return randomWord;
    }

    public void getUserLetters() {
        System.out.println("Already entered letters: " + userLetters);
    }
}