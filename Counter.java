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

        managerWorkAsync(manager, sc);

        while (true) {
            Order order = orderMaker(sc.nextLine());
            cashier.work(order);
        }
    }

    public static Order orderMaker(String input) {
        Order orderA = new Order("A");

        String[] arr = input.split(":");
        int coffee = Integer.parseInt(arr[0]);
        int cup = Integer.parseInt(arr[1]);

        for (int i = 0; i < cup; i++) {
            orderA.addCoffeeOrder(coffee);
        }

        return orderA;
    }

    public static CompletableFuture managerWorkAsync(Manager manager, Scanner sc) {
        return CompletableFuture.runAsync(() -> {
                    try {
                        manager.work();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
        ).thenAccept(p -> {
            System.out.println("모든 메뉴가 완성되었습니다.");
            System.exit(0);
        });
    }
}
