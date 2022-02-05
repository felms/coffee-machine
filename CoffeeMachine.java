import java.util.Scanner;

public class CoffeeMachine {

    static int money = 550;
    static int water = 400;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int disposableCups = 9;

    static Scanner scanner;

    public static void main(String[] args) {

        scanner = new Scanner(System.in);
        boolean finished = false;

        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
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
                case "remaining":
                    remaining();
                    break;
                case "exit":
                    finished = true;
                default:
                    break;
            }
        } while(!finished);

        scanner.close();
    }

    public static void remaining() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n",
                water, milk, coffeeBeans, disposableCups, money);
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        String option = scanner.nextLine();

        switch (option) {
            case "1":
                buyEspresso();
                break;
            case "2":
                buyLatte();
                break;
            case "3":
                buyCappuccino();
                break;
            case "back":
                return;
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

        if (espressoWater > water) {
            System.out.println("Sorry, not enough water!");
            return;
        }

        if (espressoCoffeeBeans > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

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

        if (latteWater > water) {
            System.out.println("Sorry, not enough water!");
            return;
        }

        if (latteMilk > milk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }

        if (latteCoffeeBeans > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

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

        if (cappuccinoWater > water) {
            System.out.println("Sorry, not enough water!");
            return;
        }

        if (cappuccinoMilk > milk) {
            System.out.println("Sorry, not enough milk!");
            return;
        }

        if (cappuccinoCoffeeBeans > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= cappuccinoWater;
        milk -= cappuccinoMilk;
        coffeeBeans -= cappuccinoCoffeeBeans;
        disposableCups--;
        money += cappuccinoPrice;
    }
}
