import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class SweetShopTest {

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

    @Test
    void testDeleteSweet() {
        SweetShop shop = new SweetShop();
        Sweet sweet = new Sweet(1003, "Dudhi Halwa", "Veg-Based", 30, 15);
        shop.addSweet(sweet);
        shop.deleteSweet(1003);
        assertEquals(0, shop.viewSweets().size());
    }

    @Test
    void testPurchaseSweetReducesStock() {
        SweetShop shop = new SweetShop();
        Sweet gulabJamun = new Sweet(1004, "Rashgolla", "Milk-Based", 10, 50);
        shop.addSweet(gulabJamun);

        shop.purchaseSweet(1004, 10);

        assertEquals(40, shop.viewSweets().get(0).getQuantity());
    }

    @Test
    void testPurchaseSweetThrowsIfNotEnoughStock() {
        SweetShop shop = new SweetShop();
        Sweet dryFruitHalwa = new Sweet(1005, "Dry Fruit Halwa", "Nut-Based", 30, 5);
        shop.addSweet(dryFruitHalwa);

        assertThrows(OutOfStockException.class, () -> {
            shop.purchaseSweet(1005, 10);
        });
    }

    @Test
    void testRestockSweetIncreasesQuantity() {
        SweetShop shop = new SweetShop();
        Sweet coconutBarfi = new Sweet(1006, "Coconut Barfi", "Nut-Based", 50, 10);
        shop.addSweet(coconutBarfi);

        shop.restockSweet(1006, 40);

        assertEquals(50, shop.viewSweets().get(0).getQuantity());
    }

    @Test
    void testRestockSweetThrowsIfSweetNotFound() {
        SweetShop shop = new SweetShop();

        assertThrows(IllegalArgumentException.class, () -> {
            shop.restockSweet(9999, 10);
        });
    }

    @Test
    void testSearchByNameReturnsMatchingSweets() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1007, "Badam Katli", "Nut-Based", 50, 10));
        shop.addSweet(new Sweet(1008, "Kesar Katli", "Nut-Based", 60, 8));
        shop.addSweet(new Sweet(1009, "Penda", "Milk-Based", 10, 50));

        List<Sweet> results = shop.searchByName("Katli");

        assertEquals(2, results.size());
        assertTrue(results.get(0).getName().contains("Katli"));
        assertTrue(results.get(1).getName().contains("Katli"));
    }

    @Test
    void testSearchByNameReturnsEmptyListIfNoMatch() {
        SweetShop shop = new SweetShop();
        shop.addSweet(new Sweet(1010, "Sondesh", "Milk-Based", 30, 20));

        List<Sweet> results = shop.searchByName("Halwa");

        assertEquals(0, results.size());
    }

}
