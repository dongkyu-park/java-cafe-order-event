import java.util.HashMap;
import java.util.Map;

public class Menu {
    private static Menu instance = new Menu();
    private Map<Integer, String> menu;

    private Menu() {
        this.menu = new HashMap() {
            {
                put(1, "아메리카노:3000");
                put(2, "카페라떼:5000");
                put(3, "프라프치노:10000");
            }
        };
    }

    public static Menu getInstance() {
        return instance;
    }

    public String getCoffeeInfo(int coffeeId) {
        return menu.get(coffeeId);
    }
}
