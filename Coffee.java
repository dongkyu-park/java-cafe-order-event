public class Coffee {
    private String orderId;
    private String customerId;
    private int coffeeType;
    private String coffeeName;

    public Coffee(String orderId, String customerId, int coffeeType, String coffeeName) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.coffeeType = coffeeType;
        this.coffeeName = coffeeName;
    }

    public String getOrderId() {
        return orderId;
    }

    public String getOwner() {
        return customerId;
    }

    public int getCoffeeType() {
        return coffeeType;
    }

    public String getCoffeeName() {
        return coffeeName;
    }
}
