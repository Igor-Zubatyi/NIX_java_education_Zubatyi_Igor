package nix.education.java.coffeemashine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        makingCoffee();
        calculationOfIngredients();
        checkingOfIngredients();
    }
     static void makingCoffee() {
        System.out.println("Starting to make a coffee");
        System.out.println("Grinding coffee beans");
        System.out.println("Boiling water");
        System.out.println("Mixing boiled water with crushed coffee beans");
        System.out.println("Pouring coffee into the cup");
        System.out.println("Pouring some milk into the cup");
        System.out.println("Coffee is ready");
    }
     static void calculationOfIngredients(){
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
     static void checkingOfIngredients(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Write how many ml of water the coffee machine has:");
        int numberOfWater = scanner.nextInt();
         System.out.println("Write how many ml of milk the coffee machine has:");
        int numberOfMilk = scanner.nextInt();
         System.out.println("Write how many grams of coffee beans the coffee machine has:");
         int numberOfCoffeeBeans = scanner.nextInt();
         System.out.println("Write how many cups of coffee you need:");
         int numberOfCups = scanner.nextInt();
         if(numberOfWater < numberOfCups * 200 || numberOfMilk < numberOfCups * 50 || numberOfCoffeeBeans < numberOfCups * 15){
             while (numberOfWater < numberOfCups * 200 || numberOfMilk < numberOfCups * 50 || numberOfCoffeeBeans < numberOfCups * 15){
                 numberOfCups--;
             }
             System.out.println("No, I can make only "+ numberOfCups + " cups of coffee");
         }
         else if((numberOfWater >= numberOfCups * 200 && numberOfWater < (numberOfCups + 1) * 200) ||
                 (numberOfMilk >= numberOfCups * 50 && numberOfMilk < (numberOfCups + 1) * 50) ||
                 (numberOfCoffeeBeans >= numberOfCups * 15 && numberOfCoffeeBeans < (numberOfCups + 1) * 15)){
             System.out.println("Yes, I can make that amount of coffee");
         }
         else {
             int N = 0;
             do{
                 N++;
                 numberOfCups +=N;
             }while (numberOfCups * 200 < numberOfWater && numberOfCups * 50 < numberOfMilk && numberOfCups * 15 < numberOfCoffeeBeans);
             System.out.println("Yes, I can make that amount of coffee (and even " + N + " more of that)");
         }
    }
}
