import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;

        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        System.out.printf("For %d cups of coffee you will need:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans",
                cups, (cups * water), (cups * milk), (cups * coffeeBeans));

        scanner.close();

    }
}
