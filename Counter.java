import java.util.Scanner;
import java.util.concurrent.CompletableFuture;

public class Counter {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("> 메뉴 = 1. 아메리카노(3s)  2. 카페라떼(5s)  3. 프라프치노(10s)");
        System.out.println("> 주문할 음료를 입력하세요. 예) 아메리카노 2개 => 1:2");
        System.out.print("> ");

        Cashier cashier = new Cashier();
        Manager manager = new Manager();
        Customer customerA = new Customer("A");
        Order orderA = new Order("A");

        String input = sc.nextLine();
        managerWorkAsync(manager);

        while (!input.equals("")) {
            String[] arr = input.split(":");
            int coffee = Integer.parseInt(arr[0]);
            int cup = Integer.parseInt(arr[1]);

            for (int i = 0; i < cup; i++) {
                orderA.addCoffeeOrder(coffee);
            }

            cashier.work(orderA);
            System.out.print("> ");
            input = sc.nextLine();
        }
    }

    public static CompletableFuture managerWorkAsync(Manager manager) {
//        Executor executor = Executors.newFixedThreadPool(10);

        return CompletableFuture.runAsync(() -> {
                    try {
                        manager.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).thenAccept(p -> System.out.println("모든 메뉴가 완성되었습니다."));
    }
}
