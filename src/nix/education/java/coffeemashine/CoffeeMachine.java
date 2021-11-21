package nix.education.java.coffeemashine;

import java.util.Scanner;

public class CoffeeMachine {
    static CoffeeMachineRealization coffeeMachineRealization = new CoffeeMachineRealization();
    public static void main(String[] args) {
       mainMenu();
    }
    static int mainMenu(){
        Scanner scanner = new Scanner(System.in);
        String action;

        while (true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            String point = scanner.nextLine();
            action = coffeeMachineAction(point);
            if(action.equalsIgnoreCase("exit"))
                return 0;
        }
    }
    static String coffeeMachineAction(String point){


            if (point.equalsIgnoreCase("buy")) {
                coffeeMachineRealization.buy();
                return "buy";
            }
            else if (point.equalsIgnoreCase("fill")) {
                coffeeMachineRealization.fill();
                return "fill";
            }
            else if (point.equalsIgnoreCase("take")) {
                coffeeMachineRealization.take();
                return "take";
            }
            else if (point.equalsIgnoreCase("exit"))
                return "exit";
            else if (point.equalsIgnoreCase("remaining")) {
                coffeeMachineRealization.productsInformation();
                return "remaining";
            }
            else {
                System.out.println("Wrong action");
                return "error";
            }
    }
}
class CoffeeMachineRealization{
    Values values = new Values();
    void productsInformation() {
        System.out.println("The coffee machine has:");
        System.out.println(values.getNumberOfWater() + " of water");
        System.out.println(values.getNumberOfMilk() + " of milk");
        System.out.println(values.getNumberOfCoffeeBeans() + " of coffee beans");
        System.out.println(values.getNumberOfGlasses() + " disposable cups");
        System.out.println(values.getNumberOfMoney() + " of money");
    }
    int buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back to main menu:");
        Scanner scanner = new Scanner(System.in);
        int point = scanner.nextInt();
        if (point == 1) {
            if(values.getNumberOfWater() - values.QUANTITY_WATER_FOR_ESPRESSO >= 0 && values.getNumberOfCoffeeBeans() - values.QUANTITY_BEANS_FOR_ESPRESSO >= 0 && values.getNumberOfGlasses() > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                coffeeMaking(values.QUANTITY_WATER_FOR_ESPRESSO, 0, values.QUANTITY_BEANS_FOR_ESPRESSO, values.QUANTITY_MONEY_FOR_ESPRESSO);
            }
            else System.out.println("I don`t have enough resources");
        } else if (point == 2) {
            if (values.getNumberOfWater() - values.QUANTITY_WATER_FOR_LATTE >= 0 && values.getNumberOfMilk() - values.QUALITY_MILK_FOR_LATTE >= 0 && values.getNumberOfCoffeeBeans() - values.QUALITY_BEANS_FOR_LATTE >= 0 && values.getNumberOfGlasses() > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                coffeeMaking(values.QUANTITY_WATER_FOR_LATTE, values.QUALITY_MILK_FOR_LATTE, values.QUALITY_BEANS_FOR_LATTE, values.QUANTITY_MONEY_FOR_LATTE);
            } else {
                System.out.println("I don`t have enough resources");
            }
        } else if (point == 3){
            if (values.getNumberOfWater() - values.QUANTITY_WATTER_FOR_CAPPUCCINO >= 0 && values.getNumberOfMilk() - values.QUANTITY_MILK_FOR_CAPPUCCINO >= 0 && values.getNumberOfCoffeeBeans() - values.QUANTITY_BEANS_FOR_CAPPUCCINO >= 0 && values.getNumberOfGlasses() > 0) {
                coffeeMaking(values.QUANTITY_WATTER_FOR_CAPPUCCINO, values.QUANTITY_MILK_FOR_CAPPUCCINO,  values.QUANTITY_BEANS_FOR_CAPPUCCINO, values.QUANTITY_MONEY_FOR_CAPPUCCINO);
            } else {
                System.out.println("I don`t have enough resources");
            }
        }
        else if (point == 4) {
            return 0;
        }
        else
            System.out.println("Wrong number");
        return 0;
    }
    void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many ml of watter you want to add:");
        int water = scanner.nextInt();
        values.setNumberOfWater(values.getNumberOfWater() + water);
        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();
        values.setNumberOfMilk(values.getNumberOfMilk() + milk);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = scanner.nextInt();
        values.setNumberOfCoffeeBeans(values.getNumberOfCoffeeBeans() + beans);
        System.out.println("Write how many disposable coffee cups you want to add:");
        int glasses = scanner.nextInt();
        values.setNumberOfGlasses(values.getNumberOfGlasses() + glasses);
        productsInformation();
    }
    void take(){
        System.out.println("I gave you " + values.getNumberOfMoney());
        values.setNumberOfMoney(0);
    }
    void coffeeMaking(int numberOfWater, int numberOfMilk, int numberOfCoffeeBeans, int numberOfMoney){
        values.setNumberOfWater(values.getNumberOfWater() - numberOfWater);
        values.setNumberOfCoffeeBeans(values.getNumberOfCoffeeBeans() - numberOfCoffeeBeans);
        values.setNumberOfMilk(values.getNumberOfMilk() - numberOfMilk);
        values.setNumberOfMoney(values.getNumberOfMoney() + numberOfMoney);
        values.setNumberOfGlasses(values.getNumberOfGlasses() - 1);
    }
}
