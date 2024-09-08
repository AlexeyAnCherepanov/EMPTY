package Task1.Test;

import Task1.LoyaltySystem;
import Task1.User;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoyaltySystemTest {

    // Тест на добавление пользователя в систему:
    @Test
    public void testAddUser() {
        LoyaltySystem loyaltySystem = new LoyaltySystem();
        User user = new User(1, 10);

        loyaltySystem.addUser(user);

        assertEquals(1, loyaltySystem.users.size());
        assertEquals(1, loyaltySystem.users.get(0).id);
        assertEquals(10, loyaltySystem.users.get(0).discount);
    }

    @Test
    public void testAddPurchaseExistingUser() {
        LoyaltySystem loyaltySystem = new LoyaltySystem();
        User user = new User(1, 10);
        loyaltySystem.addUser(user);

        loyaltySystem.addPurchase(1, 101, 100);

        assertEquals(1, loyaltySystem.purchases.size());
        assertEquals(101, loyaltySystem.purchases.get(0).productId);
        assertEquals(100, loyaltySystem.purchases.get(0).price);
    }
}