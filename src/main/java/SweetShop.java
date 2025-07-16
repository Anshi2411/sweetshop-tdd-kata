import java.util.*;


 // SweetShop class manages sweets inventory.

public class SweetShop {

    // Inventory map: stores sweets with ID as key
    private Map<Integer, Sweet> inventory = new HashMap<>();

    // Adds a new sweet to the inventory
    public void addSweet(Sweet sweet) {
        inventory.put(sweet.getId(), sweet);
    }

    /* Deletes a sweet from the inventory by ID */
    public void deleteSweet(int id) {
        inventory.remove(id);
    }

    /* Returns a list of all sweets in the inventory */
    public List<Sweet> viewSweets() {
        return new ArrayList<>(inventory.values());
    }

    /*
     * Purchases a sweet: checks if enough stock is available.
     * If not enough stock, throws OutOfStockException.
     * Otherwise reduces the sweet's quantity.
     */
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

    /*
     * Restocks a sweet: increases its quantity.
     * Throws IllegalArgumentException if sweet ID is invalid.
     */
    public void restockSweet(int id, int quantity) {
        Sweet sweet = inventory.get(id);
        if (sweet == null) {
            throw new IllegalArgumentException("Sweet not found");
        }
        sweet.setQuantity(sweet.getQuantity() + quantity);
    }

    /*
     * Searches sweets flexibly:
     * Can filter by name, category, minPrice, maxPrice.
     * Any filter can be skipped by passing null.
     */
    public List<Sweet> searchSweets(String name, String category, Double minPrice, Double maxPrice) {
        List<Sweet> results = new ArrayList<>();

        for (Sweet sw
