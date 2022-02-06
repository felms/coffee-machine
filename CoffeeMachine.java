public class CoffeeMachine {

    private int money;
    private int water;
    private int milk;
    private int coffeeBeans;
    private int disposableCups;
    private State state;
    private int addedValue;

    public CoffeeMachine(){
        money = 550;
        water = 400;
        milk = 540;
        coffeeBeans = 120;
        disposableCups = 9;
        addedValue = 0;
        state = State.MAIN_MENU;
    }

    public void chooseAction(String action) {

        if (this.state == State.MAIN_MENU) {
            mainMenu(action);
        } else if (this.state == State.COFFEE_MENU) {
            coffeeMenu(action);
        } else if (this.state.name().startsWith("FILLING")){
            this.addedValue = Integer.parseInt(action);
            fill();
        }

    }

    public State getState() {
        return this.state;
    }

    private void mainMenu(String action) {
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
            default:
                break;
        }
    }

    private void coffeeMenu(String action) {
        switch (action) {
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
                this.state = State.MAIN_MENU;
                return;
            default:
                break;

        }
    }

    private void remaining() {
        System.out.printf("The coffee machine has:\n" +
                "%d ml of water\n" +
                "%d ml of milk\n" +
                "%d g of coffee beans\n" +
                "%d disposable cups\n" +
                "$%d of money\n",
                water, milk, coffeeBeans, disposableCups, money);
    }

    private void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        this.state = State.COFFEE_MENU;
    }

    private void fill() {

        switch (this.state) {
            case MAIN_MENU:
                System.out.println("Write how many ml of water you want to add:");
                this.state = State.FILLING_WATER;
                break;
            case FILLING_WATER:
                fillWater(addedValue);
                System.out.println("Write how many ml of milk you want to add:");
                this.state = State.FILLING_MILK;
                break;
            case FILLING_MILK:
                fillMilk(addedValue);
                System.out.println("Write how many grams of coffee beans you want to add:");
                this.state = State.FILLING_COFFEE;
                break;
            case FILLING_COFFEE:
                fillCoffee(addedValue);
                System.out.println("Write how many disposable cups of coffee you want to add:");
                this.state = State.FILLING_CUPS;
                break;
            case FILLING_CUPS:
                fillCups(addedValue);
                this.state = State.MAIN_MENU;
                break;
            default:
                break;

        }

    }

    private void fillWater(int w) {
        water += w;
    }

    private void fillMilk(int m) {
        milk += m;
    }

    private void fillCoffee(int c) {
        coffeeBeans += c;
    }

    private void fillCups(int d) {
        disposableCups += d;
    }

    private void take() {

        System.out.printf("I gave you $%d\n", money);
        money = 0;
        this.state = State.MAIN_MENU;
    }

    private void buyEspresso() {
        int espressoWater = 250;
        int espressoCoffeeBeans = 16;
        int espressoPrice = 4;

        if (espressoWater > water) {
            System.out.println("Sorry, not enough water!");
            this.state = State.MAIN_MENU;
            return;
        }

        if (espressoCoffeeBeans > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            this.state = State.MAIN_MENU;
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= espressoWater;
        coffeeBeans -= espressoCoffeeBeans;
        disposableCups--;
        money += espressoPrice;
        this.state = State.MAIN_MENU;
    }

    private void buyLatte() {
        int latteWater = 350;
        int latteMilk = 75;
        int latteCoffeeBeans = 20;
        int lattePrice = 7;

        if (latteWater > water) {
            System.out.println("Sorry, not enough water!");
            this.state = State.MAIN_MENU;
            return;
        }

        if (latteMilk > milk) {
            System.out.println("Sorry, not enough milk!");
            this.state = State.MAIN_MENU;
            return;
        }

        if (latteCoffeeBeans > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            this.state = State.MAIN_MENU;
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= latteWater;
        milk -= latteMilk;
        coffeeBeans -= latteCoffeeBeans;
        disposableCups--;
        money += lattePrice;
        this.state = State.MAIN_MENU;
    }

    private void buyCappuccino() {
        int cappuccinoWater = 200;
        int cappuccinoMilk = 100;
        int cappuccinoCoffeeBeans = 12;
        int cappuccinoPrice = 6;

        if (cappuccinoWater > water) {
            System.out.println("Sorry, not enough water!");
            this.state = State.MAIN_MENU;
            return;
        }

        if (cappuccinoMilk > milk) {
            System.out.println("Sorry, not enough milk!");
            this.state = State.MAIN_MENU;
            return;
        }

        if (cappuccinoCoffeeBeans > coffeeBeans) {
            System.out.println("Sorry, not enough coffee beans!");
            this.state = State.MAIN_MENU;
            return;
        }

        System.out.println("I have enough resources, making you a coffee!");

        water -= cappuccinoWater;
        milk -= cappuccinoMilk;
        coffeeBeans -= cappuccinoCoffeeBeans;
        disposableCups--;
        money += cappuccinoPrice;
        this.state = State.MAIN_MENU;
    }
}
