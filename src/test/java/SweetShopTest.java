import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SweetShopTest {

    @Test
    void testAddSweet() {
        SweetShop shop = new SweetShop();
        Sweet kajuKatli = new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20);
        Sweet barfi = new Sweet(1002, "Barfi", "Milk-Based", 100, 20);
        shop.addSweet(kajuKatli);
        shop.addSweet(barfi);
        assertEquals(2, shop.viewSweets().size());
    }

    @Test
    void testDeleteSweet() {
        SweetShop shop = new SweetShop();
        Sweet sweet = new Sweet(1003, "Gajar Halwa", "Veg-Based", 30, 15);
        shop.addSweet(sweet);
        shop.deleteSweet(1003);
        assertEquals(0, shop.viewSweets().size());
    }

//    @Test
//    void testPurchaseSweetReducesStock() {
//        SweetShop shop = new SweetShop();
//        Sweet gulabJamun = new Sweet(1004, "Gulab Jamun", "Milk-Based", 10, 50);
//        shop.addSweet(gulabJamun);
//
//        shop.purchaseSweet(1004, 10);
//
//        assertEquals(40, shop.viewSweets().get(0).getQuantity());
//    }

    @Test
    void testPurchaseSweetThrowsIfNotEnoughStock() {
        SweetShop shop = new SweetShop();
        Sweet gajarHalwa = new Sweet(1005, "Gajar Halwa", "Veg-Based", 30, 5);
        shop.addSweet(gajarHalwa);

        assertThrows(OutOfStockException.class, () -> {
            shop.purchaseSweet(1005, 10);
        });
    }

//    @Test
//    void testRestockSweetIncreasesQuantity() {
//        SweetShop shop = new SweetShop();
//        Sweet coconutBarfi = new Sweet(1006, "Coconut Barfi", "Nut-Based", 50, 10);
//        shop.addSweet(coconutBarfi);
//
//        shop.restockSweet(1006, 40);
//
//        assertEquals(50, shop.viewSweets().get(0).getQuantity());
//    }

    @Test
    void testRestockSweetThrowsIfSweetNotFound() {
        SweetShop shop = new SweetShop();

        assertThrows(IllegalArgumentException.class, () -> {
            shop.restockSweet(9999, 10);
        });
    }

}
