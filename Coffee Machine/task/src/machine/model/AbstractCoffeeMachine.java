package machine.model;

public abstract class AbstractCoffeeMachine {
    public static boolean isPowered = false;
    int waterStock;
    int milkStock;
    int coffeeStock;
    int cupsStock;
    int brandyStock;
    int money;

    private MachineState machineState = MachineState.NOT_POWERED;

    public AbstractCoffeeMachine(int waterStock, int milkStock, int coffeeStock, int cupsStock, int brandyStock, int money) {
        this.waterStock = waterStock;
        this.milkStock = milkStock;
        this.coffeeStock = coffeeStock;
        this.cupsStock = cupsStock;
        this.brandyStock = brandyStock;
        this.money = money;
    }

    public void powerOn() {
        isPowered = true;
        this.machineState = MachineState.DEFAULT_MENU;
    }

    public void powerOff() {
        isPowered = false;
        this.machineState = MachineState.NOT_POWERED;
    }

    public void compute(String input) {
        int value = convertToOptionInteger(input);

        switch (this.machineState) {
            case DEFAULT_MENU:
                // buy, fill, take, remaining, exit
                if ("buy".equals(input)) {
                    this.machineState = MachineState.VARIANT_DRINK_MENU;
                } else if ("fill".equals(input)) {
                    this.machineState = MachineState.ADD_WATER_MENU;
                } else if ("take".equals(input)) {
                    money = 0;
                } else if ("remaining".equals(input)) {
                    displayInventory();
                } else if ("exit".equals(input)) {
                    powerOff();
                }
                break;
            case VARIANT_DRINK_MENU:
                if (value > 0) {
                    sellCoffeeCup(value);
                }
                this.machineState = MachineState.DEFAULT_MENU;
                break;
            case ADD_WATER_MENU:
                if (value > 0) {
                    waterStock += value;
                }
                this.machineState = MachineState.ADD_MILK_MENU;
                break;
            case ADD_MILK_MENU:
                if (value > 0) {
                    milkStock += value;
                }
                this.machineState = MachineState.ADD_COFFEE_MENU;
                break;
            case ADD_COFFEE_MENU:
                if (value > 0) {
                    coffeeStock += value;
                }
                this.machineState = MachineState.ADD_CUPS_MENU;
                break;
            case ADD_CUPS_MENU:
                if (value > 0) {
                    cupsStock += value;
                }
                this.machineState = MachineState.DEFAULT_MENU;
                break;
            default:
                break;
        }
    }

    protected abstract void sellCoffeeCup(int value);

    private void displayInventory() {
        String sb = "\nThe coffee machine has: \n" +
                String.format("%d of water\n", waterStock) +
                String.format("%d of milk\n", milkStock) +
                String.format("%d of coffee beans\n", coffeeStock) +
                String.format("%d of brandy\n", brandyStock) +
                String.format("%d of disposable cups\n", cupsStock) +
                String.format("$%d of money", money);
        System.out.println(sb);
    }

    private int convertToOptionInteger(String input) {
        int index = -1;
        try {
            index = Integer.parseInt(input);
            if (index < 0) {
                throw new NumberFormatException();
            }
        } catch (NumberFormatException e) {
            // do not worry
        }
        return index;
    }

    public void displayMenu() {
        System.out.println(this.machineState.getMessage());
    }

}

