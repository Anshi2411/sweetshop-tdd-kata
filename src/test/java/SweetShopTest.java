import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SweetShopTest {

    @Test
    void testAddSweet() {
        SweetShop shop = new SweetShop();
        Sweet kajuKatli = new Sweet(1001, "Kaju Katli", "Nut-Based", 50, 20);
        shop.addSweet(kajuKatli);
        assertEquals(1, shop.viewSweets().size());
    }
}
