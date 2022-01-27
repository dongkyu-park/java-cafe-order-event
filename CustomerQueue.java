import java.util.HashMap;
import java.util.Map;

public class CustomerQueue {
    private static CustomerQueue instance = new CustomerQueue();
    private Map<String, Order> customerQueue;

    private CustomerQueue() {
        this.customerQueue = new HashMap<>();
    }

    public static CustomerQueue getInstance() {
        return instance;
    }

    public void add(Order order) {
        customerQueue.put(order.getOrderId(), order);
    }

    public boolean isEnd() {
        return customerQueue.isEmpty();
    }

    public boolean finishOneCoffee(Coffee coffee) {
        Order customersOrder = customerQueue.get(coffee.getOrderId());
        customersOrder.finishCoffee();

        if (orderIsFinish(customersOrder)) {
            customerQueue.remove(coffee.getOrderId());
            return true;
        }
        return false;
    }

    public boolean orderIsFinish(Order customersOrder) {
        return customersOrder.isFinish();
    }
}
