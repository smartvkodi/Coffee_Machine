package machine.model;

public enum Recipe {
    ESPRESSO(250, 0, 16, 0),
    LATTE(350, 75, 20, 0),
    CAPPUCCINO(200, 100, 12, 0),
    CORETTO(200, 0, 16, 50);

    private final int water;
    private final int milk;
    private final int coffee;
    private final int brandy;

    Recipe(int water, int milk, int coffee, int brandy) {
        this.water = water;
        this.milk = milk;
        this.coffee = coffee;
        this.brandy = brandy;
    }

    public int getWater() {
        return water;
    }

    public int getMilk() {
        return milk;
    }

    public int getCoffee() {
        return coffee;
    }

    public int getBrandy() {
        return brandy;
    }

}
