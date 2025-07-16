import java.util.*;

public class SweetShop {
    private Map<Integer, Sweet> inventory = new HashMap<>();

    public void addSweet(Sweet sweet) {
        inventory.put(sweet.getId(), sweet);
    }


    public List<Sweet> viewSweets() {
        return new ArrayList<>(inventory.values());
    }
    public void deleteSweet(int id) {
        inventory.remove(id);
    }
    public void purchaseSweet(int id, int quantity) {
        Sweet sweet = inventory.get(id);
        if (sweet == null) {
            throw new IllegalArgumentException("Sweet not found");
        }
        if (sweet.getQuantity() < quantity) {
            throw new OutOfStockException("Not enough stock");
        }
        sweet.setQuantity(sweet.getQuantity() - quantity);
    }

    public void restockSweet(int id, int quantity) {
        Sweet sweet = inventory.get(id);
        if (sweet == null) {
            throw new IllegalArgumentException("Sweet not found");
        }
        sweet.setQuantity(sweet.getQuantity() + quantity);
    }

    public List<Sweet> searchByName(String name) {
        List<Sweet> results = new ArrayList<>();
        for (Sweet sweet : inventory.values()) {
            if (sweet.getName().toLowerCase().contains(name.toLowerCase())) {
                results.add(sweet);
            }
        }
        return results;
    }


}
