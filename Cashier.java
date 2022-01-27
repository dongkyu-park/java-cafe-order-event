public class Cashier {
    private CoffeeQueue coffeeQueue = CoffeeQueue.getInstance();
    private OrderQueue customerQueue = OrderQueue.getInstance();

    public void work(Order order) {
        customerQueue.add(order);
        coffeeQueue.add(order);
        coffeeQueue.printQueue();
    }
}
