package Task1;

import java.util.ArrayList;
import java.util.List;

/*
Интернет магазин хочет повысить лояльность покупателей. Для этого начнет давать им персональные скидки.

Нужно сделать простую систему лояльности, которая дает % скидку на корзину.
Процент скидки зависит от пользователя.

Написать класс, который:
на вход получает id пользователя и корзину
вычисляет и применяет скидки
возвращает корзину, в которой учтены скидки
скидка учитывается в стоимости покупки

Корзина - список покупок пользователя.

Покупка:
id товара
цена
итоговая стоимость c учетом скидки

Скидка. Для пользователя может быть задан % скидки (целое число).
*/
public class LoyaltySystem {
    public List<User> users;
    public List<Purchase> purchases;

    public LoyaltySystem() {
        users = new ArrayList<>();
        purchases = new ArrayList<>();
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void addPurchase(int userId, int productId, double price) {
        User user = users.stream()
                        .filter(u -> u.id == userId)
                .findFirst()
                .orElse(null);
        if (user != null) {
            double discountedPrice = price - (price * user.discount / 100);
            purchases.add(new Purchase(productId, price, discountedPrice));
        }
    }

    public List<Purchase> calculateDiscounts() {
        return purchases;
    }

    public static void main(String[] args) {
        LoyaltySystem loyaltySystem = new LoyaltySystem();

        User user1 = new User(1, 10); // Task1.User with 10% discount
        User user2 = new User(2, 5);  // Task1.User with 5% discount

        loyaltySystem.addUser(user1);
        loyaltySystem.addUser(user2);

        loyaltySystem.addPurchase(1, 101, 100); // Task1.User 1 purchases product with id 101 and price 100
        loyaltySystem.addPurchase(2, 201, 150); // Task1.User 2 purchases product with id 201 and price 150

        List<Purchase> discountedPurchases = loyaltySystem.calculateDiscounts();

        for (Purchase purchase : discountedPurchases) {
            System.out.println("Product ID: " + purchase.productId + ", Price: " + purchase.price + ", Discounted Price: " + purchase.discountedPrice);
        }
    }
}