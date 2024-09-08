package Task1;

public class Purchase {
    public int productId;
    public double price;
    double discountedPrice;

    public Purchase(int productId, double price, double discountedPrice) {
        this.productId = productId;
        this.price = price;
        this.discountedPrice = discountedPrice;
    }
}