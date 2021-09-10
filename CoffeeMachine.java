import java.util.Scanner;

public class CoffeeMachine {
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int money;

    public CoffeeMachine() {
        this.water = 400;
        this.milk = 540;
        this.beans = 120;
        this.cups = 9;
        this.money = 550;
    }

    public int getWater() { return this.water; }

    public int getMilk() { return this.milk; }

    public int getBeans() { return this.beans; }

    public int getCups() { return this.cups; }

    public int getMoney() { return this.money; }

    public static void main(String[] args) {
        CoffeeMachine machine = new CoffeeMachine();
        machine.run();
    }

    public void run() {
        remaining();
        Scanner scanner = new Scanner(System.in);
        String action = null;
        do {
            System.out.println("Write action (buy, fill, take, remaining, exit):");
            action = scanner.nextLine();
            switch (action) {
                case "remaining":
                    remaining();
                    break;
                case "buy":
                    buy();
                    break;
                case "fill":
                    fill(scanner);
                    break;
                case "take":
                    take();
                    break;
                default:
                    if (!action.equals("exit")) {
                        System.out.println("Not a valid action");
                    }
                    break;
            }
        } while (!action.equals("exit"));
    }

    public void remaining() {
        System.out.println("\n" + "The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money \n");
    }

    public void fill(Scanner scanner) {
        System.out.println("\n" + "Write how many ml of water you want to add:");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk you want to add:");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee you want to add:");
        cups += scanner.nextInt();
        scanner.nextLine();
        System.out.println("");
    }

    public void buy() {
        System.out.println("\n" + "What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu:");
        Scanner scanner = new Scanner(System.in);
        String choice = scanner.nextLine();
        CoffeeOrder purchase = null;
        for (CoffeeOrder o : CoffeeOrder.values()) {
            if (o.getOrderNumber().equals(choice)) {
                purchase = o;
            }
        }
        if (choice.equals("back")) {
            System.out.println("Going back to main menu \n");
        } else if (purchase == null) {
            System.out.println("Not a valid entry");
        } else {
            boolean able = enoughSupplies(purchase);
            if (able) {
                water -= purchase.getWater();
                milk -= purchase.getMilk();
                beans -= purchase.getBeans();
                cups -= purchase.getCups();
                money += purchase.getCost();
            }
        }
    }

    private boolean enoughSupplies(CoffeeOrder order) {
       if (cups < order.getCups()) {
           System.out.println("Sorry, not enough cups! \n");
           return false;
       } else if (water < order.getWater()) {
           System.out.println("Sorry, not enough water! \n");
           return false;
       } else if (milk < order.getMilk()) {
           System.out.println("Sorry, not enough milk! \n");
           return false;
       } else if (beans < order.getBeans()) {
           System.out.println("Sorry, not enough beans! \n");
           return false;
       } else {
           System.out.println("I have enough resources, making you a coffee! \n");
           return true;
       }
    }

    public void take() {
        System.out.println("\n" + "I gave you $" + money + "\n");
        money = 0;

        System.out.println("The coffee machine has:");
        System.out.println(water + " ml of water");
        System.out.println(milk + " ml of milk");
        System.out.println(beans + " grams of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money \n");
    }
}
