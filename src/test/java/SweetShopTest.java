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




}
