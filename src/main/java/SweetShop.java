import java.util.*;

public class SweetShop {
    private Map<Integer, Sweet> inventory = new HashMap<>();

    public void addSweet(Sweet sweet) {
        inventory.put(sweet.getId(), sweet);
    }

    public void deleteSweet(int id) {
        inventory.remove(id);
    }

    public List<Sweet> viewSweets() {
        return new ArrayList<>(inventory.values());
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

    public List<Sweet> searchSweets(String name, String category, Double minPrice, Double maxPrice) {
        List<Sweet> results = new ArrayList<>();

        for (Sweet sweet : inventory.values()) {
            boolean matches = true;

            if (name != null && !sweet.getName().toLowerCase().contains(name.toLowerCase())) {
                matches = false;
            }

            if (category != null && !sweet.getCategory().equalsIgnoreCase(category)) {
                matches = false;
            }

            if (minPrice != null && sweet.getPrice() < minPrice) {
                matches = false;
            }

            if (maxPrice != null && sweet.getPrice() > maxPrice) {
                matches = false;
            }

            if (matches) {
                results.add(sweet);
            }
        }

        return results;
    }
}
