import java.util.concurrent.CompletableFuture;

public class Manager {
    public static final int MAX_WAITING_TIME = 5;

    private CoffeeQueue coffeeQueue = CoffeeQueue.getInstance();
    private OrderQueue customerQueue = OrderQueue.getInstance();
    private int waitingTime;
    Barista barista = new Barista();

    public void work() throws InterruptedException {
        while (true) {
            if (customerQueue.isEnd()) {
                Thread.sleep(1000);
                waitingTime++;

                if (waitingTime == MAX_WAITING_TIME) {
                    return;
                }
                continue;
            }
            if (waitingTime > 0) {
                waitingTime = 0;
            }
            if (barista.isBusy()) { // 바리스타가 2개의 커피를 제조중이라면, sleep
                Thread.sleep(1000);
                continue;
            }
            if (!coffeeQueue.noOrder()) { // coffeeQueue에 주문이 존재 한다면, 바리스타에게 메세지
                Coffee coffee = coffeeQueue.nextCoffee();
                orderBaristaMakeCoffee(barista, coffee);
            }

            Thread.sleep(1000); // 1초마다 반복
        }
    }

    public CompletableFuture orderBaristaMakeCoffee(Barista barista, Coffee coffee) {
        return CompletableFuture.supplyAsync(() -> {
            return barista.makeCoffee(coffee);
        }
        ).thenAccept((finishCoffee) -> {
            System.out.println(finishCoffee.getCoffeeName() + " 완성");
            if (customerQueue.finishOneCoffee(finishCoffee)) {
                System.out.println("===== " + coffee.getOwner() + ", 주문 완성");
            }
        });
    }
}
