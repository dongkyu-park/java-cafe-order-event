public class Coffee {
    private String owner;
    private int coffeeType;
    private String coffeeName;

    public Coffee(String owner, int coffeeType, String coffeeName) {
        this.owner = owner;
        this.coffeeType = coffeeType;
        this.coffeeName = coffeeName;
    }

    public String getOwner() {
        return owner;
    }

    public int getCoffeeType() {
        return coffeeType;
    }

    public String getCoffeeName() {
        return coffeeName;
    }
}
