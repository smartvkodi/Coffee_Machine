package machine.model;

public class HotDrink {
    private final int id;
    private final String name;
    private final int price;
    private final Recipe recipe;

    public HotDrink(int id, String name, int price, Recipe recipe) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.recipe = recipe;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public Recipe getRecipe() {
        return recipe;
    }
}


