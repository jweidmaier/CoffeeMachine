public enum CoffeeOrder {
    ESPRESSO("1", 250, 0, 16, 1, 4),
    LATTE("2", 350, 75, 20, 1, 7),
    CAPPUCCINO("3", 200, 100, 12, 1, 6);

    private String orderNumber;
    private int water;
    private int milk;
    private int beans;
    private int cups;
    private int cost;

    CoffeeOrder(String orderNumber, int water, int milk, int beans, int cups, int cost) {
        this.orderNumber = orderNumber;
        this.water = water;
        this.milk = milk;
        this.beans = beans;
        this.cups = cups;
        this.cost = cost;
    }

    public String getOrderNumber() { return orderNumber; }
    public int getWater() { return water; }
    public int getMilk() { return milk; }
    public int getBeans() { return beans; }
    public int getCups() { return cups; }
    public int getCost() { return cost; }
}
