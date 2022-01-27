import java.util.concurrent.CompletableFuture;

public class Manager {
    private CoffeeQueue coffeeQueue = CoffeeQueue.getInstance();
    private CustomerQueue customerQueue = CustomerQueue.getInstance();
    Barista barista = new Barista();

    public void work() throws InterruptedException {

        while (true) {
            if (customerQueue.isEnd()) {
//                System.out.println("주문이 없음");
                return;
            }
            if (barista.isBusy()) {
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
//        Executor executor = Executors.newFixedThreadPool(10);

        return CompletableFuture.supplyAsync(() -> {
            return barista.makeCoffee(coffee);
        }
        ).thenAccept((finishCoffee) -> {
            customerQueue.finishOneCoffee(finishCoffee.getOwner());
            System.out.println(finishCoffee.getCoffeeName() + " 완성");
        });
    }
}
