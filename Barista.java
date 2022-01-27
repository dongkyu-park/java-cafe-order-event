import java.util.LinkedList;
import java.util.Queue;

public class Barista {
    public static final int MAX_WORK = 2;

    private Queue<Coffee> workQueue;
    private Menu menu = Menu.getInstance();

    public Barista() {
        this.workQueue = new LinkedList<>();
    }

    public boolean isBusy() {
        return workQueue.size() == MAX_WORK;
    }

    public Coffee makeCoffee(Coffee coffee) {
        System.out.println(coffee.getCoffeeName() + " 시작");
        workQueue.add(coffee);

        int timeTakes = Integer.parseInt(menu.getCoffeeInfo(coffee.getCoffeeType()).split(":")[1]);

        try {
            Thread.sleep(timeTakes);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        return workQueue.poll();
    }
}
