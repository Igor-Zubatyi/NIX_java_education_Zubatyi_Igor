package nix.education.java.coffeemashine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        makingCoffee();
        calculationOfIngredients();
        checkingOfIngredients();
        coffeeMachineAction();
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
    static void coffeeMachineAction(){
        CoffeeMachineRealization coffeeMachineRealization = new CoffeeMachineRealization();
        coffeeMachineRealization.productsInformation();
        System.out.println("Write action (buy, fill, take):");
        Scanner scanner = new Scanner(System.in);
        String point = scanner.nextLine();
        if (point.equalsIgnoreCase("buy"))
            coffeeMachineRealization.buy();
        else if (point.equalsIgnoreCase("fill"))
            coffeeMachineRealization.fill();
        else if (point.equalsIgnoreCase("take"))
            coffeeMachineRealization.take();
        else
            System.out.println("Wrong action");

    }
}
class CoffeeMachineRealization{
    private int numberOfWater = 400;
    public void setNumberOfWater(int numberOfWater){
        this.numberOfWater = numberOfWater;
    }
    public int getNumberOfWater(){
        return numberOfWater;
    }
    private  int numberOfMilk = 540;
    public void setNumberOfMilk(int numberOfMilk){
        this.numberOfMilk = numberOfMilk;
    }
    private int getNumberOfMilk(){
        return numberOfMilk;
    }
    private int numberOfCoffeeBeans = 120;
    public void setNumberOfCoffeeBeans(int numberOfCoffeeBeans){
        this.numberOfCoffeeBeans = numberOfCoffeeBeans;
    }
    public int getNumberOfCoffeeBeans(){
        return numberOfCoffeeBeans;

    }
    private int numberOfGlasses = 9;
    public void setNumberOfGlasses(int numberOfGlasses){
        this.numberOfGlasses = numberOfGlasses;
    }
    public int getNumberOfGlasses(){
        return numberOfGlasses;
    }
    private int numberOfMoney = 550;
    public void setNumberOfMoney(int numberOfMoney){
        this.numberOfMoney = numberOfMoney;
    }
    public int getNumberOfMoney(){
        return numberOfMoney;
    }
    void productsInformation(){
        System.out.println("The coffee machine has:");
        System.out.println(getNumberOfWater() + " of water");
        System.out.println(getNumberOfMilk() + " of milk");
        System.out.println(getNumberOfCoffeeBeans()+ " of coffee beans");
        System.out.println(getNumberOfGlasses() + " disposable cups");
        System.out.println(getNumberOfMoney() + " of money");
    }
    void buy() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        Scanner scanner = new Scanner(System.in);
        int point = scanner.nextInt();
        if (point == 1) {
            setNumberOfWater(getNumberOfWater() - 250);
            setNumberOfCoffeeBeans(getNumberOfCoffeeBeans() - 16);
            setNumberOfMoney(getNumberOfCoffeeBeans() + 4);
            setNumberOfGlasses(getNumberOfGlasses() - 1);
        } else if (point == 2) {
            setNumberOfWater(getNumberOfWater() - 350);
            setNumberOfMilk(getNumberOfMilk() - 75);
            setNumberOfCoffeeBeans(getNumberOfCoffeeBeans() - 20);
            setNumberOfMoney(getNumberOfMoney() + 7);
            setNumberOfGlasses(getNumberOfGlasses() - 1);
        } else if (point == 3){
            setNumberOfWater( getNumberOfWater() - 200);
            setNumberOfMilk(getNumberOfMilk() - 100);
            setNumberOfCoffeeBeans(getNumberOfCoffeeBeans() - 12);
            setNumberOfMoney(getNumberOfMoney() + 6);
            setNumberOfGlasses(getNumberOfGlasses() - 1);
        }
        else
            System.out.println("Wrong number");
        productsInformation();
    }
    void fill(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many ml of watter you want to add:");
        int water = scanner.nextInt();
        setNumberOfWater(getNumberOfWater() + water);
        System.out.println("Write how many ml of milk you want to add:");
        int milk = scanner.nextInt();
        setNumberOfMilk(getNumberOfMilk() + milk);
        System.out.println("Write how many grams of coffee beans you want to add:");
        int beans = scanner.nextInt();
        setNumberOfCoffeeBeans(getNumberOfCoffeeBeans() + beans);
        System.out.println("Write how many disposable coffee cups you want to add:");
        int glasses = scanner.nextInt();
        setNumberOfGlasses(getNumberOfGlasses() + glasses);
        productsInformation();
    }
    void take(){
     setNumberOfMoney(0);
     productsInformation();
    }
}
