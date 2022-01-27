import java.util.HashMap;
import java.util.Map;

public class OrderQueue {
    private static OrderQueue instance = new OrderQueue();
    private Map<String, Order> orderQueue;

    private OrderQueue() {
        this.orderQueue = new HashMap<>();
    }

    public static OrderQueue getInstance() {
        return instance;
    }

    public void add(Order order) {
        orderQueue.put(order.getOrderId(), order);
    }

    public boolean isEnd() {
        return orderQueue.isEmpty();
    }

    public boolean finishCupOfCoffee(Coffee coffee) {
        Order customersOrder = orderQueue.get(coffee.getOrderId());
        customersOrder.finishCoffee();

        if (orderIsFinish(customersOrder)) {
            orderQueue.remove(coffee.getOrderId());
            return true;
        }
        return false;
    }

    public boolean orderIsFinish(Order customersOrder) {
        return customersOrder.isFinish();
    }
}
