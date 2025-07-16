import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SweetShopTest {

    //  Test adding multiple sweets to the inventory
    @Test
    void testAddSweet() {
        SweetShop shop = new SweetShop();
        Sweet gajarHalwa = new Sweet(1000, "Gajar Halwa", "Veg-Based", 30, 15);
        Sweet kajuKatli = new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20);
        Sweet barfi = new Sweet(1002, "Barfi", "Milk-Based", 100, 20);
        shop.addSweet(kajuKatli);
        shop.addSweet(barfi);
        shop.addSweet(gajarHalwa);
        assertEquals(3, shop.viewSweets().size());
    }

    //  Test deleting a sweet by ID
    @Test
    void testDeleteSweet() {
        SweetShop shop = new SweetShop();
        Sweet sweet = new Sweet(1003, "Dudhi Halwa", "Veg-Based", 30, 15);
        shop.addSweet(sweet);
        shop.deleteSweet(1003);
        assertEquals(0, shop.viewSweets().size());
    }

    //  Test purchasing sweet reduces stock correctly when enough stock is available
    @Test
    void testPurchaseSweetReducesStock() {
        SweetShop shop = new SweetShop();
        Sweet rasgulla = new Sweet(1004, "Rasgulla", "Milk-Based", 10, 50);
        shop.addSweet(rasgulla);

        shop.purchaseSweet(1004, 10);

        assertEquals(40, shop.viewSweets().get(0).getQuantity());
    }

    //  Test purchasing more than available stock throws OutOfStockException
    @Test
    void testPurchaseSweetThrowsIfNotEnoughStock() {
        SweetShop shop = new SweetShop();
        Sweet dryFruitHalwa = new Sweet(1005, "Dry Fruit Halwa", "Nut-Based", 30, 5);
        shop.addSweet(dryFruitHalwa);

        assertThrows(OutOfStockException.class, () -> {
            shop.purchaseSweet(1005, 10);
        });
    }

    //  Test restocking sweet increases the quantity correctly
    @Test
    void testRestockSweetIncreasesQuantity() {
        SweetShop shop = new SweetShop();
        Sweet coconutBarfi = new Sweet(1006, "Coconut Barfi", "Nut-Based", 50, 10);
        shop.addSweet(coconutBarfi);

        shop.restockSweet(1006, 40);

        assertEquals(50, shop.viewSweets().get(0).getQuantity());
    }

    //  Test restocking with invalid ID throws IllegalArgumentException
    @Test
    void testRestockSweetThrowsIfSweetNotFound() {
        SweetShop shop = new SweetShop();

        assertThrows(IllegalArgumentException.class, () -> {
            shop.restockSweet(9999, 10);
        });
    }

    //  Test combined search by name only
    @Test
    void testSearchSweetsByNameOnly() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1007, "Badam Katli", "Nut-Based", 50, 10));
        shop.addSweet(new Sweet(1008, "Kesar Katli", "Nut-Based", 60, 8));
        shop.addSweet(new Sweet(1009, "Penda", "Milk-Based", 10, 50));

        List<Sweet> results = shop.searchSweets("Katli", null, null, null);

        assertEquals(2, results.size());
    }

    //  Test combined search by category only
    @Test
    void testSearchSweetsByCategoryOnly() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1010, "Kaju Katli", "Nut-Based", 50, 10));
        shop.addSweet(new Sweet(1011, "Kesar Katli", "Nut-Based", 60, 8));
        shop.addSweet(new Sweet(1012, "Barfi", "Milk-Based", 30, 20));

        List<Sweet> results = shop.searchSweets(null, "Nut-Based", null, null);

        assertEquals(2, results.size());
    }

    //  Test combined search by price range only
    @Test
    void testSearchSweetsByPriceRangeOnly() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1013, "Barfi", "Milk-Based", 30, 20));
        shop.addSweet(new Sweet(1014, "Gulab Jamun", "Milk-Based", 10, 50));
        shop.addSweet(new Sweet(1015, "Kaju Katli", "Nut-Based", 50, 10));

        List<Sweet> results = shop.searchSweets(null, null, 20.0, 40.0);

        assertEquals(1, results.size());
        assertEquals("Barfi", results.get(0).getName());
    }

    //  Test combined search by name, category and price range
    @Test
    void testSearchSweetsByAllCriteria() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1016, "Kesar Katli", "Nut-Based", 60, 8));
        shop.addSweet(new Sweet(1017, "Kaju Katli", "Nut-Based", 50, 10));
        shop.addSweet(new Sweet(1018, "Barfi", "Milk-Based", 30, 20));

        List<Sweet> results = shop.searchSweets("Katli", "Nut-Based", 40.0, 55.0);

        assertEquals(1, results.size());
        assertEquals("Kaju Katli", results.get(0).getName());
    }

    // Test combined search returns empty list when no match found
    @Test
    void testSearchSweetsReturnsEmptyIfNoMatch() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1019, "Sondesh", "Milk-Based", 30, 20));

        List<Sweet> results = shop.searchSweets("Katli", "Nut-Based", 40.0, 55.0);

        assertEquals(0, results.size());
    }
}
