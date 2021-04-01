package machine.model;

import java.util.ArrayList;
import java.util.List;

public class CoffeeMachine extends AbstractCoffeeMachine {

    private static final List<HotDrink> drinks;

    public CoffeeMachine(int water, int milk, int coffee, int cups, int brandy, int money) {
        super(water, milk, coffee, cups, brandy, money);
    }

    static {
        HotDrink espresso = new HotDrink(1, "espresso", 4, Recipe.ESPRESSO);
        HotDrink latte = new HotDrink(2, "latte", 7, Recipe.LATTE);
        HotDrink cappuccino = new HotDrink(3, "cappuccino", 6, Recipe.CAPPUCCINO);
        HotDrink coretto = new HotDrink(4, "coretto", 9, Recipe.CORETTO);

        drinks = new ArrayList<>();
        drinks.add(espresso);
        drinks.add(latte);
        drinks.add(cappuccino);
        drinks.add(coretto);
    }

    @Override
    protected void sellCoffeeCup(int id) {
        HotDrink drink = getDrinkById(id);
        if (drink != null) {
            StringBuilder sb = new StringBuilder();

            Recipe recipe = drink.getRecipe();
            int water = recipe.getWater();
            int milk = recipe.getMilk();
            int coffee = recipe.getCoffee();
            int brandy = recipe.getBrandy();

            if (cupsStock < 1) {
                sb.append("\nSorry, no more cups! ");
            }
            if (water > 0 && unitsOfWater(water) < 1) {
                sb.append("\nSorry, not enough water! ");
            }
            if (milk > 0 && unitsOfMilk(milk) < 1) {
                sb.append("\nSorry, not enough milk! ");
            }
            if (coffee > 0 && unitsOfCoffee(coffee) < 1) {
                sb.append("\nSorry, not enough milk! ");
            }
            if (brandy > 0 && unitsOfBrandy(brandy) < 1) {
                sb.append("\nSorry, not enough brandy! ");
            }

            if (sb.length() == 0) {
                cupsStock--;
                waterStock -= water;
                milkStock -= milk;
                coffeeStock -= coffee;
                brandyStock -= brandy;
                money += drink.getPrice();
                sb.append("\nI have enough resources, making you a coffee! ");
            }

            System.out.println(sb.toString());
        }
    }

    private HotDrink getDrinkById(int id) {
        for (HotDrink hotDrink : drinks) {
            if (hotDrink.getId() == id) {
                return hotDrink;
            }
        }
        return null;
    }

    public static List<HotDrink> getDrinks() {
        return drinks;
    }

    private int unitsOfWater(int water) {
        return waterStock / water;
    }

    private int unitsOfMilk(int milk) {
        return milkStock / milk;
    }

    private int unitsOfCoffee(int coffee) {
        return coffeeStock / coffee;
    }

    private int unitsOfBrandy(int brandy) {
        return brandyStock / brandy;
    }

}
