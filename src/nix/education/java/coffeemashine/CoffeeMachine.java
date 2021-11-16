package nix.education.java.coffeemashine;

import java.util.Scanner;

public class CoffeeMachine {

    public static void main(String[] args) {
        coffeeMachineAction();
    }
    static void coffeeMachineAction(){
        CoffeeMachineRealization coffeeMachineRealization = new CoffeeMachineRealization();
        boolean working = true;
        while (working == true) {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            Scanner scanner = new Scanner(System.in);
            String point = scanner.nextLine();
            if (point.equalsIgnoreCase("buy"))
                coffeeMachineRealization.buy();
            else if (point.equalsIgnoreCase("fill"))
                coffeeMachineRealization.fill();
            else if (point.equalsIgnoreCase("take"))
                coffeeMachineRealization.take();
            else if (point.equalsIgnoreCase("exit"))
                working = false;
            else if (point.equalsIgnoreCase("remaining"))
                coffeeMachineRealization.productsInformation();
            else
                System.out.println("Wrong action");
        }
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
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, 4 - back to main menu:");
        Scanner scanner = new Scanner(System.in);
        int point = scanner.nextInt();
        if (point == 1) {
            if(getNumberOfWater() - 250 >= 0 && getNumberOfCoffeeBeans() - 16 >= 0 && getNumberOfGlasses() > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                setNumberOfWater(getNumberOfWater() - 250);
                setNumberOfCoffeeBeans(getNumberOfCoffeeBeans() - 16);
                setNumberOfMoney(getNumberOfMoney() + 4);
                setNumberOfGlasses(getNumberOfGlasses() - 1);
            }
            else System.out.println("I don`t have enough resources");
        } else if (point == 2) {
            if (getNumberOfWater() - 350 >= 0 && getNumberOfMilk() - 75 >= 0 && getNumberOfCoffeeBeans() - 20 >= 0 && getNumberOfGlasses() > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                setNumberOfWater(getNumberOfWater() - 350);
                setNumberOfMilk(getNumberOfMilk() - 75);
                setNumberOfCoffeeBeans(getNumberOfCoffeeBeans() - 20);
                setNumberOfMoney(getNumberOfMoney() + 7);
                setNumberOfGlasses(getNumberOfGlasses() - 1);

            } else {
                System.out.println("I don`t have enough resources");
            }
        } else if (point == 3){
            if (getNumberOfWater() - 200 >= 0 && getNumberOfMilk() - 100 >= 0 && getNumberOfCoffeeBeans() - 12 >= 0 && getNumberOfGlasses() > 0) {
                System.out.println("I have enough resources, making you a coffee!");
                setNumberOfWater( getNumberOfWater() - 200);
                setNumberOfMilk(getNumberOfMilk() - 100);
                setNumberOfCoffeeBeans(getNumberOfCoffeeBeans() - 12);
                setNumberOfMoney(getNumberOfMoney() + 6);
                setNumberOfGlasses(getNumberOfGlasses() - 1);
            } else {
                System.out.println("I don`t have enough resources");
            }
        }
        else if (point == 4)
            CoffeeMachine.coffeeMachineAction();
        else
            System.out.println("Wrong number");
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
        System.out.println("I gave you " + getNumberOfMoney());
        setNumberOfMoney(0);

    }
}
