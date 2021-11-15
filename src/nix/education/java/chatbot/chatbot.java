package nix.education.java.chatbot;

import java.util.Scanner;

public class chatbot {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Hello, dude! My name is Abobus");
        System.out.println("I was created in 2021");
        System.out.println("Please, remind me your name");
        String name = scanner.nextLine();
        System.out.println("What a great name you have," + name);

    }

}
