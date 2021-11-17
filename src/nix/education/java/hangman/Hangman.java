package nix.education.java.hangman;

import java.util.Random;
import java.util.Scanner;

public class Hangman {
    static String randomWord = randomWord();
    public static void main(String[] args) {
        welcome();
        result(attempt());
    }
    static void welcome(){
        System.out.println("HANGMAN");
        System.out.println("Guess the world");
        System.out.println(hint(randomWord));
    }
    static String attempt(){
        Scanner scanner = new Scanner(System.in);
        String word = scanner.nextLine();
        return word;
    }
    static void result (String word){

        if (word.equalsIgnoreCase(randomWord))
            System.out.println("You survived!");
        else System.out.println("You lost " + randomWord);
    }
    static String randomWord(){
        Random random = new Random();
        String[] wordsArray = new String[] {"python", "java", "javascript", "kotlin"};
        String randomWord = wordsArray[random.nextInt(wordsArray.length)];
        return randomWord;
    }
    static String hint(String randomWord){
        char[] letters = randomWord.toCharArray();
        for (int i = 2; i < letters.length; i++) {
            letters [i] = '-';
        }
        String word = new String(letters);
        return word;
    }
}
