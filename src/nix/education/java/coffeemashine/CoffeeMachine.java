package nix.education.java.coffeemashine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        makingCoffee();
        calculationOfIngredients();
    }
    public static void makingCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready");
    }
    public static void calculationOfIngredients(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many cups of coffee you will need:");
        int numberOfCups = scanner.nextInt();
        int numberOfWater = numberOfCups * 200;
        int numberOfMilk = numberOfCups * 50;
        int numberOfCoffeeBeans = numberOfCups * 15;
        System.out.println("For " + numberOfCups + " cups of coffee you will need:");
        System.out.println(numberOfWater + " ml of water");
        System.out.println(numberOfMilk + " ml of milk");
        System.out.println(numberOfCoffeeBeans + " g of coffee beans");
    }
}
