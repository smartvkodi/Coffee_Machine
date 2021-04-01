package machine.model;

import java.util.List;

public enum MachineState {
    NOT_POWERED("\nMachine is powered off"),
    DEFAULT_MENU("\nWrite action (buy, fill, take, remaining, exit): "),
    VARIANT_DRINK_MENU(getVariantDrinkMenuMessage()),
    ADD_WATER_MENU("\nWrite how many ml of water do you want to add: "),
    ADD_MILK_MENU("\nWrite how many ml of milk do you want to add: "),
    ADD_COFFEE_MENU("\nWrite how many grams of coffee beans do you want to add: "),
    ADD_CUPS_MENU("\nWrite how many disposable cups of coffee do you want to add: ");

    private final String message;

    MachineState(String message) {
        this.message = message;
    }

    private static String getVariantDrinkMenuMessage() {
        StringBuilder sb = new StringBuilder("\nWhat do you want to buy? ");
        List<HotDrink> drinks = CoffeeMachine.getDrinks();
        for (HotDrink drink : drinks) {
            sb.append(String.format("%d - %s, ", drink.getId(), drink.getName()));
        }
        sb.append(" back - to main menu: ");
        return sb.toString();
    }


    public String getMessage() {
        return this.message;
    }
}
