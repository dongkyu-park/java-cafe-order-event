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
        customerQueue.put(order.getCustomerId(), order);
    }

    public boolean isEnd() {
        return customerQueue.isEmpty();
    }

    public void finishOneCoffee(String CustomerId) {
        Order customersOrder = customerQueue.get(CustomerId);
        customersOrder.finishCoffee();

        if (orderIsFinish(customersOrder)) {
            customerQueue.remove(CustomerId);
        }
    }

    public boolean orderIsFinish(Order customersOrder) {
        return customersOrder.isFinish();
    }
}
