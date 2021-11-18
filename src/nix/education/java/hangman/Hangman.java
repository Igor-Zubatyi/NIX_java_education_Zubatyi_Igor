package nix.education.java.hangman;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static String randomWord = randomWord();
    static int attempts = 8;

    public static void main(String[] args) {
        welcome();
        menu();
    }

    static void welcome() {
        System.out.println("HANGMAN");
    }
    static int menu(){
        Scanner scanner = new Scanner(System.in);
        boolean playing = true;
        while (playing) {
            System.out.println("Type \"play\" to play the game, \"exit\" to quit:");
            String point = scanner.nextLine();
            if(point.equalsIgnoreCase("play"))
                result();
            else if(point.equalsIgnoreCase("exit"))
                playing = false;
        }
        return 0;
    }
    static char attempt() {
        Scanner scanner = new Scanner(System.in);
        String letter = scanner.nextLine();
        char[] letters = letter.toCharArray();
        return letters[0];
    }

    static void result() {
        StringBuilder hiddenWord = new StringBuilder(randomWord);
        StringBuilder guessWord = new StringBuilder();
        ArrayList<String> typedLetters = new ArrayList<>();
        for (int i = 0; i < randomWord.length(); i++) {
            guessWord.append("-");
        }
        while (attempts > 0) {
            System.out.println("Input letter");
            System.out.println(guessWord);
            char nextLetter = attempt();
            if (("" + nextLetter).length() != 1)
                System.out.println("You should input a single letter.");
            else {
                if (!("" + nextLetter).matches("[a-z]+"))
                    System.out.println("Please enter a lowercase English letter.");
                else {
                    if (typedLetters.contains("" + nextLetter)) {
                        System.out.println("You've already guessed this letter.");
                    } else {
                        typedLetters.add("" + nextLetter);
                        int indexOfLetter = hiddenWord.indexOf("" + nextLetter);
                        if (indexOfLetter != -1) {
                            while (indexOfLetter != -1) {
                                hiddenWord.setCharAt(indexOfLetter, '-');
                                guessWord.setCharAt(indexOfLetter, randomWord.charAt(indexOfLetter));
                                if (randomWord.equals(guessWord.toString())) {
                                    System.out.println("You survived");
                                    System.out.println(guessWord);
                                    attempts = 0;
                                }
                                indexOfLetter = hiddenWord.indexOf("" + nextLetter);
                            }
                        } else {
                            System.out.println("That letter doesn't appear in the word");
                            attempts--;
                        }
                    }
                }
            }
        }
        System.out.println("Thanks for playing!" +
                "We'll see how well you did in the next stage");
    }

    static String randomWord() {
        Random random = new Random();
        String[] wordsArray = new String[]{"python", "java", "javascript", "kotlin"};
        String randomWord = wordsArray[random.nextInt(wordsArray.length)];
        return randomWord;
    }

    static String hint(String randomWord) {
        char[] letters = randomWord.toCharArray();
        for (int i = 2; i < letters.length; i++) {
            letters[i] = '-';
        }
        String word = new String(letters);
        return word;
    }
}
