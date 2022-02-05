import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int water = 200;
        int milk = 50;
        int coffeeBeans = 15;

        System.out.println("Write how many ml of water the coffee machine has:");
        int totalWater = scanner.nextInt();

        System.out.println("Write how many ml of milk the coffee machine has:");
        int totalMilk = scanner.nextInt();

        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        int totalCoffeeBeans = scanner.nextInt();

        int w = totalWater / water;
        int m = totalMilk / milk;
        int c = totalCoffeeBeans / coffeeBeans;

        int totalCups = Math.min(w, m);
        totalCups = Math.min(totalCups, c);


        System.out.println("Write how many cups of coffee you will need:");
        int cups = scanner.nextInt();

        if (cups == totalCups) {
            System.out.println("Yes, I can make that amount of coffee");
        } else if(cups < totalCups) {
            System.out.printf("Yes, I can make that amount of coffee " +
                    "(and even %d more than that)",
                    (totalCups - cups));
        } else {
            System.out.printf("No, I can make only %d cup(s) of coffee", totalCups);
        }

        scanner.close();

    }
}
