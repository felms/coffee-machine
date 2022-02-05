import java.util.Scanner;

public class CoffeeMachine {

    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;

    static Scanner scanner;

    public static void main(String[] args) {

        printStatus();

        scanner = new Scanner(System.in);
        String action = scanner.nextLine();
        switch (action) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fill();
                break;
            case "take":
                take();
                break;
            default:
                break;
        }

        printStatus();

        scanner.close();
    }

    public static void printStatus() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n",
                water, milk, coffeeBeans, disposableCups, money);
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino:");
        int option = scanner.nextInt();

        switch (option) {
            case 1:
                buyEspresso();
                break;
            case 2:
                buyLatte();
                break;
            case 3:
                buyCappuccino();
                break;
            default:
                break;

        }

    }

    public static void fill() {
        System.out.println("Write how many ml of water you want to add:");
        water += scanner.nextInt();

        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();

        System.out.println("Write how many disposable cups of coffee you want to add:");
        coffeeBeans += scanner.nextInt();

        System.out.println("Write how many ml of water you want to add:");
        disposableCups += scanner.nextInt();

    }

    public static void take() {

        System.out.printf("I gave you $%d\n", money);
        money = 0;
    }

    public static void buyEspresso() {
        int espressoWater = 250;
        int espressoCoffeeBeans = 16;
        int espressoPrice = 4;

        water -= espressoWater;
        coffeeBeans -= espressoCoffeeBeans;
        disposableCups--;
        money += espressoPrice;
    }

    public static void buyLatte() {
        int latteWater = 350;
        int latteMilk = 75;
        int latteCoffeeBeans = 20;
        int lattePrice = 7;

        water -= latteWater;
        milk -= latteMilk;
        coffeeBeans -= latteCoffeeBeans;
        disposableCups--;
        money += lattePrice;
    }

    public static void buyCappuccino() {
        int cappuccinoWater = 200;
        int cappuccinoMilk = 100;
        int cappuccinoCoffeeBeans = 12;
        int cappuccinoPrice = 6;

        water -= cappuccinoWater;
        milk -= cappuccinoMilk;
        coffeeBeans -= cappuccinoCoffeeBeans;
        disposableCups--;
        money += cappuccinoPrice;
    }
}
