import java.util.*;

public class SweetShop {
    private Map<Integer, Sweet> inventory = new HashMap<>();

    public void addSweet(Sweet sweet) {
        inventory.put(sweet.getId(), sweet);
    }


    public List<Sweet> viewSweets() {
        return new ArrayList<>(inventory.values());
    }
}
