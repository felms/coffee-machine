import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean finished = false;
        CoffeeMachine coffeeMachine = new CoffeeMachine();

        do {
            if (coffeeMachine.getState() == State.MAIN_MENU) {
                mainMenu();
            }
            String action = scanner.nextLine();
            if("exit".equals(action)) {
                finished = true;
            } else {
                coffeeMachine.chooseAction(action);
            }

        } while(!finished);

        scanner.close();

    }

    public static void mainMenu() {
        System.out.println("Write action (buy, fill, take, remaining, exit):");
    }
}
