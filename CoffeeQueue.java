import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class CoffeeQueue {
    private static CoffeeQueue instance = new CoffeeQueue();
    private Queue<Coffee> coffeeQueue;
    Menu menu = Menu.getInstance();

    private CoffeeQueue() {
        this.coffeeQueue = new LinkedList<>();
    }

    public static CoffeeQueue getInstance() {
        return instance;
    }

    public Coffee nextCoffee() {
        return this.coffeeQueue.poll();
    }

    public boolean noOrder() {
        return coffeeQueue.isEmpty();
    }

    public void add(Order order) {
        for (int i = 0; i < order.getOrderList().size(); i++) {
            int coffeeType = order.getOrderList().get(i);
            coffeeQueue.add(new Coffee(order.getOrderId(), order.getCustomerId(), coffeeType, menu.getCoffeeInfo(coffeeType).split(":")[0]));
        }
    }

    public void printQueue() {
        Iterator<Coffee> iterator = coffeeQueue.iterator();
        StringBuilder sb = new StringBuilder("/");

        while(iterator.hasNext()) {
            sb.append(iterator.next().getCoffeeType() + ",");
        }
        sb.deleteCharAt(sb.lastIndexOf(","));
        sb.append("/");
        System.out.println(sb.toString());
    }
}
