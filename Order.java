import java.util.ArrayList;

public class Order {
    private ArrayList<Integer> orderList;
    private String customerId;
    private int orderCount;
    private int finishCount;

    public Order(String customerId) {
        this.orderList = new ArrayList<>();
        this.customerId = customerId;
        this.orderCount = 0;
        this.finishCount = 0;
    }

    public void addCoffeeOrder(int coffeeType) {
        orderList.add(coffeeType);
        orderCount++;
    }

    public void finishCoffee() {
        finishCount++;
    }

    public String getCustomerId() {
        return customerId;
    }

    public ArrayList<Integer> getOrderList() {
        return orderList;
    }

    public boolean isFinish() {
        return orderCount == finishCount;
    }
}
