public class Cashier {
    private CoffeeQueue coffeeQueue = CoffeeQueue.getInstance();
    private CustomerQueue customerQueue = CustomerQueue.getInstance();

    public void work(Order order) {
        customerQueue.add(order);
        coffeeQueue.add(order);
    }
}
